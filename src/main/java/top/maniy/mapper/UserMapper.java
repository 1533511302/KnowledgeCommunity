package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.User;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/9/29 9:07
 */
public interface UserMapper {
    //根据用户名和密码获得用户信息
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<User> findAllUser();
    //根据用户角色查询信息
    List<User> findUserByRole(String role);
    //添加用户
    boolean saveUser(User user);

    //更新用户
    boolean updateUser(User user);

    //删除用户
    boolean deleteUser(Integer id);




}
