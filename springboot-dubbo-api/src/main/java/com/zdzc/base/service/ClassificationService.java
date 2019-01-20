package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface ClassificationService {


    public List<Map<String,Object>> getAllClassifications();

    public void deleteClassificationById(String t_classification_id);

    public void insertClassification(
            String t_classification_name,
            String t_classification_code
    );

    public List<Map<String,Object>> queryClassificationById(String t_classification_id);

    public  void editClassification(
            String t_classification_name,
            String t_classification_code,
            String t_classification_id
    );
}
