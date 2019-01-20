package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface ReceNodeService {

    public List<Map<String,Object>> getAllReceNodes();

    public List<Map<String,Object>> getFirstNode();

     public List<Map<String,Object>> getFirstNode2();

    public boolean deleteReceNodeById(String t_rece_node_id);

     public void editReceNode(Map map);

    public void insertReceNode(Map map);

    public List<Map<String,Object>> queryReceNodeById(String t_t_rece_node_id);
}
