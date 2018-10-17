package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Topicclass;
import top.maniy.mapper.TopicclassMapper;
import top.maniy.service.TopicclassService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/17 23:06
 */
@Service
public class TopicclassServiceImpl implements TopicclassService{

    @Autowired
    private TopicclassMapper topicclassMapper;
    @Override
    public List<Topicclass> findAllTopicclass() {
        return topicclassMapper.findAllTopicclass();
    }

    @Override
    public List<Topicclass> findSomeTopicclass(Integer[] ids) {
        return topicclassMapper.findSomeTopicclass(ids);
    }

    @Override
    public boolean saveTopicclass(Topicclass topicclass) {
        return topicclassMapper.saveTopicclass(topicclass);
    }

    @Override
    public boolean updateTopicclass(Topicclass topicclass) {
        return topicclassMapper.updateTopicclass(topicclass);
    }

    @Override
    public boolean deleteTopicclass(Integer id) {
        return topicclassMapper.deleteTopicclass(id);
    }
}
