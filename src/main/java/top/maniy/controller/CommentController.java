package top.maniy.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.Form.CommentForm;
import top.maniy.entity.Comment;
import top.maniy.entity.Massage;
import top.maniy.entity.User;
import top.maniy.service.CommentService;
import top.maniy.service.MassageService;
import top.maniy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @Autowired
    private MassageService massageService;

    @RequestMapping("/commentList")
    @ResponseBody
    public List<Comment> indexComment(@RequestParam("massageId") Integer massageId){
        return commentService.findCommentByMassageId(massageId);

    }

    @RequestMapping("/indexComment")
    @ResponseBody
    public List<CommentForm> findCommentByMassageIdAndByLikeNumbDescTo3(@RequestParam("massageId") Integer massageId){
        List<CommentForm> commentFormList =new ArrayList<>();
        List<Comment> commentList =commentService.findCommentByMassageIdAndByLikeNumbDescTo3(massageId);
        for(Comment comment:commentList){
            CommentForm commentForm =new CommentForm();
            commentForm.setAnswerId(comment.getAnswerId());
            commentForm.setCommentatorId(comment.getCommentatorId());
            commentForm.setId(comment.getId());
            commentForm.setCreateTime(comment.getCreateTime());
            commentForm.setCommentContent(comment.getCommentContent());
            commentForm.setUsername(comment.getUsername());
            commentForm.setPhoto(userService.findUserById(comment.getCommentatorId()).getPhoto());
            commentFormList.add(commentForm);

        }
        return commentFormList;
    }

    @RequestMapping(value = "/saveComment",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveComment(HttpServletRequest request,@RequestParam("massageId") int massageId, @RequestParam("commentContent") String commentContent){

        User user = (User) request.getSession().getAttribute("User");
        if(user!=null){
            Comment comment =new Comment();
            comment.setCommentContent(commentContent);
            comment.setMassageId(massageId);
            comment.setUsername(user.getRealname());
            comment.setCommentatorId(user.getId());

            Massage massage =massageService.findMassageById(massageId);
            massage.setCommentNumb(massage.getCommentNumb()+1);
            massageService.updateMassage(massage);

            return commentService.saveComment(comment);
        }
      return false;
    }
}
