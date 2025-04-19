package com.rcamis.smis.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYear academicYear;

    public Term () {}
    public Term (String name, Date startDate, Date endDate, AcademicYear academicYear) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.academicYear = academicYear;
    }

    public void setName (String name) { this.name = name; }
    public void setStartDate (Date date) { this.startDate = date; }
    public void setEndDate (Date date) { this.endDate = date; }
    public void setAcademicYear (AcademicYear academicYear) { this.academicYear = academicYear; }

    public String getName () { return this.name; }
    public Date getStartDate () { return this.startDate; }
    public Date getEndDate () { return this.endDate; }
    public AcademicYear getAcademicYear () { return this.academicYear; }
}
