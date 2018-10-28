package top.maniy.entity;


import java.util.Date;

public class Answer {

  private Integer id;
  private Integer answerId;
  private Integer userId;
  private Integer topicId;
  private Integer quesId;
  private String answerContent;
  private String photo;
  private String anonymity;
  private Integer likeNumb;
  private Integer commentNumb;
  private Date createTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getAnswerId() {
    return answerId;
  }

  public void setAnswerId(Integer answerId) {
    this.answerId = answerId;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public Integer getTopicId() {
    return topicId;
  }

  public void setTopicId(Integer topicId) {
    this.topicId = topicId;
  }


  public Integer getQuesId() {
    return quesId;
  }

  public void setQuesId(Integer quesId) {
    this.quesId = quesId;
  }


  public String getAnswerContent() {
    return answerContent;
  }

  public void setAnswerContent(String answerContent) {
    this.answerContent = answerContent;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


  public String getAnonymity() {
    return anonymity;
  }

  public void setAnonymity(String anonymity) {
    this.anonymity = anonymity;
  }

  public Integer getLikeNumb() {
    return likeNumb;
  }

  public void setLikeNumb(Integer likeNumb) {
    this.likeNumb = likeNumb;
  }

  public Integer getCommentNumb() {
    return commentNumb;
  }

  public void setCommentNumb(Integer commentNumb) {
    this.commentNumb = commentNumb;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
