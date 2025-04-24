package com.rcamis.smis.controller;

import com.rcamis.smis.dto.ReportCardDto;
import com.rcamis.smis.model.ReportCard;
import com.rcamis.smis.service.ReportCardService;
import com.rcamis.smis.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/rcamis/v1/report-card")
public class ReportCardController {
    private final ReportCardService reportCardService;

    public ReportCardController (ReportCardService reportCardService) {
        this.reportCardService = reportCardService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ReportCard>>> getAllReportCards () {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained report cards!!! 🎉🎉🎉", this.reportCardService.getReportCards()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReportCard>> getReportCardById (@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained report card!!! 🎉🎉🎉", this.reportCardService.getReportCardById(id)));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<ApiResponse<ReportCard>> getReportCardByStudentId (@PathVariable int id) {
        ReportCard reportCard = this.reportCardService.getReportCardByStudentId(id);
        if (reportCard != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained student report card!!! 🎉🎉🎉", reportCard));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Failed to obtain report student!!! 💔💔💔", null));
        }
    }

    @GetMapping("/term/{termId}")
    public ResponseEntity<ApiResponse<ReportCard>> getReportCardByTermId (@PathVariable int termId) {
        ReportCard reportCard = this.reportCardService.getReportCardByTermId(termId);
        if (reportCard != null) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained report card!!! 🎉🎉🎉", reportCard));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(false, "Failed to obtain report card!!!", null));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ReportCard>> generateReportCard (@RequestPart("reportCardDto") ReportCardDto reportCardDto, @RequestPart("reportFile") MultipartFile reportFile) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created report card!!! 🎉🎉🎉", this.reportCardService.createReportCard(reportCardDto, reportFile)));
    }
}
