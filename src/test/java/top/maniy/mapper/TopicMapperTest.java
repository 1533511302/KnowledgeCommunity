package top.maniy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.Topic;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/20 15:14
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-dao.xml","classpath*:/spring/spring-service.xml"})

public class TopicMapperTest {

    @Autowired
    private TopicMapper topicMapper;
    @Test
    public void findAllTopic() {
        List<Topic> topicList =topicMapper.findAllTopic();
        System.out.println(topicList);
    }

    @Test
    public void findTopicById() {
    }

    @Test
    public void saveTopic() {
        Topic topic=new Topic();
        topic.setTopicClassId(1);
        topic.setTopicDescribe("40岁是买房号还是租房好？大家来聊一聊");
        topic.setTopicName("40岁是买房号还是租房好？");
        topic.setPhoto("xxx.jpg");
        topicMapper.saveTopic(topic);
    }

    @Test
    public void updateTopic() {
        Topic topic=new Topic();
        topic.setId(2);
        topic.setTopicClassId(1);
        topic.setTopicDescribe("30岁是买房号还是租房好？大家来聊一聊");
        topic.setTopicName("30岁是买房号还是租房好？");
        topic.setPhoto("xxx.jpg");
        topicMapper.updateTopic(topic);
    }

    @Test
    public void deleteTopic() {
        topicMapper.deleteTopic(3);
    }
}