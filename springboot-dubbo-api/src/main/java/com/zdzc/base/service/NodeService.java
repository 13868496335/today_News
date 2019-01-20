package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface NodeService {
    public List<Map<String,Object>> getAllNodes();

    public List<Map<String,Object>> getSelectNodes();

    public boolean deleteNodeById(String t_node_id);

    public void editNode(String t_node_name,
                         String t_node_url,
                         String t_node_level,
                         String t_node_parent_id,
                         String t_node_id);

    public void insertNode(String t_node_name,
                           String t_node_url,
                           String t_node_level,
                           String t_node_parent_id);

    public List<Map<String,Object>> queryNodeById(String t_node_id);
}
