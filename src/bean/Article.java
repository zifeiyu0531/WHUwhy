package bean;
import java.util.*;

public class Article {
    private Integer id;
    private String title;
    private List<String> body= new ArrayList<>();
    private String name;
    private String headUrl;
    private String info;
    private int textnumber;
    public Article(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getBody() {
        return body;
    }
    public void setBody( String Body) {
        this.body.add(Body);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHeadUrl() {
        return headUrl;
    }
    public void setHeadUrl(String headUrl) { this.headUrl = headUrl; }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) { this.info = info; }
    public int getTextnumber() {
        return textnumber;
    }
    public void setTextnumber(int textnumber) {
        this.textnumber = textnumber;
    }
}
