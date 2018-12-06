package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.maniy.entity.Topic;
import top.maniy.service.TopicService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/20 14:49
 */
@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    private static Topic topic;

    @RequestMapping("topics/{page}")
    public String findAllTopic(@PathVariable(value = "page") int page,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "9") int pageSize,
                               ModelMap modelMap){
        PageInfo<Topic> pageInfo =topicService.findAllTopic(page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        return "topicList";
    }

    @RequestMapping("topics")
    @ResponseBody
    public List<Topic> findAllTopic(){
        return topicService.findAllTopic();
    }

    @RequestMapping("topics/likeName")
    public String findTopicLikeName(@RequestParam(value = "page",required = false,defaultValue = "1") int page,@RequestParam("name") String name,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "9") int pageSize,
                                    ModelMap modelMap){
        PageInfo<Topic> pageInfo =topicService.findTopicLikeName(name,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("name",name);
        return "topicList";
    }

    @RequestMapping("saveTopic")
    @ResponseBody
    public boolean saveTopic(String topicName,String topicDescribe){

        System.out.println("信息保存");
        topic =new Topic();
        topic.setTopicName(topicName);
        topic.setTopicDescribe(topicDescribe);

        return true;
    }
    @RequestMapping("updateTopic")
    @ResponseBody
    public boolean updateTopic(@RequestParam("id") Integer id,String topicName,String topicDescribe){
        topic =new Topic();
        topic.setId(id);
        topic.setTopicName(topicName);
        topic.setTopicDescribe(topicDescribe);
        return  true;
    }

    @RequestMapping("uploadTopic")
    @ResponseBody
    public boolean uploadTopic(HttpServletRequest request, MultipartFile photo,
                             String topicName,String topicDescribe){

        String name = UUID.randomUUID().toString().replaceAll("-", "");


        String fileName=photo.getOriginalFilename();// 文件原名称

        //获取上传文件的目录

        String path=request.getSession().getServletContext().getRealPath("/");

        String newPath= null;
        try {
            newPath = path.substring(0,path.indexOf("KnowledgeCommunity"))+"images\\";
        } catch (Exception e) {
            e.printStackTrace();
            throw new MailSendException("图片路径不正确");
        }

        //获取图片后缀
        String ext= FilenameUtils.getExtension(fileName);

        //获取文件的后缀
        //String ext2=name.substring(name.lastIndexOf("."), name.length()-1);

        //新图片
        File newfile =new File(newPath+ name+"."+ext);
        //把内存图片写入磁盘中

        try {
            photo.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //把图片信息保存都数据库

        topic.setPhoto(name+"."+ext);
        System.out.println("图片写入");


        return topicService.saveTopic(topic);
    }

    @RequestMapping("deleteTopic")
    @ResponseBody
    public boolean deleteTopic(@RequestParam("id") Integer id){
        return topicService.deleteTopic(id);
    }

}
