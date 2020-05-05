package com.ssm.controller;

import com.ssm.entity.SysLog;
import com.ssm.service.ISysService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Administrator
 * @date 2020-05-02 21:42
 */

@Component
@Aspect
public class LogAop {

    /**
     * 开始时间
     */
    private Date date;

    /**
     * 访问的类
     */
    private Class clazz;

    /**
     * 访问的方法
     */
    private Method method;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysService iSysService;

    /**
     * 前置通知
     * 获取开始时间，获取被执行的类和方法，
     * @param joinPoint
     */
    @Before("execution(* com.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        date = new Date();
        clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[]args = joinPoint.getArgs();

        //获取具体方法的method对象
        //无参方法
        if (args==null||args.length==0){
            //通过访问的类获取访问的方法
            method = clazz.getMethod(methodName);
        }
        //有参方法
        else{
            Class [] classArgs = new Class[args.length];
            for (int i=0;i<args.length;i++){
                classArgs[i]=args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }
    }


    /**
     * 后置通知
     * @param joinPoint
     */
    @After("execution(* com.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        //获取访问时长
        long time = System.currentTimeMillis() - date.getTime();
        String url = "";
        if (clazz!=null&&clazz!=LogAop.class&&method!=null){
            //获取类上的注解RequestMapping
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null){
                //获取类上注解的地址RequestMapping("/..")
                String[]classValues = classAnnotation.value();

                //获取方法上注解的地址RequestMapping("/..")
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null){
                    String [] methodValues = methodAnnotation.value();
                    //拼接类和方法地址
                    url = classValues[0] + methodValues[0];


                    //获取IP地址
                    String ip = request.getRemoteAddr();


                    //获取访问者id
                    //Spring Security提供的SecurityContext从上下文获取当前用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    //获取当前用户对象
                    User user = (User) context.getAuthentication().getPrincipal();
                    //获取当前用户id
                    String username = user.getUsername();

                    //将日志信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("类名"+clazz.getName()+"方法名"+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(date);

                    //调用SysService完成新增
                    iSysService.save(sysLog);
                }
            }
        }
    }

}
