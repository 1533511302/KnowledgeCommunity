package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.maniy.Form.CountForm;
import top.maniy.entity.*;
import top.maniy.service.*;
import top.maniy.shiro.realm.CustomRealm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/16 10:31
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MassageService massageService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AudioService audioService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private CollectionService collectionService;


    @Autowired
    private CustomRealm customRealm;

    private static User user;

    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value ="toLogin",method = RequestMethod.GET)
    public String index() {


        return "loginPage";
    }

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping(value = "/toRegister",method = RequestMethod.GET)
    public String toRegister(){
        return "registerPage";
    }

    /**
     * 登录验证
     * @param request
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, @RequestParam("username") String username,
                        @RequestParam("password") String password,@RequestParam("rememberMe") boolean rememberMe){

//        User user =userService.findUserByUsernameAndPassword(username,password);
//        if(user!=null){
//            HttpSession session=request.getSession();
//            session.setAttribute("user",user);
//            return "1";
//        }else {
//            return "0";
//        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =new UsernamePasswordToken(username,
                password);
        try {

            token.setRememberMe(rememberMe);
            subject.login(token);
//            User user =userService.findUserByUsernameAndPassword(username,password);
//            if(user!=null){
//                subject.getSession().setAttribute("user",user);
//        }
        if(subject.hasRole("3")){
            return "3";
        }
        } catch (AuthenticationException e) {
            return  "0";
        }
        return "1";

    }

    /**
     * 用户名是否存在
     * @return
     */
    @RequestMapping(value = "isUsername")
    @ResponseBody
    public boolean isUsername(@RequestParam String username){
        if(userService.findUserByUsername(username)!=null)
        {
            return true;
        }
        return false;
    }





    /**
     * 分页获取所有认证用户预览信息
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "vUsers/{page}",method = RequestMethod.GET)
    public String vUserList(@PathVariable(value = "page") int page,
                            @RequestParam(value = "pageSize",required = false,defaultValue = "12") int pageSize,
                            ModelMap modelMap){
        PageInfo<User> pageInfo=userService.findVUserList(1,pageSize);
        List<User> userList =userService.findUserByTotalNumDesc(6);

        modelMap.put("userList",userList);
        modelMap.put("pageInfo",pageInfo);
        return "vUserList";
    }


    @RequestMapping(value = "userCenter")
    public String userCenter(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int userId =userService.findUserByUsername(username).getId();
        return "redirect:vUsersQuestion/"+userId;

    }
    /**
     * 认证用户主页图文
     * @param id
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "vUsersCategory/{id}")
    public String UserCategory(@PathVariable(value = "id") int id,
                               @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                               @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                               ModelMap modelMap){


        String username = (String) SecurityUtils.getSubject().getPrincipal();
        modelMap.put("username",username);
        User user=userService.findUserById(id);
        PageInfo<Massage> pageInfo=massageService.findMassageByUserId(id,page,pageSize);
        modelMap.put("user",user);
        modelMap.put("pageInfo",pageInfo);

        return "userCategory";
    }

    /**
     * 认证用户音频
     * @param id
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "vUsersAudio/{id}")
    public String UserAudio(@PathVariable(value = "id") int id,
                               @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                               @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                               ModelMap modelMap){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        modelMap.put("username",username);
        User user=userService.findUserById(id);
        PageInfo<Audio> pageInfo=audioService.findAudioByUserId(id,page, pageSize);
        modelMap.put("user",user);
        modelMap.put("pageInfo",pageInfo);
        return "userAudio";
    }

    /**
     * 认证用户问题
     * @param id
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "vUsersQuestion/{id}")
    public String UserQuestion(@PathVariable(value = "id") int id,
                               @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                               @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                               ModelMap modelMap){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        modelMap.put("username",username);
        User user=userService.findUserById(id);
        PageInfo<Question> pageInfo= questionService.findQuestionByUserId(id,page,pageSize);
        modelMap.put("user",user);
        modelMap.put("pageInfo",pageInfo);
        return "userQuestion";
    }

    /**
     * 认证用户回答
     * @param id
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "vUsersAnswer/{id}")
    public String UserAnswer(@PathVariable(value = "id") int id,
                               @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                               @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                               ModelMap modelMap){

        String username = (String) SecurityUtils.getSubject().getPrincipal();

        modelMap.put("username",username);
        User user=userService.findUserById(id);
        PageInfo<Answer> pageInfo=answerService.findAnswerByUserId(id,page,pageSize);
        modelMap.put("user",user);
        modelMap.put("pageInfo",pageInfo);
        return "userAnswer";
    }




    /**
     * 模糊查询认证用户图文
     * @param id
     * @param title
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "vUsersCategory/{id}/likeTitle")
    public String UserCategoryByUserIdAndLikeTitle(@PathVariable(value = "id") int id,@RequestParam("title") String title,
                               @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                               @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize,
                               ModelMap modelMap){
        User user=userService.findUserById(id);
        PageInfo<Massage> pageInfo=massageService.findMassageByUserIdAndLikeTitle(id,title,page,pageSize);
        modelMap.put("title",title);
        modelMap.put("user",user);
        modelMap.put("pageInfo",pageInfo);
        return "userCategory";
    }




    /**
     * 登出操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        //清除shiro缓存
        customRealm.clearCached();
        return "redirect:toLogin";
    }

    /**
     * 添加操作
     * @param user
     * @return
     */
    @RequestMapping(value = "users",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveUser(User user){
        return userService.saveUser(user);
    }

    /**
     * 物理删除操作
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public boolean deleteUser(Integer id){
        return userService.deleteUser(id);
    }

    /**
     * 逻辑删除操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteUserByForbidden(@PathVariable Integer id){
        User user=new User();
        user.setForbidden("1");
        return userService.updateUser(user);
    }

    /**
     * 个人信息界面

     * @param modelMap
     * @return
     */
    @RequestMapping(value = "userInfo/{id}",method = RequestMethod.GET)
    public String toUpdateUserInfo(@PathVariable int id,ModelMap modelMap){
        User user =userService.findUserById(id);
        modelMap.put("user",user);
        return "updateUserInfo";
    }

    /**
     * 修改个人信息
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public String updateUser(HttpServletRequest request,User user){
        User user1 =(User)request.getSession().getAttribute("User");
        System.out.println(user);
        user.setId(user1.getId());
        userService.updateUser(user);
        return "redirect:vUsersQuestion/"+user.getId();
    }


    /**
     * 修改密码界面
     * @return
     */
    @RequestMapping(value = "toUpdateUserPassword/{id}",method = RequestMethod.GET)
    public String toUpdateUserPassword(@PathVariable int id,ModelMap modelMap){
        User user =userService.findUserById(id);
        modelMap.put("user",user);
        return "updatePassword";
    }
    /**
     * 修改密码
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(value = "updateUserPassword",method = RequestMethod.POST)
    @ResponseBody
    public String updateUserPassword(String username,String oldPassword,String newPassword){
        User user =userService.findUserByUsername(username);
        if(user!=null){
            Md5Hash md5Hash= new Md5Hash(oldPassword,username);
            String temp=md5Hash.toString();
            System.out.println(md5Hash.toString());
            System.out.println(user.getPassword());
            if(user.getPassword().equals(temp)){
                Md5Hash newMd5= new Md5Hash(newPassword,username);
                User tempUser= new User();
                tempUser.setId(user.getId());
                tempUser.setPassword(newMd5.toString());

                if(userService.updateUser(tempUser)){
                    return "2";
                }
                return "0";
            }
            return "1";
        }
        return "0";
    }

    @RequestMapping(value = "collectionVUser",method = RequestMethod.GET)
    public String collectionMassage(ModelMap modelMap,HttpServletRequest request,
                                    @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") Integer pageSize){
        User user =((User)request.getSession().getAttribute("User"));
        List<Collections> collectionsList =collectionService.findCollectionByTypeIsVUser(user.getId());
        PageInfo<User> pageInfo =userService.findVUserByUserCollection(collectionsList,page,pageSize);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("user",user);
        return "collectionVUser";
    }

    /**
     * 所有用户
     * @return
     */
    @RequestMapping("AllUser")
    @ResponseBody
    public List<User> AllUser(){
        return userService.findAllUser();
    }


    /**
     * 修改用户信息
     *
     * @return
     */
    @RequestMapping("AdminUpdateUser")
    @ResponseBody
    public boolean AdminUpdateUser(User user2){
        user =new User();
        user.setId(user2.getId());
        user.setEmail(user2.getEmail());
        user.setRealname(user2.getRealname());
        user.setGender(user2.getGender());
        user.setAutograph(user2.getAutograph());
        user.setForbidden(user2.getForbidden());
        return  true;

    }

    /**
     * 修改图片
     * @param request
     * @param photo
     * @param topicName
     * @param topicDescribe
     * @return
     */
    @RequestMapping("uploadUser")
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

        user.setPhoto(name+"."+ext);
        System.out.println("图片写入");


        return userService.updateUser(user);
    }


    //性别统计
    @RequestMapping("count/userByGender")
    @ResponseBody
    public List<CountForm> countUserByGender(){
        return userService.CountUserByGender();
    }

    //角色统计
    @RequestMapping("count/userByRole")
    @ResponseBody
    public List<CountForm> countUserByRole(){
        return userService.CountUserByRole();
    }

}
