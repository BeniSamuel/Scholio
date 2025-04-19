package com.rcamis.smis.repository;

import com.rcamis.smis.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TermRepository extends JpaRepository<Term, Integer> {
    Optional<Term> getTermByName (String name);
    Optional<Term> getTermById (int id);
}
