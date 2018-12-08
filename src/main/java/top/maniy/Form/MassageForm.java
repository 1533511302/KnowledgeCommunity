package top.maniy.Form;

import java.util.Date;

/**
 * @author liuzonghua
 * @Package top.maniy.Form
 * @Description:
 * @date 2018/12/8 16:53
 */
public class MassageForm {
    private Integer id;
    private String title;
    private String category;
    private String username;
    private Integer likeNumb;
    private Integer CommentNumb;
    private Integer browseNumb;
    private String createTime;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
