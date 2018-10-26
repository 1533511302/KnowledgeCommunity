package top.maniy.mapper;

import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Audio;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/25 21:58
 */
public interface AudioMapper {
    //根据类型查询音频
    List<Audio> findAudioByCategoryId(Integer categoryId);

    //根据id查询音频
    List<Audio> findAudioById(Integer id);
    //模糊查询音频
    List<Audio> findAudioLikeAudioName(@Param("audioName") String audioName);

    //根据类型随机查询num条音频
    List<Audio> findAudioByCategoryIdRand(@Param("categoryId") Integer categoryId, @Param("num") Integer num);

    //添加音频
    boolean saveAudio(Audio audio);

    //更新音频
    boolean updateAudio(Audio audio);

    //删除音频
    boolean deleteAudio(Integer id);

}
