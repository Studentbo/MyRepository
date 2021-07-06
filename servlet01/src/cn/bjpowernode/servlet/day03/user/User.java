package cn.bjpowernode.servlet.day03.user;

public class User {
    private String name;
    private String password;
    private String sex;
    private String email;
//构造方法
    public User(String name, String password, String sex, String email) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }
    public User() {
    }
//set和get方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
