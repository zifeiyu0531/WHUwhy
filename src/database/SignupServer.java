package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Driver;
import bean.AllUser;

public class SignupServer{
    public AllUser getSignup(AllUser user) throws ClassNotFoundException, SQLException{
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="insert into user values ('"+user.getUserName()+"','"+ user.getSchoolId()+"','"+ user.getImageUrl()+"','"+"自我介绍"+"','"+ user.getPassWord()+"')";
        System.out.println(sql);
        //准备statement
        Statement statement=conn.createStatement();
        statement.executeUpdate(sql);
        //关闭资源
        statement.close();
        conn.close();
        return user;
    }
}

