package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.MbdealService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class MbdealController {

    @Reference(version = "1.0.0")
    MbdealService mbdealService;

    @RequestMapping("/mbdeal")
    public ModelAndView getmbdeal() {
        ModelAndView mv = new ModelAndView();
        List list=mbdealService.getUserMbDeal();
        mv.addObject("alldeal",list);
        mv.setViewName("/app/mbdeal.html");
        return mv;
    }
    @RequestMapping("/mbhome")
    public ModelAndView getmbdealhome() {
        ModelAndView mv = new ModelAndView();
        List list=mbdealService.getMbDeal();
        mv.addObject("alldeal",list);
        mv.setViewName("/app/mbdealhome.html");
        return mv;
    }
    @RequestMapping("/addmoney")
    public ModelAndView addmoeny(@RequestParam Map map){
        ModelAndView mv = new ModelAndView();
        mbdealService.addmoney(map);
        mv.setViewName("/app/mbdealhome.html");
        return mv;
    }
}
