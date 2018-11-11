package com.phucdz.controller;

import com.phucdz.model.Note;
import com.phucdz.service.NoteService;
import com.phucdz.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    private NoteTypeService noteTypeService;
    @Autowired
    private NoteService noteService;
    @ModelAttribute("noteTypes")
    @GetMapping("/notes")
    public ModelAndView listNotes(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Note> notes;
        if(s.isPresent()){
            notes = noteService.findAllByTitleContaining(s.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
    @GetMapping("/create-note")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }
    @PostMapping("/create-note")
    public ModelAndView saveNote(@ModelAttribute("note") Note note  ) {
        noteService.save(note);
      ModelAndView modelAndView=new ModelAndView("/note/create");
      modelAndView.addObject("note",new Note());
      modelAndView.addObject("message","New note created successfully");
      return modelAndView;

    }
    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id){
       Note note=noteService.findById(id);
        if(note != null) {
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note", note);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-note")
    public ModelAndView updateNote(@ModelAttribute("note") Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/edit");
        modelAndView.addObject("note", note);
        modelAndView.addObject("message", "Note updated successfully");
        return modelAndView;
    }


}
