package com.phucdz.model;

import javax.persistence.*;
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int typeId;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "noteType_id")
    private NoteType noteType;

    public Note() {
    }

    public Note( String title,String content) {
        this.title = title;
        this.content=content;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
