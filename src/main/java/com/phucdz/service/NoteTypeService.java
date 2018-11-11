package com.phucdz.service;

import com.phucdz.model.NoteType;

public interface NoteTypeService {
    Iterable<NoteType> findAll();

    NoteType findById(int id);

    void save(NoteType noteType);

    void remove(int id);
}
