package top.maniy.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.Comment;
import top.maniy.service.CommentService;
import top.maniy.service.UserService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/26 14:15
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/indexComment")
    @ResponseBody
    public List<Comment> indexComment(@RequestParam("massageId") Integer massageId){
        return commentService.findCommentByMassageId(massageId);

    }

    @RequestMapping(value = "/saveComment",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveComment(@RequestParam("massageId") int massageId,@RequestParam("commentContent") String commentContent){

        Comment comment =new Comment();
        comment.setCommentContent(commentContent);
        comment.setMassageId(massageId);
        return commentService.saveComment(comment);
    }
}
