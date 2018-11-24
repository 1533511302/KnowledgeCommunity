package top.maniy.mapper;

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

    boolean deleteCollection(int id);

    boolean saveCollection(Collections collections);
}
