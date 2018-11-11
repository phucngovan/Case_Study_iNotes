package com.phucdz.controller;

import com.phucdz.model.NoteType;
import com.phucdz.service.NoteService;
import com.phucdz.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @Autowired
    private NoteService noteService;

    @GetMapping("/noteTypes")
    public ModelAndView listProvinces(){
        Iterable<NoteType> noteTypes = noteTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/noteType/list");
        modelAndView.addObject("noteTypes", noteTypes);
        return modelAndView;
    }

    @GetMapping("/create-noteType")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/noteType/create");
        modelAndView.addObject("noteType", new NoteType());
        return modelAndView;
    }

    @PostMapping("/create-noteType")
    public ModelAndView saveProvince(@ModelAttribute("noteType") NoteType noteType){
        noteTypeService.save(noteType);

        ModelAndView modelAndView = new ModelAndView("/noteType/create");
        modelAndView.addObject("noteType", new NoteType());
        modelAndView.addObject("message", "New noteType created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-noteType/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
        NoteType noteType = noteTypeService.findById(id);
        if(noteType != null) {
            ModelAndView modelAndView = new ModelAndView("/noteType/edit");
            modelAndView.addObject("noteType", noteType);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-noteType")
    public ModelAndView updateNoteType(@ModelAttribute("noteType") NoteType noteType){
        noteTypeService.save(noteType);
        ModelAndView modelAndView = new ModelAndView("/noteType/edit");
        modelAndView.addObject("noteType", noteType);
        modelAndView.addObject("message", "NoteType updated successfully");
        return modelAndView;
    }
}
