package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.NoteService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class NoteController {

    @Reference(version = "1.0.0")
    NoteService noteService;

    @RequestMapping("/note")
    public ModelAndView getNodes(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/note/note.html");
        return mv;
    }
    @RequestMapping("/notemenu")
    public List<Map<String, Object>> getnode1(){
        List data=noteService.getNote();
        return data;
    }
//    收一个参数查询一条笔记，然后返回页面
    @RequestMapping(path = "/note/{id}")
    public ModelAndView getNoteContent(@PathVariable String id){
        ModelAndView mv= new ModelAndView();
        Map note=noteService.queryByNameNote(id);
        mv.addObject("note",note);
        mv.setViewName("/note/note.html");
        return mv;
    }
    @RequestMapping("/addnote")
    public ModelAndView addnote(@RequestParam Map map){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/note/note.html");
        noteService.addNote(map);
        mv.addObject("error","success");
        return mv;
    }
    @RequestMapping("/updatenote")
    public ModelAndView UpdateNote(@RequestParam Map map){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/note/note.html");
        noteService.editNoteContent(map);
        return mv;
    }
    @RequestMapping("/queryallnotename")
    public List getAllClassifications(){
        List<Map<String,Object>> notename= noteService.getNote2();
        return notename;
    }
    @RequestMapping("/delnote")
    public void delNote(@RequestParam Map map){
        noteService.delNote(map);
    }
    @RequestMapping("/editname")
    public void editNote(@RequestParam Map map){
        noteService.editName(map);
    }
}
