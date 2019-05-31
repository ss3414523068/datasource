# datasource
持久层<br>

************************************************************************************************************************

# java_jdbc
①JDK6<br>
②Java JDBC<br>

# java_mybatis
①JDK6<br>
②Java整合MyBatis<br>
在Java中直接使用MyBatis框架需要读取配置，手动构造SqlSessionFactory/SqlSession<br>

# ss_mybatis
①JDK6<br>
②Spring/SpringMVC整合原生MyBatis<br>
在Spring中配置SqlSessionFactoryBean/MapperScannerConfigurer（新版）<br>
③com包（原生MyBatis）<br>
Mybatis Generator Maven插件<br>
PageHelper插件（可独立于通用Mapper使用）<br>
Druid监控（需要配置web.xml）<br>
④mybatis包<br>
MyBatisController1+Test1Mapper（系统学习）<br>
MyBatisController2+Test2Mapper（自行总结）<br>

# ss_mapper
①JDK6<br>
②Spring/SpringMVC整合通用Mapper<br>
在Spring中配置SqlSessionFactoryBean/MapperScannerConfigurer（TK版）/SqlSessionTemplate<br>
PageHelper插件<br>
MyMapper需要单独配置<br>

# ss_mybatisplus
①JDK8<br>
②Spring4+MyBatis-Plus3+MBP Generator（slf4j-api/freemarker/lombok）<br>
③Spring/SpringMVC整合MyBatis-Plus3<br>
在Spring中配置SqlSessionFactoryBean（MBP版）/MapperScannerConfigurer<br>
分页插件<br>
④实体类不能重复<br>

# springboot_mybatisplus
①JDK8<br>
②SpringBoot2.1.3+mybatis-plus-boot-starter3.1.0+MBP Generator（freemarker/lombok）<br>
（mysql-connector-java runtime会报错）<br>
③SpringBoot2整合mybatis-plus-boot-starter3.1.0<br>
推荐写法：DataSourceConfig（model/mapper/XML/分页）<br>
传统写法：Application（mapper/分页）+application.properties（XML）<br>
④dyna包（动态表结构）<br>
参考RBAC，多表关联组成一个实体类，自定义字段可动态修改<br>
MBP（MyBatis+JPA）/Spring JDBC共存<br>

# springboot_jpa
①JDK8<br>
②SpringBoot2.1.3+spring-boot-starter-data-jpa<br>
③MBP/通用Mapper均使用JPA包装实体类（单表JPA/多表MyBatis）<br>

************************************************************************************************************************

# 参考
①https://github.com/abel533/Mybatis-Spring（原生MyBatis位于分支中+通用Mapper）<br>
②https://gitee.com/zhougaojun/KangarooAdmin（MyBatis-Plus）<br>
③https://gitee.com/baomidou/mybatis-plus-samples（MyBatis-Plus SpringBoot版）<br>