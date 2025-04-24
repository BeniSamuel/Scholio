package com.rcamis.smis.service;

import com.rcamis.smis.dto.ReportCardDto;
import com.rcamis.smis.model.Term;
import com.rcamis.smis.model.User;
import com.rcamis.smis.enums.ReportStatus;
import com.rcamis.smis.exception.NotFoundException;
import com.rcamis.smis.model.ReportCard;
import com.rcamis.smis.repository.ReportCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Date;

@Service
public class ReportCardService {
    private final ReportCardRepository reportCardRepository;
    private final FileService fileService;
    private final UserService userService;
    private final TermService termService;

    public ReportCardService (ReportCardRepository reportCardRepository, FileService fileService, UserService userService, TermService termService) {
        this.reportCardRepository = reportCardRepository;
        this.fileService = fileService;
        this.userService = userService;
        this.termService = termService;
    }

    public List<ReportCard> getReportCards () {
        return this.reportCardRepository.findAll();
    }

    public ReportCard getReportCardById (int id) {
        return this.reportCardRepository.getReportCardById(id).orElseThrow(() -> new NotFoundException("Report not found!! 💔💔"));
    }

    public ReportCard getReportCardByStudentId(int id) {
        User user = this.userService.getUserById(id);
        return this.reportCardRepository.getReportCardByUser(user).orElse(null);
    }

    public ReportCard getReportCardByTermId (int id) {
        Term term = this.termService.getTermById(id);
        return this.reportCardRepository.getReportCardByTerm(term).orElse(null);
    }

    public ReportCard createReportCard (ReportCardDto reportCardDto, MultipartFile reportFile) {
        try {
            String savedFilePath = fileService.uploadFile(reportFile);
            User user = userService.getUserById(reportCardDto.getStudentId());
            Term term = termService.getTermById(reportCardDto.getTermId());

            ReportCard reportCard = new ReportCard();
            reportCard.setUser(user);
            reportCard.setTerm(term);
            reportCard.setFile(savedFilePath);
            reportCard.setStatus(ReportStatus.RELEASED);
            reportCard.setCreatedAt(new Date());
            reportCard.setUpdatedAt(new Date());
            return reportCardRepository.save(reportCard);

        } catch (IOException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage());
        }
    }
}
