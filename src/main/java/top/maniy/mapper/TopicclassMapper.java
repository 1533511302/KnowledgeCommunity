package top.maniy.mapper;

import top.maniy.entity.Topicclass;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/17 22:27
 */
public interface TopicclassMapper {
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
