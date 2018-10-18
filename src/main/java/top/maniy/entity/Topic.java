package top.maniy.entity;


public class Topic {

  private Integer id;
  private String topicId;
  private String topicClassId;
  private String topicName;
  private String topicDescribe;
  private String photo;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }


  public String getTopicClassId() {
    return topicClassId;
  }

  public void setTopicClassId(String topicClassId) {
    this.topicClassId = topicClassId;
  }


  public String getTopicName() {
    return topicName;
  }

  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }


  public String getTopicDescribe() {
    return topicDescribe;
  }

  public void setTopicDescribe(String topicDescribe) {
    this.topicDescribe = topicDescribe;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


}
