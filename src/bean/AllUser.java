package bean;

public class AllUser {
    private String userName;
    private String passWord;
    private String schoolId;
    private String imageUrl;
    private String info;
    public AllUser(){}
    public String getUserName() {
        return userName;
    }
    public void setUserName(String name) {
        this.userName = name;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String password) {
        this.passWord = password;
    }
    public String getSchoolId() {
        return schoolId;
    }
    public void setSchoolId(String id) {
        this.schoolId = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String url) { this.imageUrl = url; }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) { this.info = info; }
}
