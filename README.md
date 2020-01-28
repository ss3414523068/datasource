# datasource
持久层<br>

************************************************************************************************************************

# java_mybatis
①JDK6<br>
②Java整合MyBatis<br>
在Java中直接使用MyBatis框架需要读取配置，手动构造SqlSessionFactory/SqlSession<br>

# ss_mybatis
①JDK6<br>
②Spring/SpringMVC整合原生MyBatis<br>
在Spring中配置SqlSessionFactoryBean/MapperScannerConfigurer（新版）<br>
③com包（原生MyBatis）<br>
Mybatis Generator Maven插件（打包时会调用此插件）<br>
PageHelper插件（可独立于通用Mapper使用）<br>
Druid监控（需要配置web.xml）<br>
Ehcache（Spring配置+ehcache.xml）<br>
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

# springboot_mybatisplus
①JDK8<br>
②SpringBoot2.1.3+mybatis-plus-boot-starter3.1.0+MBP Generator（freemarker/lombok）+Druid<br>
（mysql-connector-java runtime会报错）<br>
③SpringBoot2整合mybatis-plus-boot-starter3.1.0<br>
推荐写法：DataSourceConfig（model/mapper/XML/分页）<br>
传统写法：Application（mapper/分页）+application.properties（XML）<br>
④多数据源<br>

# springboot_jpa
①JDK8<br>
②MBP/通用Mapper均使用JPA包装实体类（单表JPA/多表MyBatis）<br>
Druid监控（druid-spring-boot-starter）<br>

******************************************************************************************

# springboot_mysql
①JDK8+MBP<br>
②MySQL调优<br>
数据库索引<br>
缓存<br>
分库分表<br>
读写分离<br>

## springboot_cache
①JDK8+MyBatis<br>
②Ehcache缓存<br>
@EnableCaching+@CacheConfig+@Cacheable+ehcache.xml<br>
CacheManager手动添加/获取<br>
直接使用Ehcache<br>

## springboot_transaction
①JDK8+JPA<br>
②数据库事务<br>
事务（@EnableTransactionManagement+@Transactional）<br>

******************************************************************************************

# springboot_h2
①JDK8<br>
②JVM嵌入式数据库H2<br>
（初始化时未执行schema-h2.sql/data-h2.sql）<br>