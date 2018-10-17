package top.maniy.service;

import top.maniy.entity.Topicclass;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/17 23:03
 */
public interface TopicclassService {
    //查询全部话题类别
    List<Topicclass> findAllTopicclass();
    //查询根据id数组查询话题类别
    List<Topicclass> findSomeTopicclass(Integer[] ids);
    //添加话题类别
    boolean saveTopicclass(Topicclass topicclass);
    //修改话题类别
    boolean updateTopicclass(Topicclass topicclass);
    //删除话题类别
    boolean deleteTopicclass(Integer id);
}
