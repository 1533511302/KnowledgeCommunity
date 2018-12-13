package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.maniy.Form.AudioForm;
import top.maniy.entity.Audio;
import top.maniy.entity.Category;
import top.maniy.entity.User;
import top.maniy.service.AudioService;
import top.maniy.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "editAudioPage")
    public String toSaveAudio(){
        return "editAudioPage";
    }

    @RequestMapping(value = "saveAudio",method = RequestMethod.POST)
    @ResponseBody
    public boolean saveAudio(HttpServletRequest request,@RequestParam(required = false) MultipartFile photo,MultipartFile audio,Integer type,String audioName,
                            String audioDescribe){
        Audio audio1 =new Audio();
        User user = (User) request.getSession().getAttribute("User");
        audio1.setUserId(user.getId());
        audio1.setUserName(user.getRealname());
        audio1.setCategoryId(type);
        audio1.setAudioName(audioName);
        audio1.setAudioDescribe(audioDescribe);

        if(photo!=null){
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName=photo.getOriginalFilename();// 文件原名称
            //获取上传文件的目录
            String path=request.getSession().getServletContext().getRealPath("/");
            String newPath= null;
            try {
                newPath = path.substring(0,path.indexOf("KnowledgeCommunity"))+"images\\";
            } catch (Exception e) {
                e.printStackTrace();
                throw new MailSendException("图片路径不正确");
            }
            //获取图片后缀
            String ext= FilenameUtils.getExtension(fileName);
            //新图片
            File newfile =new File(newPath+ name+"."+ext);
            //把内存图片写入磁盘中
            try {
                photo.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            audio1.setPhoto(name+"."+ext);
        }else {
            audio1.setPhoto("191ea1c12d824851ade02cfcf0e61e31.jpg");
        }

        String name = UUID.randomUUID().toString().replaceAll("-", "");
        String fileName=audio.getOriginalFilename();// 文件原名称
        //获取上传文件的目录
        String path=request.getSession().getServletContext().getRealPath("/");
        String newPath= null;
        try {
            newPath = path.substring(0,path.indexOf("KnowledgeCommunity"))+"images\\";
        } catch (Exception e) {
            e.printStackTrace();
            throw new MailSendException("图片路径不正确");
        }
        //获取图片后缀
        String ext= FilenameUtils.getExtension(fileName);
        //新图片
        File newfile =new File(newPath+ name+"."+ext);
        //把内存图片写入磁盘中
        try {
            audio.transferTo(newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        audio1.setUrl(name+"."+ext);

        return audioService.saveAudio(audio1);
    }


    @RequestMapping(value = "updateAudio",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateAudio(HttpServletRequest request,@RequestParam(required = false) MultipartFile photo,
                               @RequestParam(required = false) MultipartFile audio,Integer type,String audioName,
                             String audioDescribe,Integer audioId){
        Audio audio1 =new Audio();
        audio1.setId(audioId);
        audio1.setCategoryId(type);
        audio1.setAudioName(audioName);
        audio1.setAudioDescribe(audioDescribe);

        if(photo!=null){
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName=photo.getOriginalFilename();// 文件原名称
            //获取上传文件的目录
            String path=request.getSession().getServletContext().getRealPath("/");
            String newPath= null;
            try {
                newPath = path.substring(0,path.indexOf("KnowledgeCommunity"))+"images\\";
            } catch (Exception e) {
                e.printStackTrace();
                throw new MailSendException("图片路径不正确");
            }
            //获取图片后缀
            String ext= FilenameUtils.getExtension(fileName);
            //新图片
            File newfile =new File(newPath+ name+"."+ext);
            //把内存图片写入磁盘中
            try {
                photo.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            audio1.setPhoto(name+"."+ext);
        }

        if(audio!=null) {
            String name = UUID.randomUUID().toString().replaceAll("-", "");
            String fileName = audio.getOriginalFilename();// 文件原名称
            //获取上传文件的目录
            String path = request.getSession().getServletContext().getRealPath("/");
            String newPath = null;
            try {
                newPath = path.substring(0, path.indexOf("KnowledgeCommunity")) + "images\\";
            } catch (Exception e) {
                e.printStackTrace();
                throw new MailSendException("图片路径不正确");
            }
            //获取图片后缀
            String ext = FilenameUtils.getExtension(fileName);
            //新图片
            File newfile = new File(newPath + name + "." + ext);
            //把内存图片写入磁盘中
            try {
                audio.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            audio1.setUrl(name + "." + ext);
        }
        return audioService.updateAudio(audio1);
    }

    @RequestMapping("toUpdateAudio")
    public String toUpdateAudio(@RequestParam Integer audioId,ModelMap modelMap){
        List<Category> categoryList =categoryService.findCategoryByTypeAndStatus(2,"1");
        Audio audio =audioService.findAudioById(audioId);
        modelMap.put("audio",audio);
        modelMap.put("categoryList",categoryList);
        return "updateAudioPage";
    }

    @RequestMapping("deleteAudio")
    @ResponseBody
    public boolean deleteAudio(@RequestParam Integer id){
        return audioService.deleteAudio(id);
    }


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


}
