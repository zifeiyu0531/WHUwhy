import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import bean.Article;
import database.GetArticleDetailServer;
import database.LoginServer;
import com.google.gson.Gson;

@WebServlet(name = "GetArticleDetail")
public class GetArticleDetail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String idstr = request.getParameter("id");
        Integer id = Integer.valueOf(idstr);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();

        GetArticleDetailServer getArticleDetailServer=new GetArticleDetailServer();
        try{
            Article article= getArticleDetailServer.getInfo(id);
            String info = gson.toJson(article);
            out.write(info);
            System.out.println(info);
        }catch (ClassNotFoundException e){
            System.out.println("驱动找不到");
        }catch (SQLException e){
            System.out.println("SQL操作失误");
        }
    }
}
