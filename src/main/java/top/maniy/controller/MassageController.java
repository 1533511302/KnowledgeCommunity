package top.maniy.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.*;
import top.maniy.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/16 16:31
 */
@Controller
public class MassageController {

    @Autowired
    private MassageService massageService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CollectionService collectionService;

    /**
     * 图文详情页
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/massages/{id}")
    public String findMassageById(@PathVariable Integer id,ModelMap modelMap){
        massageService.browseNumb(id);

        Massage massage= massageService.findMassageById(id);
        List<Comment> commentList=commentService.findCommentByMassageIdAndByLikeNumbDescTo3(id);

        modelMap.put("commentList",commentList);
        modelMap.put("massage",massage);
        return "massage";
    }

    /**
     * 图文主页
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/massagePage")
    public String massagePage(ModelMap modelMap){
        List<Massage> massageList=massageService.findMassageRandTo10();
        List<Category> categoryList=categoryService.findCategoryByTypeAndStatus(1,"1");
        modelMap.put("massageList",massageList);
        modelMap.put("categoryList",categoryList);
        return "massagesPage";
    }

    /**
     * 图文分类页
     * @param categoryId
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/categoryId/{categoryId}/massages")
    public String findMassageByCategoryId(@PathVariable Integer categoryId,
                                  @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                  @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                  ModelMap modelMap){
        PageInfo<Massage> pageInfo = massageService.findMassageByCategoryId(categoryId,page,pageSize);

        modelMap.put("categoryId",categoryId);
        modelMap.put("pageInfo",pageInfo);
        return "massageList";
    }

    /**
     *根据标题模糊查询图文
     * @param page
     * @param pageSize
     * @param title
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/massages/likeName")
    public String massagePageInfo(@RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                  @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                                  @RequestParam("title") String title,ModelMap modelMap){
        PageInfo<Massage> pageInfo = massageService.findMassageLikeTitle(title,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("title",title);
        return "massageListBySearch";
    }

    @RequestMapping(value = "editMassagePage")
    @RequiresPermissions("massage:insert")
    public String editMassagePage(){
        return "editMassagePage";
    }

    /**
     * 添加图文
     * @param type
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "/massages",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("massage:insert")
    public boolean saveMassage(@RequestParam Integer type ,@RequestParam String title,@RequestParam String content){
        Massage massage =new Massage();
        massage.setCategoryId(type);
        massage.setTitle(title);
        massage.setContent(content);
        return massageService.saveMassage(massage);
    }

    @RequestMapping(value = "/toUpdateMassages",method = RequestMethod.GET)
    @RequiresPermissions("massage:update")
    public String toUpdateMassage(@RequestParam Integer massageId,ModelMap modelMap){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId=userService.findUserByUsername(username).getId();
        Massage massage =massageService.findMassageById(massageId);
        List<Category> categoryList =categoryService.findCategoryByTypeAndStatus(1,"1");
        modelMap.put("massage",massage);
        modelMap.put("categoryList",categoryList);
        modelMap.put("userId",userId);
     return "updateMassagePage";
    }

    @RequestMapping(value = "/updateMassages",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("massage:update")
    public boolean updateMassage(@RequestParam Integer massageId,@RequestParam Integer type ,@RequestParam String title,@RequestParam String content){
        Massage massage =new Massage();
        massage.setId(massageId);
        massage.setCategoryId(type);
        massage.setTitle(title);
        massage.setContent(content);
        return massageService.updateMassage(massage);
    }

    /**
     * 点赞加一
     * @param massageId
     * @return
     */
    @RequestMapping(value = "AddLikeNum")
    @ResponseBody
    @RequiresPermissions("massage:select")
    public boolean addLikeNum(@RequestParam("massageId") Integer massageId) {
       return massageService.LikeNumbAddOne(massageId);
    }

    /**
     * 删除
     * @param massageId
     * @return
     */
    @RequestMapping(value = "/deleteMassage",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("massage:delete")
    public boolean deleteMassage(@RequestParam Integer massageId){

        return massageService.deleteMassage(massageId);
    }

    /**
     * 图文收藏
     * @param modelMap
     * @param request
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "collectionMassage",method = RequestMethod.GET)
    public String collectionMassage(ModelMap modelMap, HttpServletRequest request,
                                    @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize){
        User user =((User)request.getSession().getAttribute("User"));
        List<Collections> collectionsList =collectionService.findCollectionByTypeIsMassage(user.getId());
        PageInfo<Massage> pageInfo =massageService.findMassageByUserCollection(collectionsList,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("user",user);
        return "collectionMassage";
    }


}
