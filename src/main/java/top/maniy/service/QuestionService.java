package top.maniy.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Question;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/24 16:25
 */
public interface QuestionService {

    //根据话题查询问题
    //List<Question> findQuestionByTopicId(String topicId);

    //根据用户id查询问题
    PageInfo<Question> findQuestionByUserId(Integer userId,int currentPage, int pageSize);

    //根据问题名模糊查询
    PageInfo<Question> findQuestionLikeQuesName(String quesName,int currentPage, int pageSize);

    //根据问题id查询问题
    Question findQuestionById(Integer id);

    //添加问题
    boolean saveQuestion(Question question);

    //更新问题
    boolean updateQuestion(Question question);

    //删除
    boolean deleteQuestion(Integer id);
}
