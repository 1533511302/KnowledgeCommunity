package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Collections;
import top.maniy.mapper.CollectionMapper;
import top.maniy.service.CollectionService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/11/23 15:53
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<Collections> findCollectionByTypeIsMassage() {
        return collectionMapper.findCollectionByType(1);
    }

    @Override
    public List<Collections> findCollectionByTypeIsAudio() {
        return collectionMapper.findCollectionByType(2);
    }

    @Override
    public List<Collections> findCollectionByTypeIsQuestion() {
        return collectionMapper.findCollectionByType(3);
    }

    @Override
    public boolean deleteCollection(int id) {
        return collectionMapper.deleteCollection(id);
    }

    @Override
    public boolean saveCollectionByTypeIsMassage(int userId, int massageId) {
        Collections collections =new Collections();
        collections.setUserId(userId);
        collections.setMassageId(massageId);
        return collectionMapper.saveCollection(collections);
    }

    @Override
    public boolean saveCollectionByTypeIsAudio(int userId, int audioId) {
        Collections collections =new Collections();
        collections.setUserId(userId);
        collections.setAudioId(audioId);
        return collectionMapper.saveCollection(collections);
    }

    @Override
    public boolean saveCollectionByTypeIsQuestion(int userId, int QuestionId) {
        Collections collections =new Collections();
        collections.setUserId(userId);
        collections.setQuestionId(QuestionId);
        return collectionMapper.saveCollection(collections);
    }


}
