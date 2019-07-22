package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Driver;
import bean.Article;

public class GetArticleDetailServer{
    private Article article=new Article();
    public Article getInfo(Integer id) throws ClassNotFoundException, SQLException{
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from article where Id='"+id+"'";
        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        while(rs.next()){
            article.setId(rs.getInt(1));
            System.out.println(rs.getInt(1));
            article.setTitle(rs.getString("title"));
            article.setName(rs.getString("name"));
            article.setHeadUrl(rs.getString("url"));
            article.setInfo(rs.getString("introduction"));
            int num=rs.getInt("textnumber");
            System.out.println(num);
            for(int j=1; j<=num;j++){
                article.setBody(rs.getString("body1"));
            }
        }
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
        return article;
    }
}