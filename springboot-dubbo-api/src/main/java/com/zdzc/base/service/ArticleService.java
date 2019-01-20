package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface ArticleService {

    public List<Map<String, Object>> getUserAllArticles(String t_user_account);
    public List<Map<String, Object>> getAllArticles();

    public boolean deleteById(String t_article_id);
    public void editArticle(Map map);
    public void insertArticle(String t_article_title_1,
                              String t_article_title_2,
                              String t_article_title_3,
                              String t_article_source,
                              String t_article_author,
                              String t_article_create_date,
                              String t_article_img1,
                              String t_article_img2,
                              String t_article_img3,
                              String t_article_img4,
                              String t_article_img5,
                              String t_article_document,
                              String t_article_classification,
                              String t_user_account);
    public void xwinsertArticle(String t_article_title_1,
                                String t_article_title_2,
                                String t_article_title_3,
                                String t_article_source,
                                String t_article_author,
                                String t_article_create_date,
                                String t_article_img1,
                                String t_article_img2,
                                String t_article_img3,
                                String t_article_img4,
                                String t_article_img5,
                                String t_article_document,
                                String t_article_classification,
                                String t_classification_code);

    public List<Map<String, Object>> queryArticleById(String t_article_id);
    public Map queryIntArticleById(int t_article_id);
}
