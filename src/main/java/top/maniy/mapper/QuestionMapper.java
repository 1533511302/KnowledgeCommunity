package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Question;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/24 14:56
 */
public interface QuestionMapper {

    //问题数
    Integer findQuestionCount();

    //全部问题
    List<Question> findAllQuestion();

    //根据话题查询问题
    List<Question> findQuestionByTopicId(String topicId);

    //根据用户id查询问题
    List<Question> findQuestionByUserId(Integer userId);

    //根据问题名模糊查询
    List<Question> findQuestionLikeQuesName(@Param("quesName") String quesName);

    //根据点赞量排序获取massage
    List<Question> findQuestionByLikeNumbDesc(@Param("topicId") Integer topicId,@Param("start") Integer start,@Param("end") Integer end);

    //根据问题id查询问题
    Question findQuestionById(Integer id);

    //添加问题
    boolean saveQuestion(Question question);

    //更新问题
    boolean updateQuestion(Question question);

    //删除
    boolean deleteQuestion(Integer id);



}
