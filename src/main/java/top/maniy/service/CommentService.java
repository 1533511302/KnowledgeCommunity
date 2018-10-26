package top.maniy.service;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Comment;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/26 13:57
 */
public interface CommentService {

    //根据massageId查询评论
    List<Comment> findCommentByMassageId(Integer massageId);

    //根据massageId查询评论依据点赞量降序排列取前num
    List<Comment> findCommentByMassageIdAndByLikeNumbDescTo3(@Param("massageId") Integer massageId);

    //添加评论
    boolean saveComment(Comment comment);

    //删除评论
    boolean deleteComment(Integer id);
}
