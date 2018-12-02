package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.maniy.entity.Collections;
import top.maniy.entity.Massage;
import top.maniy.entity.User;
import top.maniy.service.CollectionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/11/23 16:09
 */
@Controller
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 添加收藏文章
     * @param massageId
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveCollectionMassage")
    @ResponseBody
    public String saveCollectionByTypeIsMassage(@RequestParam("massageId") Integer massageId,HttpServletRequest request){

            //用户信息
            User user = (User) request.getSession().getAttribute("User");

            if(user!=null){

                //判断是否已经收藏
                if(collectionService.findCollectionByUserIdAndMassageId(user.getId(),massageId)){
                    //添加收藏
                    System.out.println("存在");
                    return "2";
                }
                collectionService.saveCollectionByTypeIsMassage(user.getId(),massageId);
                return "1";
            }

             return "0";


    }

    /**
     * 删除收藏文章
     * @param massageId
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteCollectionMassage")
    @ResponseBody
    public boolean deleteCollectionMassage(@RequestParam("massageId") Integer massageId,HttpServletRequest request){
        //用户信息
        User user = (User) request.getSession().getAttribute("User");
        if(user!=null){
            if(collectionService.findCollectionByUserIdAndMassageId(user.getId(),massageId)){
                collectionService.deleteCollectionMassage(user.getId(),massageId);
                return  true;
            }

        }
        return false;
    }



    /**
     * 添加关注认证用户
     * @param vUserId
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveCollectionVUser")
    @ResponseBody
    public String saveCollectionByTypeIsVUser(@RequestParam("vUserId") Integer vUserId,HttpServletRequest request){

        //用户信息
        User user = (User) request.getSession().getAttribute("User");

        if(user!=null){

            //判断是否已经收藏
            if(collectionService.findCollectionByUserIdAndVUserId(user.getId(),vUserId)){
                //添加收藏
                System.out.println("存在");
                return "2";
            }
            collectionService.saveCollectionByTypeIsVUser(user.getId(),vUserId);
            return "1";
        }

        return "0";


    }

    /**
     * 删除关注认证用户
     * @param vUserId
     * @param request
     * @return
     */
    @RequestMapping(value = "/deleteCollectionVUser")
    @ResponseBody
    public boolean deleteCollectionVUser(@RequestParam("vUserId") Integer vUserId,HttpServletRequest request){
        //用户信息
        User user = (User) request.getSession().getAttribute("User");
        if(user!=null){
            if(collectionService.findCollectionByUserIdAndVUserId(user.getId(),vUserId)){
                collectionService.deleteCollectionVUser(user.getId(),vUserId);
                return  true;
            }

        }
        return false;
    }


}
