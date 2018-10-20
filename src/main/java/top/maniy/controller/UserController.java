package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.maniy.entity.User;
import top.maniy.service.UserService;

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

    /**
     * 默认首页
     * @return
     */
    @RequestMapping(value ="toLogin",method = RequestMethod.GET)
    public String index() {


        return "login";
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
    public String login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password){

        User user =userService.findUserByUsernameAndPassword(username,password);
        if(user!=null){
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            return "1";
        }else {
            return "0";
        }

    }

    /**
     * 获取全部用户信息
     * @return
     */
    @RequestMapping(value = "users")
    @ResponseBody
    public List<User> userList(){
        return userService.findAllUser();
    }


    @RequestMapping(value = "vUsers",method = RequestMethod.GET)
    public String vUserListDef(){

        return "vUserList";
    }

    //分页获取所有认证用户预览信息
    @RequestMapping(value = "vUsers/{page}",method = RequestMethod.GET)
    public String vUserList(@PathVariable(value = "page") int page,
                            @RequestParam(value = "pageSize",required = false,defaultValue = "12") int pageSize,
                            ModelMap modelMap){
        PageInfo<User> pageInfo=userService.findVUserList(1,pageSize);
        modelMap.put("pageInfo",pageInfo);
        return "vUserList";
    }


    /**
     * 登出操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("user",null);
        return "loginPage";
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
