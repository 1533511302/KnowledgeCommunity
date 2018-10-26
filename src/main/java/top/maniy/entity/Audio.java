package top.maniy.entity;


public class Audio {

  private Integer id;
  private String userName;
  private Integer userId;
  private Integer categoryId;
  private String url;
  private String photo;
  private String status;
  private String audioName;
  private String audioDescribe;
  private String createTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getAudioName() {
    return audioName;
  }

  public void setAudioName(String audioName) {
    this.audioName = audioName;
  }


  public String getAudioDescribe() {
    return audioDescribe;
  }

  public void setAudioDescribe(String audioDescribe) {
    this.audioDescribe = audioDescribe;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }
}
