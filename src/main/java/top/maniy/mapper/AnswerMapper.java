package top.maniy.mapper;

import top.maniy.entity.Answer;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/28 23:29
 */
public interface AnswerMapper {
    //根据问题id查询回答
    List<Answer> findAnswerByQuesId(Integer quesId);

    //根据用户id查询回答
    List<Answer> findAnswerByUserId(Integer userId);

    //根据回答id查询回答
    List<Answer> findAnswerById(Integer id);

    //添加回答
    boolean saveAnswer(Answer answer);

    //修改回答
    boolean updateAnswer(Answer answer);

    //删除回答
    boolean deleteAnswer(Answer answer);
}
