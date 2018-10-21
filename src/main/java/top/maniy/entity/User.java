package top.maniy.entity;


public class User {

  private int id;

  private String email;
//密码
  private String password;
//名字
  private String username;
//真实姓名
  private String realname;
//性别(1为男，0为女)
  private String gender;
//头像
  private String photo;
//一句话简介（干什么的）
  private String autograph;
//个人简介
  private String introduce;
//文章数量
  private int massagenumb;
//提问次数
  private int questionnumb;
//回答次数
  private int answernumb;
//1普通用户，2认证用户，3管理员
  private String role;
//禁用（1是，0否）
  private String forbidden;

  public int getMassagenumb() {
    return massagenumb;
  }

  public void setMassagenumb(int massagenumb) {
    this.massagenumb = massagenumb;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


  public String getAutograph() {
    return autograph;
  }

  public void setAutograph(String autograph) {
    this.autograph = autograph;
  }


  public String getIntroduce() {
    return introduce;
  }

  public void setIntroduce(String introduce) {
    this.introduce = introduce;
  }


  public int getQuestionnumb() {
    return questionnumb;
  }

  public void setQuestionnumb(int questionnumb) {
    this.questionnumb = questionnumb;
  }


  public int getAnswernumb() {
    return answernumb;
  }

  public void setAnswernumb(int answernumb) {
    this.answernumb = answernumb;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  public String getForbidden() {
    return forbidden;
  }

  public void setForbidden(String forbidden) {
    this.forbidden = forbidden;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", username='" + username + '\'' +
            ", realname='" + realname + '\'' +
            ", gender='" + gender + '\'' +
            ", photo='" + photo + '\'' +
            ", autograph='" + autograph + '\'' +
            ", introduce='" + introduce + '\'' +
            ", questionnumb=" + questionnumb +
            ", answernumb=" + answernumb +
            ", role='" + role + '\'' +
            ", forbidden='" + forbidden + '\'' +
            '}';
  }
}
