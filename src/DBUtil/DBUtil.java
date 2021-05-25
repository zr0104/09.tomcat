package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author Sen
 *
 */
public class DBUtil {
    
    public static String db_url = "jdbc:mysql://localhost:3306/sendb?serverTimezone=UTC&useSSL=false";//��¼���ݿ�
    public static String db_user = "root";
    public static String db_pass = "qgs0051";
    
    public static Connection getConn() {
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//��������
            conn = DriverManager.getConnection(db_url, db_user, db_pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }
     /**
         * �ر������ݿ������
     * @param state
     * @param conn
     */
    public static void close (Statement state, Connection conn) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void close (ResultSet rs, Statement state, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql ="select * from sen_inf";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
//        System.out.print(rs.toString());
        if(rs.next()){
            System.out.println("��");
        }else{
            System.out.println("����");
        }
    }
}