package top.maniy.service;

import com.github.pagehelper.PageInfo;
import top.maniy.entity.Topic;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/20 15:37
 */
public interface TopicService {

    //查询全部话题
    PageInfo<Topic> findAllTopic(int currentPage, int pageSize);
    //topicName模糊查询
    PageInfo<Topic> findTopicLikeName(String name,int currentPage, int pageSize);
    //根据id查询话题
    Topic findTopicById(Integer id);
    //添加话题
    boolean saveTopic(Topic topic);
    //更新话题
    boolean updateTopic(Topic topic);
    //删除话题
    boolean deleteTopic(Integer id);
}
