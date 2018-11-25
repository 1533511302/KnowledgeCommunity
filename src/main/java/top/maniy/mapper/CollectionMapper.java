package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Collections;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/11/23 15:20
 */
public interface CollectionMapper {
    //根据类型获取收藏列表
    List<Collections> findCollectionByType(int type);
    //删除收藏
    boolean deleteCollection(int id);
    //添加收藏
    boolean saveCollection(Collections collections);
    //查询已收藏的文章
    Collections findCollectionByUserIdAndMassageId(@Param("userId") int userId,@Param("massageId") int massageId);
    //查询已收藏的文章
    Collections findCollectionByUserIdAndAudioId(@Param("userId") int userId,@Param("audioId") int audioId);
    //查询已收藏的文章
    Collections findCollectionByUserIdAndQuestionId(@Param("userId") int userId,@Param("questionId") int questionId);
}
