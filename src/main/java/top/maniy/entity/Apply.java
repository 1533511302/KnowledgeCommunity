package top.maniy.entity;


import top.maniy.util.DateUtil;

import java.util.Date;

public class Apply {

  private Integer id;
  private Integer userId;
  private String content;
  private String status;
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


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getCreateTime() {
    return DateUtil.DateTimeToString(createTime);
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
