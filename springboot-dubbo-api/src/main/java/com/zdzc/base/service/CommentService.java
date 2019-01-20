package com.zdzc.base.service;


import com.zdzc.base.model.Comment;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface CommentService {

     void insertComment(Map map);

     void insertComment2(Map map);


    List<Map<String,Object>> getAllComment2(int t_article_id);

     List<Map<String,Object>> getAllComment(int t_article_id);

    List<Map<String, Object>>  countAllComment2();

     List<Map<String, Object>> countAllComment();

    int UserComCount(String t_id);

     List<Map<String, Object>> UserComArticleXQ(String t_id);

     Comment seletById(int id);

     List<Comment> selectLatestComments(int offset, int limit);

     List<Comment> selectCommentsByArticleId(int t_article_id);

     int getCommentCountByArticleId(int t_article_id);


    void deleteById(int id);

    public List<Map<String, Object>> getUserComment(String id);

}
