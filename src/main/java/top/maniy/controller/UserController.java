package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.*;
import top.maniy.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    /**
     * 默认首页
     * @return
     */
    @RequestMapping(value ="toLogin",method = RequestMethod.GET)
    public String index() {


        return "loginPage";
    }

    @RequestMapping(value = "registerPage",method = RequestMethod.GET)
    public String registerPage(){
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
            System.out.println(rememberMe);
            token.setRememberMe(rememberMe);
            subject.login(token);

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





    @RequestMapping(value = "vUsers",method = RequestMethod.GET)
    public String vUserListDef(){

        return "vUserList";
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
        modelMap.put("pageInfo",pageInfo);
        return "vUserList";
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
    @RequestMapping(value = "/users/",method = RequestMethod.DELETE)
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
    public boolean deleteUserByForbidden(Integer id){
        User user=new User();
        user.setForbidden("1");
        return userService.updateUser(user);
    }

}
