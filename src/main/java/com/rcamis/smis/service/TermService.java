package com.rcamis.smis.service;

import com.rcamis.smis.exception.NotFoundException;
import com.rcamis.smis.model.Term;
import com.rcamis.smis.repository.TermRepository;
import org.springframework.stereotype.Service;

@Service
public class TermService {
    private final TermRepository termRepository;

    public TermService (TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    public Term getTermById (int id) {
        return this.termRepository.getTermById(id).orElseThrow(() -> new NotFoundException("Term Not Found!!"));
    }
}
