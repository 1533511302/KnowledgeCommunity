package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Label;
import top.maniy.mapper.LabelMapper;
import top.maniy.service.LabelService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/12/4 13:24
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;

    @Override
    public Label findLabelByMassageLabel(String massageLabel) {
        return labelMapper.findLabelByMassageLabel(massageLabel);
    }

    @Override
    public Label findLabelByAudioLabel(String audioLabel) {
        return labelMapper.findLabelByAudioLabel(audioLabel);
    }

    @Override
    public Label findLabelByQuestionLabel(String questionLabel) {
        return labelMapper.findLabelByQuestionLabel(questionLabel);
    }

    @Override
    public List<Label> findMassageLabelByHot(Integer num) {
        return labelMapper.findMassageLabelByHot(num);
    }

    @Override
    public List<Label> findAudioLabelByHot(Integer num) {
        return labelMapper.findAudioLabelByHot(num);
    }

    @Override
    public List<Label> findQuestionLabelByHot(Integer num) {
        return labelMapper.findQuestionLabelByHot(num);
    }

    @Override
    public boolean saveMassageLabel(String massageLabel) {
        Label label =new Label();
        label.setMassageLabel(massageLabel);
        return labelMapper.saveLabel(label);
    }

    @Override
    public boolean saveAudioLabel(String audioLabel) {
        Label label =new Label();
        label.setAudioLabel(audioLabel);
        return labelMapper.saveLabel(label);
    }

    @Override
    public boolean saveQuestionLabel(String questionLabel) {
        Label label =new Label();
        label.setQuestionLabel(questionLabel);
        return labelMapper.saveLabel(label);
    }


    @Override
    public boolean deleteLabel(Integer id) {
        return labelMapper.deleteLabel(id);
    }

    @Override
    public boolean updateLabel(Label label) {
        return labelMapper.updateLabel(label);
    }
}
