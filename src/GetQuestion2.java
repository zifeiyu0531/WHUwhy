import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import bean.Article;
import bean.Question;
import database.GetQuestionServer;
import database.LoginServer;
import com.google.gson.Gson;

@WebServlet(name = "GetQuestion2")
public class GetQuestion2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String typestr = request.getParameter("type");
        Integer type = Integer.valueOf(typestr);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();

        GetQuestionServer getQuestionServer=new GetQuestionServer();
        try{
            List<Question> questions=getQuestionServer.getQuestion2(type);
            String info = gson.toJson(questions);
            out.write(info);
            System.out.println(info);
        }catch (ClassNotFoundException e){
            System.out.println("驱动找不到");
        }catch (SQLException e){
            System.out.println("SQL操作失误");
        }
    }
}
