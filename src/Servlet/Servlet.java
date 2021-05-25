package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.JsonArray;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Dao.Dao;

import Emtity.User;




@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    public Servlet() {
        super();
        
    }
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if ("add".equals(method)) {
            add(req, resp);
        } 
    }
    
    
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        //�����û�������
        User user = new User(username,password,email);
        //�����жϺ�������ֵ
        Dao dao =new Dao();
        boolean f=dao.add(user);
        //��ʾ��Ϣ
        if(f) {
            req.setAttribute("message", "ע��ɹ���");
            req.getRequestDispatcher("index.html").forward(req,resp);
        } 
        else {
            req.setAttribute("message", "�����˺ţ��ظ���¼��");
            req.getRequestDispatcher("index.html").forward(req,resp);
        }
    }
/*@RequestMapping(value="/Servlet")
    public void query(HttpServletResponse resp) {
        try {
            list集合中存放的是好多student对象
            List<User> students = Servlet.getAllUserInfo();
            将list集合装换成json对象
            JsonArray data = JsonArray.fromObject(students);
            //接下来发送数据
            设置编码，防止出现乱码问题
            resp.setCharacterEncoding("utf-8");
            得到输出流
            PrintWriter respWritter = resp.getWriter();
            将JSON格式的对象toString()后发送
            respWritter.append(data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}