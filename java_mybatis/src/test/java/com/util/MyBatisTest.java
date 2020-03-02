package com.util;

import com.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class MyBatisTest {

    private static SqlSessionFactory sqlSessionFactory;

    /* 运行测试例子前，构造全局静态SqlSessionFactory */
    @BeforeClass
    public static void init() {
        try {
            /*
             * ①Resources先读取MyBatis配置，再读取Mapper
             * ②MyBatis配置/Mapper XML路径有着严格的要求
             * */
            Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSqlSession() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            /*
             * DefaultSqlSession
             * SimpleExecutor：query>doQuery？
             * RoutingStatementHandler
             * PreparedStatementHandler
             * PreparedStatementLogger：invoke（JDK代理）
             * PreparedStatement：execute（mysql-connector-java包）
             * DefaultResultSetHandler：结果集
             * MappedStatement
             * */
            List<User> userList = sqlSession.selectList("com.dao.IUserDao.selectAll");
            System.out.println(userList);
        } finally {
            sqlSession.close();
        }
    }

}
