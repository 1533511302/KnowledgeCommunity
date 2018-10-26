package top.maniy.entity;


import top.maniy.util.DateUtil;

import java.util.Date;

public class Comment {

  private Integer id;
  private Integer quesId;
  private Integer answerId;
  private Integer massageId;
  private Integer commentatorId;
  private String commentContent;
  private Integer likeNumb;
  private Date createTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getQuesId() {
    return quesId;
  }

  public void setQuesId(Integer quesId) {
    this.quesId = quesId;
  }


  public Integer getAnswerId() {
    return answerId;
  }

  public void setAnswerId(Integer answerId) {
    this.answerId = answerId;
  }


  public Integer getMassageId() {
    return massageId;
  }

  public void setMassageId(Integer massageId) {
    this.massageId = massageId;
  }


  public Integer getCommentatorId() {
    return commentatorId;
  }

  public void setCommentatorId(Integer commentatorId) {
    this.commentatorId = commentatorId;
  }


  public String getCommentContent() {
    return commentContent;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }


  public Integer getLikeNumb() {
    return likeNumb;
  }

  public void setLikeNumb(Integer likeNumb) {
    this.likeNumb = likeNumb;
  }

  public String getCreateTime() {
    return DateUtil.DateTimeToString(createTime);
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
