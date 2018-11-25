package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.maniy.entity.User;
import top.maniy.service.CollectionService;

import javax.servlet.http.HttpServletRequest;

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

}
