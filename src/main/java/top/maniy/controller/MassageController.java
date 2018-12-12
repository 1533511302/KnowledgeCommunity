package top.maniy.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.maniy.Form.ImgResultForm;
import top.maniy.Form.MassageForm;
import top.maniy.entity.*;
import top.maniy.service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private LabelService labelService;

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
        //热门认证用户前三 by文章数
        List<User> hotUserList=userService.findUserByRoleAndMassageNumbDescTo3();
        //文章大于或等于1新认证用户前三 bycreateTime
        List<User> newUserList=userService.findUserByRoleAndByMassageNumbAndCreateTimeDesc();
        modelMap.put("newUserList",newUserList);
        modelMap.put("hotUserList",hotUserList);
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
        //点赞量最多的4篇文章
        List<Massage> likeMassageList =massageService.findMassageByLikeNumbDesc0To4();
        //文章大于或等于1新认证用户前三 bycreateTime
        List<User> newUserList=userService.findUserByRoleAndByMassageNumbAndCreateTimeDesc();
        //随机10片文章
        List<Massage> massageList=massageService.findMassageRandTo10();
        List<Category> categoryList=categoryService.findCategoryByTypeAndStatus(1,"1");
        List<Label> labelList =labelService.findMassageLabelByHot(20);
        modelMap.put("massageList",massageList);
        modelMap.put("categoryList",categoryList);
        modelMap.put("labelList",labelList);
        modelMap.put("newUserList",newUserList);
        modelMap.put("likeMassageList",likeMassageList);
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
        //文章大于或等于1新认证用户前三 bycreateTime
        List<User> newUserList=userService.findUserByRoleAndByMassageNumbAndCreateTimeDesc();
        PageInfo<Massage> pageInfo = massageService.findMassageByCategoryId(categoryId,page,pageSize);
        List<Label> labelList =labelService.findMassageLabelByHot(20);
        modelMap.put("categoryId",categoryId);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("labelList",labelList);
        modelMap.put("newUserList",newUserList);
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
        //title不为空
        if(title!="" && title!=null){
            //查询是否存在
            Label label=labelService.findLabelByMassageLabel(title);
            if (label==null){//不存在加标签
                labelService.saveMassageLabel(title);
            }else {
                //存在的话，标签热点加一
                label.setMassageLabelHot(label.getMassageLabelHot()+1);
                labelService.updateLabel(label);
            }

        }
        //热门认证用户前三 by文章数
        List<User> hotUserList=userService.findUserByRoleAndMassageNumbDescTo3();

        PageInfo<Massage> pageInfo = massageService.findMassageLikeTitle(title,page,pageSize);
        List<Label> labelList =labelService.findMassageLabelByHot(20);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("title",title);
        modelMap.put("labelList",labelList);
        modelMap.put("hotUserList",hotUserList);
        return "massageListBySearch";
    }

    @RequestMapping(value = "editMassagePage")
    @RequiresPermissions("massage:insert")
    public String editMassagePage(){
        return "editMassagePage";
    }

    /**
     * 添加图文
     * @return
     */
    @RequestMapping(value = "/massages",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("massage:insert")
    public boolean saveMassage(HttpServletRequest request, @RequestParam(required = false) MultipartFile photo,
                               @RequestParam Integer type ,@RequestParam String title,@RequestParam String content){
        User user = (User) request.getSession().getAttribute("User");
        Massage massage =new Massage();
        massage.setCategoryId(type);
        massage.setUserId(user.getId());
        massage.setUsername(user.getRealname());
        massage.setTitle(title);
        massage.setContent(content);



        if(photo!=null){
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
            massage.setPhoto(name+"."+ext);
        }else {
            massage.setPhoto("191ea1c12d824851ade02cfcf0e61e31.jpg");
        }

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

    /**全部图文
     *
     * @return
     */
    @RequestMapping("findAllMassage")
    @ResponseBody
    public List<MassageForm> findAllMassage(){
        List<MassageForm> massageFormList =new ArrayList<>();
        List<Massage> massageList=massageService.findAllMassage();
        for(Massage massage:massageList){
            MassageForm massageForm =new MassageForm();
            massageForm.setId(massage.getId());
            massageForm.setTitle(massage.getTitle());
            massageForm.setUsername(massage.getUsername());
            massageForm.setLikeNumb(massage.getLikeNumb());
            massageForm.setBrowseNumb(massage.getBrowseNumb());
            massageForm.setCreateTime(massage.getCreateTime());
            massageForm.setCommentNumb(massage.getCommentNumb());
            massageForm.setCategory(categoryService.findCategoryById(massage.getCategoryId()).getCategoryName());
            massageFormList.add(massageForm);
        }
        return massageFormList;
    }

    @RequestMapping("uploadMassagePhoto")
    @ResponseBody
    public ImgResultForm uploadMassagePhoto(HttpServletRequest request, MultipartFile photo){
        System.out.println("请求到了什么，图片吧");
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
        String[] strArray=new String[]{"/img/"+ name+"."+ext};
        ImgResultForm imgResultForm =new ImgResultForm(0,strArray);
        return imgResultForm;
    }

}
