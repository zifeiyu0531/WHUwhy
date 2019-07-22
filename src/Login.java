import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import bean.User;
import database.LoginServer;
import com.google.gson.Gson;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        System.out.println(userName);
        System.out.println(passWord);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();

        User t1 = new User();
        t1.setUserName(userName);
        t1.setPassWord(passWord);
        LoginServer loginServer=new LoginServer();
        try{
            User findUser=loginServer.getLogin(t1);
            String info = gson.toJson(findUser);
            out.write(info);
            System.out.println(info);
        }catch (ClassNotFoundException e){
            System.out.println("驱动找不到");
        }catch (SQLException e){
            System.out.println("SQL操作失误");
        }
    }
}
