package com.rcamis.smis.service;

import com.rcamis.smis.dto.ReportCardDto;
import com.rcamis.smis.model.Term;
import com.rcamis.smis.model.User;
import com.rcamis.smis.enums.ReportStatus;
import com.rcamis.smis.exception.NotFoundException;
import com.rcamis.smis.model.ReportCard;
import com.rcamis.smis.repository.ReportCardRepository;
import com.rcamis.smis.repository.TermRepository;
import com.rcamis.smis.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.rcamis.smis.model.ReportCard;

import java.io.IOException;
import java.util.List;
import java.util.Date;

@Service
public class ReportCardService {
    private final ReportCardRepository reportCardRepository;
    private final FileService fileService;
    private final UserRepository userRepository;
    private final TermRepository termRepository;

    public ReportCardService (ReportCardRepository reportCardRepository, FileService fileService, UserRepository userRepository, TermRepository termRepository) {
        this.reportCardRepository = reportCardRepository;
        this.fileService = fileService;
        this.userRepository = userRepository;
        this.termRepository = termRepository;
    }

    // ReportCardService.java
    public ReportCard createReportCard(ReportCardDto reportCardDto, MultipartFile reportFile) {
        try {
            // 1. Upload the file
            String savedFilePath = fileService.uploadFile(reportFile);

            // 2. Fetch User and Term
            User user = userRepository.findById(reportCardDto.getStudentId())
                    .orElseThrow(() -> new NotFoundException("User not found! 💥"));
            Term term = termRepository.findById(reportCardDto.getTermId())
                    .orElseThrow(() -> new NotFoundException("Term not found! 💥"));

            // 3. Create ReportCard
            ReportCard reportCard = new ReportCard();
            reportCard.setUser(user);
            reportCard.setTerm(term);
            reportCard.setFile(savedFilePath);
            reportCard.setStatus(ReportStatus.RELEASED); // or any default status
            reportCard.setCreatedAt(new Date());
            reportCard.setUpdatedAt(new Date());

            return reportCardRepository.save(reportCard);

        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
    }


    public List<ReportCard> getReportCards () {
        return this.reportCardRepository.findAll();
    }

    public ReportCard getReportCard (int id) {
        return this.reportCardRepository.getReportCardById(id).orElseThrow(() -> new NotFoundException("Report not found!! 💔💔"));
    }
}
