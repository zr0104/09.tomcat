package Dao;

import java.sql.Connection;
import java.sql.Statement;

import DBUtil.DBUtil;

import Emtity.User;

public class Dao {

    public boolean add(User user) {
        //�����ݲ������ݿ��SQL���
        String sql = "insert into sen_inf(username,password,email) values('"+ user.getUsername() +"','"+ user.getPassword() +"','"+ user.getEmail() +"')";
        // �������ݿ�����
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
            // �ر�z ����
            DBUtil.close(state, conn);
        }
   
        if (a > 0) {
            f = true;
        }
        return f;

}

}