package com.phucdz.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "noteTypes")
public class NoteType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    @OneToMany(targetEntity = Note.class)
    private Set<Note> notes;

    public NoteType() {
    }

    public NoteType( String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
