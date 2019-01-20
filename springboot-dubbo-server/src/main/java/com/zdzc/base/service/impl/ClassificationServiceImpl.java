package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.ClassificationMapper;
import com.zdzc.base.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */

@Service(version = "1.0.0")
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    ClassificationMapper classificationMapper;

    @Override
    public List<Map<String, Object>> getAllClassifications() {
        return classificationMapper.getAllClassifications();
    }

    @Override
    public void deleteClassificationById(String t_classification_id) {
        classificationMapper.deleteClassificationById(t_classification_id);
    }

    @Override
    public void insertClassification(String t_classification_name, String t_classification_code) {
        classificationMapper.insertClassification(t_classification_name,t_classification_code);
    }

    @Override
    public List<Map<String, Object>> queryClassificationById(String t_classification_id) {
        return classificationMapper.queryClassificationById(t_classification_id);
    }

    @Override
    public void editClassification(String t_classification_name, String t_classification_code, String t_classification_id) {
        classificationMapper.editClassification(t_classification_name,t_classification_code,t_classification_id);
    }
}
