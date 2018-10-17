package top.maniy.service.impl;

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
    public User findUserByUsernameAndPassword(String username, String password) {
        return usermapper.findUserByUsernameAndPassword(username,password);
    }

    @Override
    public List<User> findAllUser() {
        return usermapper.findAllUser();
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
