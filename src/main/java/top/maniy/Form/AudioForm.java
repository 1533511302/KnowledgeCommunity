package top.maniy.Form;

import java.util.Date;

/**
 * @author liuzonghua
 * @Package top.maniy.Form
 * @Description:
 * @date 2018/12/8 20:00
 */
public class AudioForm {

    private Integer id;
    private String userName;
    private Integer userId;
    private String category;
    private String photo;
    private String status;
    private String audioName;
    private String audioDescribe;
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getAudioDescribe() {
        return audioDescribe;
    }

    public void setAudioDescribe(String audioDescribe) {
        this.audioDescribe = audioDescribe;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
