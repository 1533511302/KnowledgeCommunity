package top.maniy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.User;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/18 11:08
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-dao.xml","classpath*:/spring/spring-service.xml"})

public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findUserByUsernameAndPassword() {
    }

    @Test
    public void findAllUser() {
    }

    @Test
    public void saveUser() {
        User user =new User();
        user.setEmail("1533511302@qq.com");
        user.setPassword("123456");
        user.setUsername("grade12");
        user.setRealname("王明旭");
        user.setGender("1");
        user.setPhoto("xxx.jpg");
        user.setAutograph("美国哈佛大学医学博士");
        user.setIntroduce("王明旭教授，博士生导师。美国哈佛大学和麻省理工大学医学博士、物理学博士，美国范德比尔大学教授，国际著名屈光手术和角膜病治疗专家。曾任美国FDA准分子激光新技术和仪器设备审批委员。");
        userMapper.saveUser(user);
    }

    @Test
    public void updateUser() {
        User user =new User();
        user.setEmail("123456781@163.com");
        user.setId(6);
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUser() {

        userMapper.deleteUser(1);
    }
}