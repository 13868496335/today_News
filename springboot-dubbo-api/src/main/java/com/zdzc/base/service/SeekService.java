package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */

public interface SeekService {

    public List<Map<String,Object>> getIndexSeek(String t_article_title_1);

    public List<Map<String,Object>> getArticle(String keyword);

    public List<Map<String,Object>> getReceNodeArticle(String name);
}
