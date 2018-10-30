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

    //查询用户名 是否存在
    User findUserByUsername(String username);

    //根据用户名和密码获得用户信息
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<User> findAllUser();
    //根据用户角色查询信息
    List<User> findUserByRole(String role);

    //根据用户角色文章数量逆序查询信息
    List<User> findUserByRoleAndMassageNumbDesc(@Param("role") String role,@Param("start") int start,@Param("end") int end);

    //根据角色及文章数量按创建时间逆序排序
    List<User> findUserByRoleAndByMassageNumbAndCreateTimeDesc(@Param("role") String role,@Param("massagenumb")int massagenumb,@Param("start") int start,@Param("end") int end);
    //根据用户id查询信息
    User findUserById(Integer id);
    //添加用户
    boolean saveUser(User user);

    //更新用户
    boolean updateUser(User user);

    //删除用户
    boolean deleteUser(Integer id);




}
