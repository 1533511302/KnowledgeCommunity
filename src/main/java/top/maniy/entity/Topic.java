package top.maniy.entity;


import top.maniy.util.DateUtil;

import java.util.Date;

public class Topic {

  private Integer id;
  private Integer topicClassId;
  private String topicName;
  private String topicDescribe;
  private String photo;
  private Date CreateTime;



  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getTopicClassId() {
    return topicClassId;
  }

  public void setTopicClassId(Integer topicClassId) {
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

  public String getCreateTime() {
    return DateUtil.DateTimeToString(CreateTime);
  }

  public void setCreateTime(Date createTime) {
    CreateTime = createTime;
  }
}
