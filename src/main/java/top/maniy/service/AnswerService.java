package top.maniy.service;

import com.github.pagehelper.PageInfo;
import top.maniy.entity.Answer;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/29 11:29
 */
public interface AnswerService {
    //根据问题id查询回答
    PageInfo<Answer> findAnswerByQuesId(Integer quesId, int currentPage, int pageSize);

    //根据用户id查询回答
    PageInfo<Answer> findAnswerByUserId(Integer userId, int currentPage, int pageSize);

    //根据回答id查询回答
    Answer findAnswerById(Integer id);

    //添加回答
    boolean saveAnswer(Answer answer);

    //修改回答
    boolean updateAnswer(Answer answer);

    //删除回答
    boolean deleteAnswer(Integer id);
}
