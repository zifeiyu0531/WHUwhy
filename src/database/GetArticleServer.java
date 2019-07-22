package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import com.mysql.jdbc.Driver;
import bean.Article;

public class GetArticleServer {
    static int i=1;
    public List<Article> getArticle() throws ClassNotFoundException, SQLException{
        List<Article> articles= new ArrayList<>();
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from article";
        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        int num;
        while(rs.next()){
            Article articleInData=new Article();
            articleInData.setId(rs.getInt(1));
            System.out.println(rs.getInt(1));
            articleInData.setTitle(rs.getString("title"));
            articleInData.setName(rs.getString("name"));
            articleInData.setHeadUrl(rs.getString("url"));
            articleInData.setInfo(rs.getString("introduction"));
            num=rs.getInt("textnumber");
            System.out.println(num);
            for(int j=1; j<=num;j++){
                articleInData.setBody(rs.getString("body"+String.valueOf(j)));
            }
            articles.add(articleInData);
            if(i%4==0){
                rs.close();
                ps.close();
                conn.close();
                i=1;
                return articles;
            }
            i++;
            System.out.println(i);
        }
        //关闭资源
        return articles;
    }
}
