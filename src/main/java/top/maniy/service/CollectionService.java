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
    List<Collections> findCollectionByTypeIsMassage(int userId);
    //获取收藏音频列表
    List<Collections> findCollectionByTypeIsAudio(int userId);
    //获取收藏问题列表
    List<Collections> findCollectionByTypeIsQuestion(int userId);
    //获取关注认证用户列表
    List<Collections> findCollectionByTypeIsVUser(int userId);
    //删除
    boolean deleteCollection(int id);
    //删除已收藏的文章
    boolean deleteCollectionMassage(int userId,int massageId);
    //删除已收藏的音频
    boolean deleteCollectionAudio(int userId,int audioId);
    //删除已收藏的问题
    boolean deleteCollectionQuestion(int userId,int questionId);
    //删除已关注的认证用户
    boolean deleteCollectionVUser(int userId,int vUserId);
    //添加文章收藏
    boolean saveCollectionByTypeIsMassage(int userId,int massageId);
    //添加音频收藏
    boolean saveCollectionByTypeIsAudio(int userId,int AudioId);
    //添加问题收藏
    boolean saveCollectionByTypeIsQuestion(int userId,int QuestionId);
    //添加认证用户关注
    boolean saveCollectionByTypeIsVUser(int userId,int vUserId);
    //是否已经收藏文章
    boolean findCollectionByUserIdAndMassageId(int userId,int massageId);
    //是否已经收藏音频
    boolean findCollectionByUserIdAndAudioId(int userId,int audioId);
    //是否已经收藏问题
    boolean findCollectionByUserIdAndQuestionId(int userId,int questionId);
    //是否已经关注认证用户
    boolean findCollectionByUserIdAndVUserId(int userId,int vUserId);

}
