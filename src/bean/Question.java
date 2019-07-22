package bean;
import java.util.*;

public class Question {
    private Integer id;
    private String title;
    private List<String> answer= new ArrayList<>();
    private String qname;
    private String aname;
    private Integer type;
    private String headUrl;
    private String info;
    private int textnumber;
    public Question(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getAnswer() {
        return answer;
    }
    public void setAnswer( String answer) {
        this.answer.add(answer);
    }
    public String getqName() {
        return qname;
    }
    public void setqName(String name) {
        this.qname = name;
    }
    public String getaName() {
        return aname;
    }
    public void setaName(String name) {
        this.aname = name;
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
