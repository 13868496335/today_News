package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.ClassificationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@RestController
public class ClassificationController {

    @Reference(version = "1.0.0")
    ClassificationService classificationService;

    @RequestMapping("/queryallclassfications")
    public List getAllClassifications(){

        //
        List<Map<String,Object>> classifications= classificationService.getAllClassifications();

        return classifications;
    }

    @RequestMapping("/classficationsmanagement")
    public ModelAndView getClassifications(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/app/classifications.html");//设定跳转路径
        //
        List<Map<String,Object>> classifications= classificationService.getAllClassifications();
        mv.addObject("allclassifications",classifications);
        return mv;
    }
    @RequestMapping("/deleteclassification")
    public ModelAndView deleteClassificationById(String t_classification_id){
        //做删除 数据库
        classificationService.deleteClassificationById(t_classification_id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/app/classifications.html");//设定跳转路径
        //
        List<Map<String,Object>> classifications= classificationService.getAllClassifications();
        mv.addObject("allclassifications",classifications);
        return mv;
    }
    @RequestMapping("/newclassification")
    public ModelAndView newClassification(){
        //做删除 数据库

        ModelAndView mv=new ModelAndView();
        mv.setViewName("/app/newclassification.html");//设定跳转路径
        //
        return mv;
    }
    @RequestMapping("/saveclassification")
    public ModelAndView saveClassification(String t_classification_name,
                                  String t_classification_code){
        //做插入 数据库
        classificationService.insertClassification(t_classification_name,t_classification_code);
        ModelAndView mv=new ModelAndView();
        List<Map<String,Object>> classifications= classificationService.getAllClassifications();
        mv.addObject("allclassifications",classifications);
        mv.setViewName("/app/classifications.html");//设定跳转路径
        //
        return mv;
    }
    @RequestMapping("/updateclassification")
    public ModelAndView saveClassification(String t_classification_id){
        //做插入 数据库
        List<Map<String,Object>> classifications= classificationService.queryClassificationById(t_classification_id);
        ModelAndView mv=new ModelAndView();

        mv.addObject("updateclassification",classifications.get(0));
        mv.setViewName("/app/updateclassification.html");//设定跳转路径
        //
        return mv;
    }
    @RequestMapping("/editclassification")
    public ModelAndView editClassification(String t_classification_id,
                                 String t_classification_name,
                                 String t_classification_code){
        //做update 数据库
        classificationService.editClassification(t_classification_name,t_classification_code,t_classification_id);
        ModelAndView mv=new ModelAndView();

        List<Map<String,Object>> classifications= classificationService.getAllClassifications();
        mv.addObject("allclassifications",classifications);
        mv.setViewName("/app/classifications.html");//设定跳转路径
        //
        return mv;
    }


}
