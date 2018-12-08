package top.maniy.entity;


public class Label {

  private Integer id;
  private String massageLabel;
  private Integer massageLabelHot;
  private String audioLabel;
  private Integer audioLabelHot;
  private String questionLabel;
  private Integer questionLabelHot;
  private java.sql.Timestamp createTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getMassageLabel() {
    return massageLabel;
  }

  public void setMassageLabel(String massageLabel) {
    this.massageLabel = massageLabel;
  }


  public Integer getMassageLabelHot() {
    return massageLabelHot;
  }

  public void setMassageLabelHot(Integer massageLabelHot) {
    this.massageLabelHot = massageLabelHot;
  }


  public String getAudioLabel() {
    return audioLabel;
  }

  public void setAudioLabel(String audioLabel) {
    this.audioLabel = audioLabel;
  }


  public Integer getAudioLabelHot() {
    return audioLabelHot;
  }

  public void setAudioLabelHot(Integer audioLabelHot) {
    this.audioLabelHot = audioLabelHot;
  }


  public String getQuestionLabel() {
    return questionLabel;
  }

  public void setQuestionLabel(String questionLabel) {
    this.questionLabel = questionLabel;
  }

  public Integer getQuestionLabelHot() {
    return questionLabelHot;
  }

  public void setQuestionLabelHot(Integer questionLabelHot) {
    this.questionLabelHot = questionLabelHot;
  }

  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

}
