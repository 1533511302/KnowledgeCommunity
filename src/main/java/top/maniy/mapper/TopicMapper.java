package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Topic;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/20 14:56
 */
public interface TopicMapper {
    //查询全部话题
    List<Topic> findAllTopic();
    //topicName模糊查询
    List<Topic> findTopicLikeName(@Param("code") String code);

    //随机num个话题
    List<Topic> findTopicRand(Integer num);
    //根据id查询话题
    Topic findTopicById(Integer id);
    //添加话题
    boolean saveTopic(Topic topic);
    //更新话题
    boolean updateTopic(Topic topic);
    //删除话题
    boolean deleteTopic(Integer id);
}
