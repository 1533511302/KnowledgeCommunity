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
        collections.setType(1);
        return collectionMapper.saveCollection(collections);
    }

    @Override
    public boolean saveCollectionByTypeIsAudio(int userId, int audioId) {
        Collections collections =new Collections();
        collections.setUserId(userId);
        collections.setAudioId(audioId);
        collections.setType(2);
        return collectionMapper.saveCollection(collections);
    }

    @Override
    public boolean saveCollectionByTypeIsQuestion(int userId, int QuestionId) {
        Collections collections =new Collections();
        collections.setUserId(userId);
        collections.setQuestionId(QuestionId);
        collections.setType(3);
        return collectionMapper.saveCollection(collections);
    }

    @Override
    public boolean findCollectionByUserIdAndMassageId(int userId, int massageId) {
        Collections collections = collectionMapper.findCollectionByUserIdAndMassageId(userId,massageId);
        if(collections!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean findCollectionByUserIdAndAudioId(int userId, int audioId) {
        Collections collections = collectionMapper.findCollectionByUserIdAndAudioId(userId,audioId);
        if(collections!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean findCollectionByUserIdAndQuestionId(int userId, int questionId) {
        Collections collections = collectionMapper.findCollectionByUserIdAndQuestionId(userId,questionId);
        if(collections!=null){
            return true;
        }
        return false;
    }


}
