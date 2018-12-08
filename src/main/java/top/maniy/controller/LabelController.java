package top.maniy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.maniy.Form.CountForm;
import top.maniy.entity.Label;
import top.maniy.service.LabelService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzonghua
 * @Package top.maniy.controller
 * @Description:
 * @date 2018/12/8 15:31
 */
@Controller
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 前六热点的图文标签
     * @return
     */
    @RequestMapping("count/labelByMassage")
    @ResponseBody
    public List<CountForm> countLabelByMassage(){
        List<CountForm> countFormList =new ArrayList<>();
        List<Label> labelList =labelService.findMassageLabelByHot(6);
        for(Label label:labelList){
            CountForm countForm = new CountForm();
            countForm.setLabel(label.getMassageLabel());
            countForm.setValue(label.getMassageLabelHot());
            countFormList.add(countForm);
        }
        return countFormList;
    }

    /**
     * 前六热点的问题标签
     * @return
     */
    @RequestMapping("count/labelByQuestion")
    @ResponseBody
    public List<CountForm> countLabelByQuestion(){
        List<CountForm> countFormList =new ArrayList<>();
        List<Label> labelList =labelService.findQuestionLabelByHot(6);
        for(Label label:labelList){
            CountForm countForm =new CountForm();
            countForm.setLabel(label.getQuestionLabel());
            countForm.setValue(label.getQuestionLabelHot());
            countFormList.add(countForm);
        }
        return countFormList;
    }
}
