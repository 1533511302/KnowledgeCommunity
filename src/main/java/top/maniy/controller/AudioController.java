package top.maniy.controller;

import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.maniy.Form.AudioForm;
import top.maniy.entity.Audio;
import top.maniy.entity.Category;
import top.maniy.entity.Massage;
import top.maniy.entity.User;
import top.maniy.service.AudioService;
import top.maniy.service.CategoryService;
import top.maniy.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "editAudioPage")
    @RequiresPermissions("audio:insert")
    public String toSaveAudio(){
        return "editAudioPage";
    }

    @RequestMapping(value = "saveAudio",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("audio:insert")
    public boolean saveAudio(HttpServletRequest request,@RequestParam(required = false) MultipartFile photo,MultipartFile audio,Integer type,String audioName,
                            String audioDescribe){
        Audio audio1 =new Audio();
        User user = (User) request.getSession().getAttribute("User");

        //用户音频数加一
        User user1=userService.findUserById(user.getId());
        user1.setAudionumb(user1.getAudionumb()+1);
        userService.updateUser(user1);


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
    @RequiresPermissions("audio:update")
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
    @RequiresPermissions("audio:update")
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
        List<User> userList =userService.findUserByAudioNumDesc(6);

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
        modelMap.put("userList",userList);
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
     * 音频播放页
     * @param userId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "audioPage/{userId}")
    public String audioPage(@PathVariable Integer userId,ModelMap modelMap){
        List<Audio> audioList=audioService.findAudioByUserId(userId);
        modelMap.put("audioList",audioList);
        return "musicPage";
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
    @RequiresPermissions("all:all")
    public boolean adminUpdateAudio(@RequestParam("id") Integer id,@RequestParam("status") String status){
        Audio audio =new Audio();
        audio.setId(id);
        audio.setStatus(status);
        return audioService.updateAudio(audio);
    }

    @RequestMapping(value = "admin/audioExcel")
    @ResponseBody
    @RequiresPermissions("all:all")
    public String getExcel(HttpServletResponse response)  throws IOException{
        List<Audio> audioList =audioService.findAllAudio();

//创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();

//创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("音频表");

//创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);
//创建HSSFCell对象
        HSSFCell cell=row.createCell(0);
////设置单元格的值
        cell.setCellValue("音频信息表");
////合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));

        //在sheet里创建第i行
        HSSFRow row1=sheet.createRow(1);


        //创建单元格并设置单元格内容
        row1.createCell(0).setCellValue("编号");
        row1.createCell(1).setCellValue("标题");
        row1.createCell(2).setCellValue("分类");
        row1.createCell(3).setCellValue("作者");
        row1.createCell(4).setCellValue("描述");
        row1.createCell(5).setCellValue("音频文件名");
        row1.createCell(6).setCellValue("创建时间");

        int i=2;
        for (Audio audio:audioList){

            //在sheet里创建第i行
            HSSFRow irow=sheet.createRow(i);

            //创建单元格并设置单元格内容
            irow.createCell(0).setCellValue(audio.getId());
            irow.createCell(1).setCellValue(audio.getAudioName());
            irow.createCell(2).setCellValue(audio.getCategoryId());
            irow.createCell(3).setCellValue(audio.getUserName());
            irow.createCell(4).setCellValue(audio.getAudioDescribe());
            irow.createCell(5).setCellValue(audio.getUrl());
            irow.createCell(6).setCellValue(audio.getCreateTime());

            i++;
        }
//输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=audio.xls");
        response.setContentType("application/msexcel");

        //FileOutputStream output=new FileOutputStream("d:\\workbook.xls");

        wb.write(output);

        output.close();
        return null;
    }

}
