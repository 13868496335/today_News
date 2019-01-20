package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.mapper.NoteMapper;
import com.zdzc.base.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
@Service(version = "1.0.0")
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteMapper noteMapper;
    @Override
    public List<Map<String, Object>> getNote() {
        return noteMapper.getNote();
    }

    @Override
    public List<Map<String, Object>> getNote2() {
        return noteMapper.getNote2();
    }

    @Override
    public Map queryByNameNote(String id) {
        return noteMapper.queryByNameNote(id);
    }

    @Override
    public void addNote(Map map) {
        noteMapper.addNote(map);
    }

    @Override
    public void delNote(Map map) {

    }

    @Override
    public void editName(Map map) {
        noteMapper.editName(map);
    }

    @Override
    public void editNoteContent(Map map) {
        noteMapper.editNoteContent(map);
    }
}
