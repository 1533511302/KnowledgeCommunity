package top.maniy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.Massage;


import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/18 19:46
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-dao.xml","classpath*:/spring/spring-service.xml"})
public class MassageMapperTest {

    @Autowired
    private MassageMapper massageMapper;

    @Test
    public void findMassageByCategoryId() {
    }

    @Test
    public void findMassageById() {
    }

    @Test
    public void findMassageLikeLabel() {
    }

    @Test
    public void findMassageLikeTitle(){
        List<Massage> massageList=massageMapper.findMassageLikeTitle("苹果");
        System.out.println(massageList.size());
    }

    @Test
    public void saveMassage() {
        Massage massage =new Massage();
        massage.setTitle("百度无人汽车");
        massage.setContent("百度无人汽车牛逼啊");
        massageMapper.saveMassage(massage);
    }

    @Test
    public void findMassageByCreateTimeDesc(){
        List<Massage> massageList =massageMapper.findMassageByCreateTimeDesc(0,4);
        System.out.println(massageList.size());
    }

    @Test
    public void updateMassage() {
        int likeNumb=massageMapper.findMassageById(1).getLikeNumb();
        System.out.println(likeNumb);
        Massage massage=new Massage();
        massage.setLikeNumb(likeNumb+1);
        System.out.println(massage);
        massageMapper.updateMassage(massage);
    }

    @Test
    public void deleteMassage() {
    }
}