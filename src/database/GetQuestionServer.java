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
import bean.Question;

public class GetQuestionServer {
    int i=1;
    public List<Question> getQuestion1(int type) throws ClassNotFoundException, SQLException{
        List<Question> questions= new ArrayList<>();
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from question where type=1";

        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        int num;
        while(rs.next()){
            Question articleInData=new Question();
            articleInData.setId(rs.getInt(1));
            articleInData.setTitle(rs.getString("title"));
            articleInData.setqName(rs.getString("qname"));
            articleInData.setaName(rs.getString("aname"));
            articleInData.setType(rs.getInt("type"));
            articleInData.setInfo(rs.getString("aintroduction"));
            num=rs.getInt("textnumber");
            System.out.println(num);
            for(int j=1; j<=num;j++){
                articleInData.setAnswer(rs.getString("answer"+String.valueOf(j)));
            }
            questions.add(articleInData);
            if(i%4==0){
                rs.close();
                ps.close();
                conn.close();
                i=1;
                return questions;
            }
            i++;
            System.out.println(i);
        }
        //关闭资源
        return questions;
    }
    public List<Question> getQuestion2(int type) throws ClassNotFoundException, SQLException{
        List<Question> questions= new ArrayList<>();
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from question where type=2";

        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        int num;
        while(rs.next()){
            Question articleInData=new Question();
            articleInData.setId(rs.getInt(1));
            articleInData.setTitle(rs.getString("title"));
            articleInData.setqName(rs.getString("qname"));
            articleInData.setaName(rs.getString("aname"));
            articleInData.setType(rs.getInt("type"));
            articleInData.setInfo(rs.getString("aintroduction"));
            num=rs.getInt("textnumber");
            System.out.println(num);
            for(int j=1; j<=num;j++){
                articleInData.setAnswer(rs.getString("answer"+String.valueOf(j)));
            }
            questions.add(articleInData);
            if(i%4==0){
                rs.close();
                ps.close();
                conn.close();
                i=1;
                return questions;
            }
            i++;
            System.out.println(i);
        }
        //关闭资源
        return questions;
    }
    public List<Question> getQuestion3(int type) throws ClassNotFoundException, SQLException{
        List<Question> questions= new ArrayList<>();
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from question where type=3";

        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        int num;
        while(rs.next()){
            Question articleInData=new Question();
            articleInData.setId(rs.getInt(1));
            articleInData.setTitle(rs.getString("title"));
            articleInData.setqName(rs.getString("qname"));
            articleInData.setaName(rs.getString("aname"));
            articleInData.setType(rs.getInt("type"));
            articleInData.setInfo(rs.getString("aintroduction"));
            num=rs.getInt("textnumber");
            System.out.println(num);
            for(int j=1; j<=num;j++){
                articleInData.setAnswer(rs.getString("answer"+String.valueOf(j)));
            }
            questions.add(articleInData);
            if(i%4==0){
                rs.close();
                ps.close();
                conn.close();
                i=1;
                return questions;
            }
            i++;
            System.out.println(i);
        }
        //关闭资源
        return questions;
    }
    public List<Question> getQuestion4(int type) throws ClassNotFoundException, SQLException{
        List<Question> questions= new ArrayList<>();
        String URL="jdbc:mysql://localhost:3306/whuwhy?useUnicode=true&characterEncoding=UTF-8";
        String USER="root";
        String PASSWORD="123456";
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库的连接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //通过数据库的连接操作数据库
        String sql="select * from question where type=4";

        //准备statement
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        //处理ResultSet
        int num;
        while(rs.next()){
            Question articleInData=new Question();
            articleInData.setId(rs.getInt(1));
            articleInData.setTitle(rs.getString("title"));
            articleInData.setqName(rs.getString("qname"));
            articleInData.setaName(rs.getString("aname"));
            articleInData.setType(rs.getInt("type"));
            articleInData.setInfo(rs.getString("aintroduction"));
            num=rs.getInt("textnumber");
            System.out.println(num);
            for(int j=1; j<=num;j++){
                articleInData.setAnswer(rs.getString("answer"+String.valueOf(j)));
            }
            questions.add(articleInData);
            if(i%4==0){
                rs.close();
                ps.close();
                conn.close();
                i=1;
                return questions;
            }
            i++;
            System.out.println(i);
        }
        //关闭资源
        return questions;
    }
}