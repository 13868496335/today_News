package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.HomeMapper;
import com.zdzc.base.model.Article;
import com.zdzc.base.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeMapper homeMapper;

    @Override
    public List<Map<String, Object>> getHomeNode() {
        return homeMapper.getHomeNode();
    }

    @Override
    public int getArticleCount() {
        return homeMapper.getArticleCount();
    }

    @Override
    public List<Map<String, Object>> getArticle(int offset, int limit) {
        return homeMapper.getArticle(offset, limit);
    }

    @Override
    public List<Article> getArticleClick(int offset, int limit) {
        return homeMapper.getArticleClick(offset, limit);
    }

    @Override
    public List<Map<String, Object>> getTplb(String t_classification_code) {
        return homeMapper.getTplb(t_classification_code);
    }

    @Override
    public List<Map<String, Object>> getTjgl(String t_classification_code) {
        return homeMapper.getTjgl(t_classification_code);
    }

    @Override
    public Map selectById(int t_article_id) {
        return homeMapper.selectById(t_article_id);
    }

}
