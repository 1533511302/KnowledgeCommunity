package top.maniy.entity;


import top.maniy.util.DateUtil;

import java.util.Date;

public class Massage {

  private Integer id;
  private String title;
  private Integer userId;
  private Integer categoryId;
  private String photo;
  private String username;
  private Integer likeNumb;
  private Integer CommentNumb;
  private Integer browseNumb;
  private String label;
  private String content;
  private Date createTime;

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getLikeNumb() {
    return likeNumb;
  }

  public void setLikeNumb(Integer likeNumb) {
    this.likeNumb = likeNumb;
  }

  public Integer getCommentNumb() {
    return CommentNumb;
  }

  public void setCommentNumb(Integer commentNumb) {
    CommentNumb = commentNumb;
  }

  public Integer getBrowseNumb() {
    return browseNumb;
  }

  public void setBrowseNumb(Integer browseNumb) {
    this.browseNumb = browseNumb;
  }


  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreateTime() {
    return DateUtil.DateTimeToString(createTime);
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Massage{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", userId=" + userId +
            ", categoryId=" + categoryId +
            ", username='" + username + '\'' +
            ", likeNumb=" + likeNumb +
            ", CommentNumb=" + CommentNumb +
            ", browseNumb=" + browseNumb +
            ", label='" + label + '\'' +
            ", content='" + content + '\'' +
            ", createTime=" + createTime +
            '}';
  }
}
