package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.maniy.entity.Question;
import top.maniy.service.QuestionService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/24 16:44
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/questionList/{topicId}")
    public String findQuestionByTopicId(@PathVariable String  topicId,
                                        @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                        ModelMap modelMap){
        PageInfo<Question> pageInfo=questionService.findQuestionByTopicId(topicId,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("topicId",topicId);
        return "questionList";
    }

    @RequestMapping("/questionList/{topicId}/likeName")
    public String findQuestionBySearch(@PathVariable String  topicId,@RequestParam("title") String title,
                                        @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                        @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                        ModelMap modelMap){
        PageInfo<Question> pageInfo=questionService.findQuestionByTopicId(topicId,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("topicId",topicId);
        modelMap.put("title",title);
        return "questionListBySearch";
    }




}
