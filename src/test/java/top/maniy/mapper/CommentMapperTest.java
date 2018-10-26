package top.maniy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.Comment;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/26 14:32
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
public class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void findCommentByMassageId() {
    }

    @Test
    public void findCommentByMassageIdAndByLikeNumbDescToNum() {
        System.out.println(commentMapper.findCommentByMassageIdAndByLikeNumbDescToNum(1,3).size());
    }

    @Test
    public void saveComment() {
        Comment comment=new Comment();
        comment.setMassageId(6);
        comment.setCommentatorId(1);
        comment.setCommentContent("且看明月又有几回圆！");
        commentMapper.saveComment(comment);
    }

    @Test
    public void deleteComment() {

    }
}