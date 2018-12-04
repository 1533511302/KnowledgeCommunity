package top.maniy.service;

import top.maniy.entity.Label;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/12/4 12:30
 */
public interface LabelService {

    //查询是否存在massageLabel标签
    Label findLabelByMassageLabel(String massageLabel);

    //查询是否存在audioLabel标签
    Label findLabelByAudioLabel(String audioLabel);

    //查询是否存在questionLabel标签
    Label findLabelByQuestionLabel(String questionLabel);

    //根据热点取massageLabel数量为num
    List<Label> findMassageLabelByHot(Integer num);

    //根据热点取audioLabel数量为num
    List<Label> findAudioLabelByHot(Integer num);

    //根据热点取questionLabel数量为num
    List<Label> findQuestionLabelByHot(Integer num);

    //添加文章标签
    boolean saveMassageLabel(String massageLabel);

    //添加音频标签
    boolean saveAudioLabel(String audioLabel);

    //添加问题标签
    boolean saveQuestionLabel(String questionLabel);

    //删除标签
    boolean deleteLabel(Integer id);

    //更新标签
    boolean updateLabel(Label label);
}
