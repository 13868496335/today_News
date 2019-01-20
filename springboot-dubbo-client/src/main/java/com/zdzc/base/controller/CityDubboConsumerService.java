package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.domain.City;
import com.zdzc.base.service.ArticleService;
import com.zdzc.base.service.CityDubboService;
import com.zdzc.base.service.UserService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    @Reference(version = "1.0.0")
    ArticleService articleService;

    @Reference(version = "1.0.0")
    UserService userService;

    public void printCity() throws IOException {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());

        List<Map<String, Object>> maps =  articleService.getUserAllArticles("a");



    }
}
