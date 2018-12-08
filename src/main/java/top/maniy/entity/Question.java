package top.maniy.entity;


import top.maniy.util.DateUtil;

import java.util.Date;

public class Question {

  private Integer id;
  private Integer userId;
  private String topicId;
  private String quesName;
  private String quesDescribe;
  private String photo;
  private Integer likeNumb;
  private Integer answerNumb;
  private Integer attentionNumb;
  private Integer browseNumb;
  private String status;
  private Date createTime;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }


  public String getQuesName() {
    return quesName;
  }

  public void setQuesName(String quesName) {
    this.quesName = quesName;
  }


  public String getQuesDescribe() {
    return quesDescribe;
  }

  public void setQuesDescribe(String quesDescribe) {
    this.quesDescribe = quesDescribe;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Integer getLikeNumb() {
    return likeNumb;
  }

  public void setLikeNumb(Integer likeNumb) {
    this.likeNumb = likeNumb;
  }

  public Integer getAnswerNumb() {
    return answerNumb;
  }

  public void setAnswerNumb(Integer answerNumb) {
    this.answerNumb = answerNumb;
  }


  public Integer getAttentionNumb() {
    return attentionNumb;
  }

  public void setAttentionNumb(Integer attentionNumb) {
    this.attentionNumb = attentionNumb;
  }


  public Integer getBrowseNumb() {
    return browseNumb;
  }

  public void setBrowseNumb(Integer browseNumb) {
    this.browseNumb = browseNumb;
  }

  public String getCreateTime() {
    return DateUtil.DateTimeToString(createTime);
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
