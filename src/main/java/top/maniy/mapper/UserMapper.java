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
    //用户总数
    Integer findUserCount();

    //根据音频数从大到下取num条user数据（前提音频数大于或等于1）
    List<User> findUserByAudioNumDesc(@Param("num") int num);

    //根据文章数、问题数、回答数、音频数总和从大大小排列获取num条数据
    List<User> findUserByTotalNumDesc(@Param("num") int num);

    //根据username查询角色
    List<String> queryRolesByUserName(String username);

    //根据username查询权限
    List<String> queryPermissionByUserName(String userName);

    //查询用户名 是否存在
    User findUserByUsername(String username);

    //根据用户名和密码获得用户信息
    User findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    List<User> findAllUser();
    //根据用户角色查询信息
    List<User> findUserByRole(String role);

    //根据性别查询信息
    Integer countUserByGender(@Param("gender") String gender);

    //根据角色查询信息
    Integer countUserByRole(@Param("role") String role);

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
