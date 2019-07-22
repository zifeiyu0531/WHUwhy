import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.AllUser;
import com.google.gson.Gson;
import database.SignupServer;

@WebServlet(name = "Signup")
public class Signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("userName");
        String password = request.getParameter("passWord");
        String schoolid = request.getParameter("studentId");
        String url = request.getParameter("imageUrl");

        AllUser user = new AllUser();
        user.setUserName(name);
        user.setPassWord(password);
        user.setSchoolId(schoolid);
        user.setImageUrl(url);

        Gson gson = new Gson();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        SignupServer loginServer=new SignupServer();
        try{
            AllUser newUser=loginServer.getSignup(user);
            String info = gson.toJson(newUser);
            out.write(info);
            System.out.println(info);
        }catch (ClassNotFoundException e){
            System.out.println("驱动找不到");
        }catch (SQLException e){
            System.out.println("SQL操作失误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
