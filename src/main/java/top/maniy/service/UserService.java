package top.maniy.service;


import com.github.pagehelper.PageInfo;
import top.maniy.entity.User;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/9/29 9:17
 */
public interface UserService {

    //根据用户名和密码获得用户信息
    User findUserByUsernameAndPassword(String username, String password);

    List<User> findAllUser();

    //认证用户列表
    PageInfo<User> findVUserList(int currentPage, int pageSize);
    //添加用户
    boolean saveUser(User user);

    //更新用户
    boolean updateUser(User user);

    //删除用户
    boolean deleteUser(Integer id);


}
