package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Topic;
import top.maniy.mapper.TopicMapper;
import top.maniy.service.TopicService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/20 15:38
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicMapper topicMapper;

    @Override
    public List<Topic> findAllTopic() {
        return topicMapper.findAllTopic();
    }

    @Override
    public PageInfo<Topic> findAllTopic(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Topic> topicList=topicMapper.findAllTopic();
        PageInfo<Topic> pageInfo =new PageInfo<>(topicList);
        return pageInfo;
    }

    @Override
    public PageInfo<Topic> findTopicLikeName(String name,int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Topic> topicList=topicMapper.findTopicLikeName(name);
        PageInfo<Topic> pageInfo =new PageInfo<>(topicList);
        return pageInfo;
    }

    @Override
    public List<Topic> findTopicRandTo4() {
        return topicMapper.findTopicRand(4);
    }

    @Override
    public Topic findTopicById(Integer id) {
        return topicMapper.findTopicById(id);
    }

    @Override
    public boolean saveTopic(Topic topic) {
        return topicMapper.saveTopic(topic);
    }

    @Override
    public boolean updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    public boolean deleteTopic(Integer id) {
        return topicMapper.deleteTopic(id);
    }
}
