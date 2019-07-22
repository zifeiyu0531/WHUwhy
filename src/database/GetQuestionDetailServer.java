package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Driver;
import bean.Question;

public class GetQuestionDetailServer{
    private Question question=new Question();
    public Question getInfo(Integer id) throws ClassNotFoundException, SQLException{
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from question where Id='"+id+"'";
        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        while(rs.next()){
            question.setId(rs.getInt(1));
            question.setTitle(rs.getString("title"));
            question.setqName(rs.getString("qname"));
            question.setaName(rs.getString("aname"));
            question.setType(rs.getInt("type"));
            question.setInfo(rs.getString("aintroduction"));
            int num=rs.getInt("textnumber");
            System.out.println(num);
            for(int j=1; j<=num;j++){
                question.setAnswer(rs.getString("answer"+String.valueOf(j)));
            }
        }
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
        return question;
    }
}