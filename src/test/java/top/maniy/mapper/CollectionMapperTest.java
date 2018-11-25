package top.maniy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/11/25 11:02
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
public class CollectionMapperTest {
    @Autowired
    private CollectionMapper collectionMapper;

    @Test
    public void findCollectionByType() {
    }

    @Test
    public void deleteCollection() {
    }

    @Test
    public void saveCollection() {
    }

    @Test
    public void findCollectionByUserIdAndMassageId() {
        System.out.println(collectionMapper.findCollectionByUserIdAndMassageId(1,2).getId());
    }

    @Test
    public void findCollectionByUserIdAndAudioId() {
    }

    @Test
    public void findCollectionByUserIdAndQuestionId() {
    }
}