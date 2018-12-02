package top.maniy.entity;


import top.maniy.util.DateUtil;

import java.util.Date;

public class Collections {

  private Integer id;
  private Integer userId;
  private Integer massageId;
  private Integer audioId;
  private Integer questionId;
  private Integer vUserId;
  private Integer type;//类型：文章：1；音频：2；问题：3；
  private Date createTime;


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


  public Integer getMassageId() {
    return massageId;
  }

  public void setMassageId(Integer massageId) {
    this.massageId = massageId;
  }


  public Integer getAudioId() {
    return audioId;
  }

  public void setAudioId(Integer audioId) {
    this.audioId = audioId;
  }


  public Integer getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Integer questionId) {
    this.questionId = questionId;
  }

  public Integer getvUserId() {
    return vUserId;
  }

  public void setvUserId(Integer vUserId) {
    this.vUserId = vUserId;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public String getCreateTime() {
    return DateUtil.DateTimeToString(createTime);
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  @Override
  public String toString() {
    return "Collections{" +
            "id=" + id +
            ", userId=" + userId +
            ", massageId=" + massageId +
            ", audioId=" + audioId +
            ", questionId=" + questionId +
            ", type=" + type +
            ", createTime=" + createTime +
            '}';
  }
}
