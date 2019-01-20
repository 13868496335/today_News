package com.zdzc.base.service;

import java.util.List;
import java.util.Map;

/**
 * @Author by double.
 * @Date: 2019/1/17
 * @remarks:
 */
public interface NoteService {

    public List<Map<String,Object>> getNote();
    public List<Map<String,Object>> getNote2();
    public Map queryByNameNote(String id);
    public void addNote(Map map);
    public void delNote(Map map);
    public void editName(Map map);
    public void editNoteContent(Map map);

}
