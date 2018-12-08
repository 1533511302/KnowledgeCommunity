package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.Form.AudioForm;
import top.maniy.entity.Audio;
import top.maniy.entity.Category;
import top.maniy.service.AudioService;
import top.maniy.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/10/25 23:20
 */
@Controller
public class AudioController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AudioService audioService;

    /**
     * 音频主页
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/audioPage")
    public String audioPage(ModelMap modelMap){
        //获取音频分类
        List<Category> categoryList=categoryService.findCategoryByTypeAndStatus(2,"1");
        List<Category> categoryListRand4=categoryService.findCategoryByTypeRandNum(2,4);
        int i=1;
        for(Category category:categoryListRand4){

            //随机获取分类中的12条
            List<Audio> audioList=audioService.findAudioByCategoryIdRand(category.getId(),12);

            modelMap.put("categoryName"+i,category.getCategoryName());
            modelMap.put("audioList"+i,audioList);
            i++;
        }
        modelMap.put("categoryList",categoryList);
        return "audioPage";
    }

    /**
     * 音频分类页
     * @param categoryId
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "audioList/{categoryId}")
    public String audioList(@PathVariable Integer categoryId, @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                            @RequestParam(value="pageSize", required=false, defaultValue="12") Integer pageSize,
                            ModelMap modelMap){
        //获取音频分类
        List<Category> categoryList=categoryService.findCategoryByTypeAndStatus(2,"1");
        //音频分页
        PageInfo<Audio> pageInfo=audioService.findAudioByCategoryId(categoryId,page,pageSize);
        //获取音频类别信息
        Category category =categoryService.findCategoryById(categoryId);
        modelMap.put("category",category);
        modelMap.put("categoryId",categoryId);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("categoryList",categoryList);
        return "audioList";
    }

    /**
     * 音频搜索也
     * @param title
     * @param page
     * @param pageSize
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "audioList/likeName")
    public String audioListByLikeName(@RequestParam("title") String title, @RequestParam(value="page", required=false, defaultValue="1") Integer page,
                                       @RequestParam(value="pageSize", required=false, defaultValue="12") Integer pageSize,
                                       ModelMap modelMap){
        //获取音频分类
        List<Category> categoryList=categoryService.findCategoryByTypeAndStatus(2,"1");
        //查询结果
        PageInfo<Audio> pageInfo =audioService.findAudioLikeAudioName(title,page,pageSize);
        modelMap.put("title",title);
        modelMap.put("pageInfo",pageInfo);
        modelMap.put("categoryList",categoryList);
        return "audioListBySearch";
    }

    /**
     * 音频播放页
     * @param audioId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "audio/{audioId}")
    public String audio(@PathVariable Integer audioId,ModelMap modelMap){
        Audio audio=audioService.findAudioById(audioId);
        modelMap.put("audio",audio);
        return "music";
    }

    /**
     * 全部音频信息
     * @return
     */
    @RequestMapping("findAllAudio")
    @ResponseBody
    public List<AudioForm> findAllAudio(){
         List<Audio> audioList =audioService.findAllAudio();
         List<AudioForm> audioFormList =new ArrayList<>();
         for(Audio audio:audioList){
             AudioForm audioForm =new AudioForm();
             audioForm.setId(audio.getId());
             audioForm.setAudioName(audio.getAudioName());
             audioForm.setAudioDescribe(audio.getAudioDescribe());
             audioForm.setCreateTime(audio.getCreateTime());
             audioForm.setPhoto(audio.getPhoto());
             audioForm.setStatus(audio.getStatus());
             audioForm.setUserName(audio.getUserName());
             audioForm.setCategory(categoryService.findCategoryById(audio.getCategoryId()).getCategoryName());
             audioFormList.add(audioForm);
         }
        return audioFormList;
    }

    @RequestMapping("adminUpdateAudio")
    @ResponseBody
    public boolean adminUpdateAudio(@RequestParam("id") Integer id,@RequestParam("status") String status){
        Audio audio =new Audio();
        audio.setId(id);
        audio.setStatus(status);
        return audioService.updateAudio(audio);
    }

    @RequestMapping("deleteAudio")
    @ResponseBody
    public boolean deleteAudio(@RequestParam("id") Integer id){
        return audioService.deleteAudio(id);
    }

}
