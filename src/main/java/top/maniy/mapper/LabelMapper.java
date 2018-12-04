package top.maniy.mapper;

import top.maniy.entity.Answer;
import top.maniy.entity.Label;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/28 23:29
 */
public interface LabelMapper {

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

    //添加标签
    boolean saveLabel(Label label);

    //删除标签
    boolean deleteLabel(Integer id);

    //更新标签
    boolean updateLabel(Label label);
}
