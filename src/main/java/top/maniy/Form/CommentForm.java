package top.maniy.Form;

import java.util.Date;

/**
 * @author liuzonghua
 * @Package top.maniy.Form
 * @Description:
 * @date 2018/12/18 17:12
 */
public class CommentForm {

    private Integer id;
    private String username;
    private Integer quesId;
    private Integer answerId;
    private Integer massageId;
    private Integer commentatorId;
    private String photo;
    private String commentContent;
    private Integer likeNumb;
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
