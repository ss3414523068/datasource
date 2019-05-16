package com.dao;

import org.junit.Test;

import java.sql.*;

public class JDBC {

    //    @Test
    public void insert() {
        String url = "jdbc:mysql://127.0.0.1:3306/untitled?useSSL=false";
        String username = "root";
        String password = "2468";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO `user`(`name`, `password`) VALUES ('name1', 'pwd1')";
            int status = statement.executeUpdate(sql);
            System.out.println(status); /* SQL执行成功返回1 */
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    @Test
    public void select() {
        String url = "jdbc:mysql://127.0.0.1:3306/untitled?useSSL=false";
        String username = "root";
        String password = "2468";
        try {
            /*
             * ①加载JDBC驱动
             * （通过反射加载JDBC驱动）
             * */
            Class.forName("com.mysql.jdbc.Driver");
            /* ②获取数据库连接 */
            Connection connection = DriverManager.getConnection(url, username, password);
            /* ③获取用于向数据库发送SQL的Statement */
            Statement statement = connection.createStatement();
            /* ④查询+获取结果集 */
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `user`");
            /*
             * ⑤取出结果集中的数据（遍历所有记录）
             * （查询时再执行SQL不要使用同一个Statement，会影响ResultSet）
             * */
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("name:" + resultSet.getString("name"));
                System.out.println("pwd:" + resultSet.getString("password"));
            }
            /* ⑥关闭链接，释放资源 */
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void batchInsert() {
        long startTime = System.currentTimeMillis();

        String url = "jdbc:mysql://127.0.0.1:3306/untitled?useSSL=false";
        String username = "root";
        String password = "2468";
        int count = 10000;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            String sql1 = "INSERT INTO `sql_user_1`(`id`, `int_1`, `int_2`, `varchar_1`, `varchar_2`, `date_1`, `date_2`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            for (int i = 1, j = 1; i <= count; i++) {
                if (i / 1000.0 > (j - 1) && i / 1000.0 <= j) { /* 每1000条数据相同 */
                } else {
                    j++;
                }
                preparedStatement.setInt(1, i);
                preparedStatement.setInt(2, j);
                preparedStatement.setInt(3, j);
                preparedStatement.setString(4, "varchar" + j);
                preparedStatement.setString(5, "varchar" + j);
                preparedStatement.setString(6, "2019-04-09 " + j % 24 + ":00:00");
                preparedStatement.setString(7, "2019-04-09 " + j % 24 + ":00:00");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.close();

            String sql2 = "INSERT INTO `sql_user_2`(`id`, `sql_id`) VALUES (?, ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            for (int i = 1, j = 1; i <= count; i++) {
                preparedStatement2.setInt(1, i);
                preparedStatement2.setInt(2, i);
                preparedStatement2.addBatch();
            }
            preparedStatement2.executeBatch();
            preparedStatement2.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long times = System.currentTimeMillis() - startTime;
        System.out.println("插入:" + count + "条记录 耗时:" + times / 1000.0 + "秒");
    }

    /************************************************************分割线************************************************************/

    /*
     * 边查边删
     * ①从A表（sql_user_1）中查询，每1000条批量删除一次A表记录
     * ②批量删除后递归重新查询
     * */
//    @Test
    public void selectAndDelete() {
        String url = "jdbc:mysql://127.0.0.1:3306/untitled?useSSL=false";
        String username = "root";
        String password = "2468";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            String select = "SELECT * FROM `sql_user_1`";
            String delete = "DELETE FROM `sql_user_1` WHERE id BETWEEN ? AND ?";
            recursiveDelete(connection, select, delete);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recursiveDelete(Connection connection, String select, String delete) throws SQLException {
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        int count = 0;
        ResultSet resultSet = statement.executeQuery(select);
        resultSet.next();
        int beginId = resultSet.getInt("id");
        while (resultSet.next()) {
            preparedStatement.setInt(1, beginId);
            preparedStatement.setInt(2, resultSet.getInt("id"));
            count++;
            if (count % 1000 == 0) { /* 每1000条删一次，递归一次，不足1000交给while外删除 */
                preparedStatement.execute();
                preparedStatement.close();
                resultSet.close();
                statement.close();
                recursiveDelete(connection, select, delete);
            }
        }
        preparedStatement.execute();
        preparedStatement.close();
        resultSet.close();
        statement.close();
    }

}
