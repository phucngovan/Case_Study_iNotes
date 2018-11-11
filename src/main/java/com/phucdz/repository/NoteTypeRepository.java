package com.phucdz.repository;

import com.phucdz.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteTypeRepository extends PagingAndSortingRepository<NoteType,Integer> {
}
