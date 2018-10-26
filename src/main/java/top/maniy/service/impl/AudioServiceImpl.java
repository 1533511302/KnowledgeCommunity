package top.maniy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.maniy.entity.Audio;
import top.maniy.mapper.AudioMapper;
import top.maniy.service.AudioService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.service.impl
 * @Description:
 * @date 2018/10/25 23:12
 */
@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    private AudioMapper audioMapper;

    @Override
    public List<Audio> findAudioByCategoryId(Integer categoryId) {
        return null;
    }

    @Override
    public List<Audio> findAudioById(Integer id) {
        return null;
    }

    @Override
    public List<Audio> findAudioLikeAudioName(String audioName) {
        return null;
    }

    @Override
    public List<Audio> findAudioByCategoryIdRand(Integer categoryId, Integer num) {
        return null;
    }

    @Override
    public boolean saveAudio(Audio audio) {
        return false;
    }

    @Override
    public boolean updateAudio(Audio audio) {
        return false;
    }

    @Override
    public boolean deleteAudio(Integer id) {
        return false;
    }
}
