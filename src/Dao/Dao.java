package Dao;

import java.sql.Connection;
import java.sql.Statement;

import DBUtil.DBUtil;

import Emtity.User;

public class Dao {

    public boolean add(User user) {
        //将数据插入数据库的SQL语句
        String sql = "insert into sen_inf(username,password,email) values('"+ user.getUsername() +"','"+ user.getPassword() +"','"+ user.getEmail() +"')";
        // 创建数据库链接
        Connection conn = DBUtil.getConn();
        Statement state = null;
        boolean f = false;
        int a = 0;
      
        try {
            state = conn.createStatement();
            a=state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭z 连接
            DBUtil.close(state, conn);
        }
   
        if (a > 0) {
            f = true;
        }
        return f;

}

}