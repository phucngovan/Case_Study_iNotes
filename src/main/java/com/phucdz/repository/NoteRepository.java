package com.phucdz.repository;

import com.phucdz.model.Note;
import com.phucdz.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Note,Integer> {
    Iterable<Note> findAllByNoteType(NoteType noteType);

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
}
