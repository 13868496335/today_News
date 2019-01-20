package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.ArticleMapper;
import com.zdzc.base.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class ArticleServiceImpl  implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public List<Map<String, Object>> getUserAllArticles(String t_user_account) {
        return articleMapper.getUserAllArticles(t_user_account);
    }

    public List<Map<String, Object>> getAllArticles() {
        return articleMapper.getAllArticles();
    }

    public boolean deleteById(String t_article_id) {
         return articleMapper.deleteById(t_article_id);
    }

    public void editArticle(Map map) {
        articleMapper.editArticle(map);
    }

    public void insertArticle(String t_article_title_1, String t_article_title_2, String t_article_title_3, String t_article_source, String t_article_author, String t_article_create_date, String t_article_img1, String t_article_img2, String t_article_img3, String t_article_img4, String t_article_img5, String t_article_document, String t_article_classification, String t_user_account) {
        articleMapper.insertArticle(
                t_article_title_1,
                t_article_title_2,
                t_article_title_3,
                t_article_source,
                t_article_author,
                t_article_create_date,
                t_article_img1,
                t_article_img2,
                t_article_img3,
                t_article_img4,
                t_article_img5,
                t_article_document,
                t_article_classification,
                t_user_account);

        }

    public void xwinsertArticle(String t_article_title_1, String t_article_title_2, String t_article_title_3, String t_article_source, String t_article_author, String t_article_create_date, String t_article_img1, String t_article_img2, String t_article_img3, String t_article_img4, String t_article_img5, String t_article_document, String t_article_classification, String t_classification_code) {
        articleMapper.xwinsertArticle(
                t_article_title_1,
                t_article_title_2,
                t_article_title_3,
                t_article_source,
                t_article_author,
                t_article_create_date,
                t_article_img1,
                t_article_img2,
                t_article_img3,
                t_article_img4,
                t_article_img5,
                t_article_document,
                t_article_classification,
                t_classification_code);

        }

    public List<Map<String, Object>> queryArticleById(String t_article_id) {
        return articleMapper.queryArticleById(t_article_id);
    }

    public Map queryIntArticleById(int t_article_id) {
        return articleMapper.queryIntArticleById(t_article_id);
    }
}
