package top.maniy.service;

import top.maniy.entity.Collections;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/11/23 15:47
 */
public interface CollectionService {

    //获取收藏文章列表
    List<Collections> findCollectionByTypeIsMassage();
    //获取收藏音频列表
    List<Collections> findCollectionByTypeIsAudio();
    //获取收藏问题列表
    List<Collections> findCollectionByTypeIsQuestion();
    //删除
    boolean deleteCollection(int id);
    //添加文章收藏
    boolean saveCollectionByTypeIsMassage(int userId,int massageId);
    //添加音频收藏
    boolean saveCollectionByTypeIsAudio(int userId,int AudioId);
    //添加问题收藏
    boolean saveCollectionByTypeIsQuestion(int userId,int QuestionId);
}
