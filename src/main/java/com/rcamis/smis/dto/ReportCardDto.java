package com.rcamis.smis.dto;

public class ReportCardDto {
    private int studentId;
    private int termId;

    public ReportCardDto () {}

    public int getStudentId () { return this.studentId; }
    public int getTermId () { return this.termId; }

    public void setStudentId (int studentId) { this.studentId = studentId; }
    public void setTermId (int termId) { this.termId = termId; }
}
