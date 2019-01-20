package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.redis.JedisService;
import com.zdzc.base.service.HomeService;
import com.zdzc.base.service.SeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@RestController
public class SeekController {
    @Reference(version = "1.0.0")
    SeekService seekService;
    @Reference(version = "1.0.0")
    HomeService homeService;
    @Autowired
    JedisService jedisService;
    @RequestMapping("/getindexseek")
    public List<Map<String,Object>> getIndexSeek(String t_article_title_1){
        List seek=seekService.getIndexSeek(t_article_title_1);
        return seek;
    }
    @RequestMapping("/clickseek")
    public ModelAndView clickSeek(String keyword){
        ModelAndView mv=new ModelAndView();
        List<Map<String,Object>> articles=seekService.getArticle(keyword);
        mv.addObject("article",articles);
        //SY_TJGL
        List list=homeService.getHomeNode();
        List SY_GGGL=homeService.getTjgl("SY_GGGL");
        mv.setViewName("/app/seek");
        mv.addObject("recenodes",list);
        mv.addObject("SY_GGGL",SY_GGGL);
        //hotArticle
        Map hotArticle = new HashMap();
        List<Map<String,Object>> hotArticles=new ArrayList<>();
        Set<String> set = jedisService.zrevrange("hotArticles",0,8);
        for (String str : set){
            int t_article_id = Integer.parseInt(str.split(":")[1]);
            hotArticle = homeService.selectById(t_article_id);
            hotArticles.add(hotArticle);
        }
        mv.addObject("hotArticles",hotArticles);
        //
        return mv;
    }

    @RequestMapping(path = "/seekrecenode/{name}")
    public ModelAndView getReceNodeArticle(@PathVariable String name){
        ModelAndView mv=new ModelAndView();
        List<Map<String,Object>> articles=seekService.getReceNodeArticle(name);
        mv.addObject("article",articles);
        //SY_TJGL
        List list=homeService.getHomeNode();
        List SY_GGGL=homeService.getTjgl("SY_GGGL");
        mv.setViewName("/app/seek");
        mv.addObject("recenodes",list);
        mv.addObject("SY_GGGL",SY_GGGL);
        //hotArticle
        Map hotArticle = new HashMap();
        List<Map<String,Object>> hotArticles=new ArrayList<>();
        Set<String> set = jedisService.zrevrange("hotArticles",0,8);
        for (String str : set){
            int t_article_id = Integer.parseInt(str.split(":")[1]);
            hotArticle = homeService.selectById(t_article_id);
            hotArticles.add(hotArticle);
        }
        mv.addObject("hotArticles",hotArticles);
        //
        return mv;
    }



}


