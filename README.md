# datasource
持久层<br>

************************************************************************************************************************

# mybatis
①JDK8<br>
②MyBatis 3.4.7源码<br>
在别的项目中引用调试MyBatis源码<br>
（JDK8+允许ognl/javassist传递依赖）<br>

******************************************************************************************

# java_mybatis
①JDK8<br>
②Java直接整合MyBatis<br>
在Java中直接使用MyBatis框架需要读取配置，手动构造SqlSessionFactory/SqlSession<br>
③Spring整合MyBatis（传统写法）<br>
事务<br>

# ss_mybatis
①JDK6<br>
②Spring/SpringMVC整合原生MyBatis<br>
在Spring中配置SqlSessionFactoryBean/MapperScannerConfigurer（新版）<br>
③com包（原生MyBatis）<br>
Mybatis Generator Maven插件（打包时会调用此插件）<br>
PageHelper插件（可独立于通用Mapper使用）<br>
Druid监控（需要配置web.xml+数据源配置慢查询）<br>
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
①JDK8+Spring4+MyBatis-Plus3+MBP Generator（slf4j-api/freemarker/lombok）<br>
②Spring/SpringMVC整合MyBatis-Plus3<br>
在Spring中配置SqlSessionFactoryBean（MBP版）/MapperScannerConfigurer<br>
分页插件<br>

# ss_jpa
①JDK8<br>

# springboot_mybatis
①JDK8+SpringBoot+MyBatis+pagehelper<br>
②MyBatis注解（CURD/关联）<br>

# springboot_mybatisplus
①JDK8+SpringBoot2.1.3+mybatis-plus-boot-starter3.1.0+MBP Generator（freemarker/lombok）<br>
（不一定需要SQL XML）<br>
②SpringBoot整合mybatis-plus-boot-starter3.1.0<br>
推荐写法：DataSourceConfig（model/mapper/XML/分页）<br>
传统写法：Application（mapper/分页）+application.properties（XML）<br>
③多数据源/事务/异步<br>

# springboot_jpa
①JDK8<br>
②JPA<br>
事务（@EnableTransactionManagement+@Transactional）<br>
关联（多对多：双向关联+关联插入/更新/查询）<br>

************************************************************************************************************************

# springboot_cache
①JDK8+MyBatis<br>
②Ehcache缓存<br>
@EnableCaching+@CacheConfig+@Cacheable+ehcache.xml<br>
CacheManager手动添加/获取<br>
直接使用Ehcache<br>
③MySQL调优<br>
数据库索引<br>
缓存<br>

# sharding_mybatisplus
①JDK8+MBP+sharding-jdbc<br>
②ShardingJDBC+MBP<br>

# springboot_h2
①JDK8<br>
②JVM嵌入式数据库H2<br>
（初始化时未执行schema-h2.sql/data-h2.sql）<br>