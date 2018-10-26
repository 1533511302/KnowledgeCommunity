package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Comment;
import top.maniy.mapper.CommentMapper;
import top.maniy.service.CommentService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/26 13:59
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentByMassageId(Integer massageId) {
        return commentMapper.findCommentByMassageId(massageId);
    }

    @Override
    public List<Comment> findCommentByMassageIdAndByLikeNumbDescTo3(Integer massageId) {
        return commentMapper.findCommentByMassageIdAndByLikeNumbDescToNum(massageId,3);
    }

    @Override
    public boolean saveComment(Comment comment) {
        return commentMapper.saveComment(comment);
    }

    @Override
    public boolean deleteComment(Integer id) {
        return commentMapper.deleteComment(id);
    }
}
