package top.maniy.service;


import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
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

    //根据文章数、问题数、回答数、音频数总和从大大小排列获取num条数据
    List<User> findUserByTotalNumDesc(int num);


    //查询用户名 是否存在
    User findUserByUsername(String username);

    //根据用户名和密码获得用户信息
    User findUserByUsernameAndPassword(String username, String password);

    List<User> findAllUser();

    //认证用户列表
    PageInfo<User> findVUserList(int currentPage, int pageSize);

    //根据认证用户角色文章数量逆序查询3条信息
    List<User> findUserByRoleAndMassageNumbDescTo3();


    //根据角色及文章数量必须大于1按创建时间逆序排序取前3
    List<User> findUserByRoleAndByMassageNumbAndCreateTimeDesc();


    //根据用户id查询信息
    User findUserById(Integer id);

    //改变用户角色
    boolean updateUserRole(String role);

    //添加用户
    boolean saveUser(User user);

    //更新用户
    boolean updateUser(User user);

    //删除用户
    boolean deleteUser(Integer id);


}
