package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Driver;
import bean.User;

public class LoginServer{
    private User userInData=new User();
    private String name="11";
    private String password="";
    public User getLogin(User user) throws ClassNotFoundException, SQLException{
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from user";
        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        while(rs.next()){
            name=rs.getString(1);
            password=rs.getString(5);
            if(name.equals(user.getUserName())&&password.equals(user.getPassWord())){
                userInData.setUserName(name);
                userInData.setPassWord(password);
                break;
            }
        }
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
        return userInData;
    }
}
