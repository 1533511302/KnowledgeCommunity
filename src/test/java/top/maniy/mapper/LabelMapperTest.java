package top.maniy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.Label;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/12/4 12:26
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
public class LabelMapperTest {

    @Autowired
    private LabelMapper labelMapper;
    @Test
    public void findMassageLabelByHot() {
        List<Label> labelList =labelMapper.findMassageLabelByHot(9);
        System.out.println(labelList.size());
    }

    @Test
    public void findAudioLabelByHot() {
    }

    @Test
    public void findQuestionLabelByHot() {
    }

    @Test
    public void saveLabel() {
    }

    @Test
    public void deleteLabel() {
    }
}