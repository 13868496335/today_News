package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.CommentMapper;
import com.zdzc.base.model.Comment;
import com.zdzc.base.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Override
    public void insertComment(Map map) {
        commentMapper.insertComment(map);
    }

    @Override
    public void insertComment2(Map map) {
        commentMapper.insertComment2(map);
    }

    @Override
    public List<Map<String, Object>> getAllComment2(int t_article_id) {
        return commentMapper.getAllComment2(t_article_id);
    }

    @Override
    public List<Map<String, Object>> getAllComment(int t_article_id) {
        return commentMapper.getAllComment( t_article_id);
    }

    @Override
    public List<Map<String, Object>> countAllComment2() {
        return commentMapper.countAllComment2();
    }

    @Override
    public List<Map<String, Object>> countAllComment() {
        return commentMapper.countAllComment();
    }

    @Override
    public int UserComCount(String t_id) {
        return commentMapper.UserComCount(t_id);
    }

    @Override
    public List<Map<String, Object>> UserComArticleXQ(String t_id) {
        return  commentMapper.UserComArticleXQ(t_id);
    }

    @Override
    public Comment seletById(int id) {
        return  commentMapper.seletById(id);
    }

    @Override
    public List<Comment> selectLatestComments(int offset, int limit) {
        return commentMapper.selectLatestComments(offset,limit);
    }

    @Override
    public List<Comment> selectCommentsByArticleId(int t_article_id) {
        return commentMapper.selectCommentsByArticleId(t_article_id);
    }

    @Override
    public int getCommentCountByArticleId(int t_article_id) {
        return commentMapper.getCommentCountByArticleId(t_article_id);
    }

    @Override
    public void deleteById(int id) {
        commentMapper.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> getUserComment(String id) {
        return  commentMapper.getUserComment(id);
    }
}
