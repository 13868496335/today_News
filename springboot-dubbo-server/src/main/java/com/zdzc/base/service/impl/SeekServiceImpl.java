package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.SeekMapper;
import com.zdzc.base.service.SeekService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class SeekServiceImpl implements SeekService {

    @Autowired
    SeekMapper seekMapper;
    @Override
    public List<Map<String, Object>> getIndexSeek(String t_article_title_1) {
        return seekMapper.getIndexSeek(t_article_title_1);
    }

    @Override
    public List<Map<String, Object>> getArticle(String keyword) {
        return seekMapper.getArticle(keyword);
    }

    @Override
    public List<Map<String, Object>> getReceNodeArticle(String name) {
        return seekMapper.getReceNodeArticle(name);
    }
}
