package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.User;
import top.maniy.mapper.UserMapper;
import top.maniy.service.UserService;
import top.maniy.shiro.realm.CustomRealm;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/16 10:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermapper;
    //注入realm
    @Autowired
    private CustomRealm customRealm;

    @Override
    public User findUserByUsername(String username) {
        return usermapper.findUserByUsername(username);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return usermapper.findUserByUsernameAndPassword(username,password);
    }

    @Override
    public List<User> findAllUser() {
        return usermapper.findAllUser();
    }

    @Override
    public PageInfo<User> findVUserList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList =usermapper.findUserByRole("2");
        PageInfo<User> pageInfo =new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public List<User> findUserByRoleAndMassageNumbDescTo3() {
        return usermapper.findUserByRoleAndMassageNumbDesc("2",0,3);
    }

    @Override
    public List<User> findUserByRoleAndByMassageNumbAndCreateTimeDesc() {
        return usermapper.findUserByRoleAndByMassageNumbAndCreateTimeDesc("2",1,0,3);
    }

    @Override
    public User findUserById(Integer id) {

        return usermapper.findUserById(id);
    }

    @Override
    public boolean updateUserRole(String role) {

        User user =new User();
        user.setRole(role);
        //修改角色权限，清除shiro缓存
        customRealm.clearCached();
        return usermapper.updateUser(user);
    }


    @Override
    public boolean saveUser(User user) {
        //单一的是密码加密容易破解，这时候就需要 加盐
        Md5Hash md5Hash= new Md5Hash(user.getPassword(),user.getUsername());
        user.setPassword(md5Hash.toString());
        return usermapper.saveUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return usermapper.updateUser(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return usermapper.deleteUser(id);
    }

}
