package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Collections;
import top.maniy.entity.Question;
import top.maniy.mapper.QuestionMapper;
import top.maniy.service.QuestionService;

import java.util.ArrayList;
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
    public List<Question> findAllQuestion() {
        return questionMapper.findAllQuestion();
    }

    @Override
    public PageInfo<Question> findQuestionByUserCollection(List<Collections> collectionsList, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Question> massageList = new ArrayList<Question>();
        for(Collections collections : collectionsList){
            massageList.add(questionMapper.findQuestionById(collections.getQuestionId()));
        }
        PageInfo<Question> pageInfo = new PageInfo<Question>(massageList);
        return pageInfo;
    }

    @Override
    public PageInfo<Question> findQuestionByTopicId(String topicId,int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Question> questionList=questionMapper.findQuestionByTopicId(topicId);
        PageInfo<Question> pageInfo=new PageInfo<>(questionList);
        return pageInfo;
    }

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
    public boolean LikeNumbAddOne(Integer id) {
        int likeNumb=questionMapper.findQuestionById(id).getLikeNumb()+1;
        Question question =new Question();
        question.setId(id);
        question.setLikeNumb(likeNumb);
        return questionMapper.updateQuestion(question);
    }

    @Override
    public boolean browseNumb(Integer id) {
        int browseNumb=questionMapper.findQuestionById(id).getBrowseNumb()+1;
        Question question =new Question();
        question.setId(id);
        question.setBrowseNumb(browseNumb);
        return questionMapper.updateQuestion(question);
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
