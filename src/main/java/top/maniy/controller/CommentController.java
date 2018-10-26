package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.entity.Comment;
import top.maniy.service.CommentService;

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

    @RequestMapping("/indexComment")
    @ResponseBody
    public List<Comment> indexComment(@RequestParam("massageId") Integer massageId){
        return commentService.findCommentByMassageId(massageId);

    }
}
