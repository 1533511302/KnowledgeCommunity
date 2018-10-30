package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.User;
import top.maniy.mapper.UserMapper;
import top.maniy.service.UserService;

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
    public boolean saveUser(User user) {
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
