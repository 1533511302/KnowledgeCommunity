package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Comment;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/26 11:31
 */
public interface CommentMapper {

    //根据massageId查询评论
    List<Comment> findCommentByMassageId(Integer massageId);

    //根据massageId查询评论依据点赞量降序排列取前num
    List<Comment> findCommentByMassageIdAndByLikeNumbDescToNum(@Param("categoryId") Integer categoryId, @Param("likeNumb")
                                                               Integer likeNumb, @Param("num") Integer num);

    //添加评论
    boolean saveComment(Comment comment);

    //删除评论
    boolean deleteComment(Integer id);
}
