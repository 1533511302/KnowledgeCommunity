package top.maniy.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import top.maniy.entity.Audio;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service
 * @Description:
 * @date 2018/10/25 23:11
 */
public interface AudioService {

    //音频总数
    Integer findAudioCount();

    //全部音频
    List<Audio> findAllAudio();

    //根据类型查询音频
    PageInfo<Audio> findAudioByCategoryId(Integer categoryId, int currentPage, int pageSize);

    //根据UserId查询音频
    PageInfo<Audio> findAudioByUserId(Integer userId, int currentPage, int pageSize);

    //根据id查询音频
    Audio findAudioById(Integer id);

    //根据类型随机查询num条音频
    List<Audio> findAudioRandTo4();

    //模糊查询音频
    PageInfo<Audio> findAudioLikeAudioName(String audioName, int currentPage, int pageSize);

    //根据类型随机查询num条音频
    List<Audio> findAudioByCategoryIdRand(Integer categoryId,Integer num);

    //添加音频
    boolean saveAudio(Audio audio);

    //更新音频
    boolean updateAudio(Audio audio);

    //删除音频
    boolean deleteAudio(Integer id);
}
