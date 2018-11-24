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
    public String saveCollectionByTypeIsMassage(@RequestParam("massageId") Integer massageId){

            System.out.println("user");
             collectionService.saveCollectionByTypeIsMassage(1,massageId);
             return "1";


    }

}
