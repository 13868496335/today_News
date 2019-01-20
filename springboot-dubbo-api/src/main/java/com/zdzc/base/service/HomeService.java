package com.zdzc.base.service;

import com.zdzc.base.model.Article;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface HomeService {

    public List<Map<String,Object>> getHomeNode();

    public int getArticleCount();

    public List<Map<String,Object>> getArticle( int offset, int limit);

    public List<Article> getArticleClick( int offset,int limit);

    public List<Map<String,Object>> getTplb(String t_classification_code);

    public List<Map<String,Object>> getTjgl(String t_classification_code);

    Map selectById(int t_article_id);
}
