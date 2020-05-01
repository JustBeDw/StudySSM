# StudySSM
<em>Spring+SpringMVC+Mybatis+Spring Security+PageHelper</em> <br/>
<em>DataBase:MySQL 5.7</em> <br/>
后台管理系统<br/>
此项目为整合SSM的学习项目，对Spring的学习进行一次实操，此版本 <strong>注解+xml</strong> 混合配置，整合完毕可以尝试纯注解的写法。<br/>
登陆使用Spring Security完成认证操作，首先对账户密码进行核实，其次对权限进行认证，最后方可访问。<br/>
登陆之后，可进行订单、用户、权限、资源 的crud操作。<br/>
基本都是视图由model获取进行展示，controller-->service-->dao，完成crud操作。<br/>
若想深入了解Spring-->建议看《Spring技术内幕》
