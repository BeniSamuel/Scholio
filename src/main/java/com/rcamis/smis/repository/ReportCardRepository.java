package com.rcamis.smis.repository;

import com.rcamis.smis.model.ReportCard;
import com.rcamis.smis.model.Term;
import com.rcamis.smis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportCardRepository extends JpaRepository<ReportCard, Integer> {
    Optional<ReportCard> getReportCardById (int id);
    Optional<ReportCard> getReportCardByUser (User user);
    Optional<ReportCard> getReportCardByTerm (Term term);
}
