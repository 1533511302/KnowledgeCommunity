package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Question;
import top.maniy.mapper.QuestionMapper;
import top.maniy.service.QuestionService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/24 16:29
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public PageInfo<Question> findQuestionByUserId(Integer userId,int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Question> questionList=questionMapper.findQuestionByUserId(userId);
        PageInfo<Question> pageInfo=new PageInfo<>(questionList);
        return pageInfo;
    }

    @Override
    public PageInfo<Question> findQuestionLikeQuesName(String quesName,int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Question> questionList=questionMapper.findQuestionLikeQuesName(quesName);
        PageInfo<Question> pageInfo=new PageInfo<>(questionList);
        return pageInfo;
    }

    @Override
    public Question findQuestionById(Integer id) {
        return questionMapper.findQuestionById(id);
    }

    @Override
    public boolean saveQuestion(Question question) {
        return questionMapper.saveQuestion(question);
    }

    @Override
    public boolean updateQuestion(Question question) {
        return questionMapper.updateQuestion(question);
    }

    @Override
    public boolean deleteQuestion(Integer id) {
        return questionMapper.deleteQuestion(id);
    }
}
