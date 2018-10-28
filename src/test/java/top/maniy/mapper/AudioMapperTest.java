package top.maniy.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.maniy.entity.Audio;

import static org.junit.Assert.*;

/**
 * @author liuzonghua
 * @Package top.maniy.mapper
 * @Description:
 * @date 2018/10/25 22:58
 */
//帮我们创建容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器是使用那些配置文件
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
public class AudioMapperTest {
    @Autowired
    private AudioMapper audioMapper;

    @Test
    public void findAudioByCategoryId() {
    }

    @Test
    public void findAudioById() {
    }

    @Test
    public void findAudioLikeAudioName() {
    }

    @Test
    public void findAudioByCategoryIdRand() {
        System.out.println(audioMapper.findAudioByCategoryIdRand(20,12).size());
    }

    @Test
    public void saveAudio() {
        Audio audio=new Audio();
        audio.setUserId(1);
        audio.setUserName("高晓松");
        audio.setCategoryId(1);
        audio.setUrl("mp3/mp3/1.mp3");
        audio.setAudioName("矮大紧指北");
        audio.setAudioDescribe("一个很有趣的见识分享");
        audio.setPhoto("xxx.jpg");
        for(int i=0;i<40;i++) {
            audioMapper.saveAudio(audio);
        }
    }

    @Test
    public void updateAudio() {
    }

    @Test
    public void deleteAudio() {
    }
}