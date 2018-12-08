package top.maniy.Form;

import java.util.Date;

/**
 * @author liuzonghua
 * @Package top.maniy.Form
 * @Description:
 * @date 2018/12/8 23:05
 */
public class QuestionForm {

    private Integer id;
    private String username;
    private String topic;
    private String quesName;
    private String quesDescribe;
    private Integer likeNumb;
    private Integer answerNumb;
    private Integer attentionNumb;
    private Integer browseNumb;
    private String status;
    private String createTime;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
