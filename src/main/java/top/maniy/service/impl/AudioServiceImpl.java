package top.maniy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public Integer findAudioCount() {
        return audioMapper.findAudioCount();
    }

    @Override
    public List<Audio> findAllAudio() {
        return audioMapper.findAllAudio();
    }

    @Override
    public PageInfo<Audio> findAudioByCategoryId(Integer categoryId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Audio> audioList=audioMapper.findAudioByCategoryId(categoryId);
        PageInfo<Audio> pageInfo=new PageInfo<>(audioList);
        return pageInfo;
    }

    @Override
    public PageInfo<Audio> findAudioByUserId(Integer userId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Audio> audioList=audioMapper.findAudioByUserId(userId);
        PageInfo<Audio> pageInfo=new PageInfo<>(audioList);
        return pageInfo;
    }

    @Override
    public List<Audio> findAudioByUserId(Integer userId) {
        return audioMapper.findAudioByUserId(userId);
    }

    @Override
    public Audio findAudioById(Integer id) {
        return audioMapper.findAudioById(id);
    }

    @Override
    public List<Audio> findAudioRandTo4() {
        return audioMapper.findAudioRand(4);
    }

    @Override
    public PageInfo<Audio> findAudioLikeAudioName(String audioName, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Audio> audioList=audioMapper.findAudioLikeAudioName(audioName);
        PageInfo<Audio> pageInfo=new PageInfo<>(audioList);
        return pageInfo;
    }

    @Override
    public List<Audio> findAudioByCategoryIdRand(Integer categoryId, Integer num) {
        return audioMapper.findAudioByCategoryIdRand(categoryId,num);
    }

    @Override
    public boolean saveAudio(Audio audio) {
        return audioMapper.saveAudio(audio);
    }

    @Override
    public boolean updateAudio(Audio audio) {
        return audioMapper.updateAudio(audio);
    }

    @Override
    public boolean deleteAudio(Integer id) {
        return audioMapper.deleteAudio(id);
    }
}
