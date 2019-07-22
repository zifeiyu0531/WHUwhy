package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Driver;
import bean.AllUser;

public class GetInfoServer{
    private AllUser userInData=new AllUser();
    public AllUser getInfo(String name) throws ClassNotFoundException, SQLException{
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from user where setname='"+name+"'";
        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        while(rs.next()){
            userInData.setUserName(rs.getString(1));
            userInData.setSchoolId(rs.getString(2));
            userInData.setImageUrl(rs.getString(3));
            userInData.setInfo(rs.getString(4));
        }
        //关闭资源
        rs.close();
        ps.close();
        conn.close();
        return userInData;
    }
}