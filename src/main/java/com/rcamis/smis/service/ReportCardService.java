package com.rcamis.smis.service;

import com.rcamis.smis.dto.ReportCardDto;
import com.rcamis.smis.exception.NotFoundException;
import com.rcamis.smis.model.ReportCard;
import com.rcamis.smis.repository.ReportCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ReportCardService {
    private final ReportCardRepository reportCardRepository;
    private final FileService fileService;

    public ReportCardService (ReportCardRepository reportCardRepository, FileService fileService) {
        this.reportCardRepository = reportCardRepository;
        this.fileService = fileService;
    }

    public ReportCard createReportCard (ReportCardDto reportCardDto, MultipartFile reportFile) {

    }

    public List<ReportCard> getReportCards () {
        return this.reportCardRepository.findAll();
    }

    public ReportCard getReportCard (int id) {
        return this.reportCardRepository.getReportCardById(id).orElseThrow(() -> new NotFoundException("Report not found!! 💔💔"));
    }
}
