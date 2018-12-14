package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Answer;
import top.maniy.entity.Question;
import top.maniy.mapper.AnswerMapper;
import top.maniy.service.AnswerService;
import top.maniy.service.QuestionService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/29 11:34
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private QuestionService questionService;

    @Override
    public PageInfo<Answer> findAnswerByQuesId(Integer quesId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Answer> answerList=answerMapper.findAnswerByQuesId(quesId);
        PageInfo<Answer> pageInfo =new PageInfo<>(answerList);
        return pageInfo;
    }

    @Override
    public PageInfo<Answer> findAnswerByUserId(Integer userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Answer> answerList=answerMapper.findAnswerByQuesId(userId);
        for(Answer answer:answerList){
            Question question =questionService.findQuestionById(answer.getQuesId());
            String quesTitle=question.getQuesName();
            String quesPhoto=question.getPhoto();
            answer.setQuesTitle(quesTitle);
            answer.setPhoto(quesPhoto);
        }
        PageInfo<Answer> pageInfo =new PageInfo<>(answerList);
        return pageInfo;
    }

    @Override
    public Answer findAnswerById(Integer id) {
        return answerMapper.findAnswerById(id);
    }

    @Override
    public boolean saveAnswer(Answer answer) {
        return answerMapper.saveAnswer(answer);
    }

    @Override
    public boolean updateAnswer(Answer answer) {
        return answerMapper.updateAnswer(answer);
    }

    @Override
    public boolean deleteAnswer(Integer id) {
        return answerMapper.deleteAnswer(id);
    }
}
