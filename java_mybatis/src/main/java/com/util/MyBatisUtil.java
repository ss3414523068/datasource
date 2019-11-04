package com.util;

import com.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class MyBatisUtil {

    public static void main(String[] args) {
        try {
            MyBatisUtil util = new MyBatisUtil();
            util.SqlSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void SqlSession() {
        try {
            Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<User> userList = sqlSession.selectList("selectAll");
            System.out.println(userList);

            reader.close();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
