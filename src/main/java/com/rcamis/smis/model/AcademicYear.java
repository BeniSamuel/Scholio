package com.rcamis.smis.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "academic_year")
public class AcademicYear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(name = "start_year")
    private Date startYear;

    @Column(name = "end_year")
    private Date endYear;

    public AcademicYear () {}
    public AcademicYear (String name, Date startYear, Date endYear) {
        this.name = name;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public void setName (String name) { this.name = name; }
    public void setCreatedAt (Date startYear) { this.startYear = startYear; }
    public void setEndYear (Date endYear) { this.endYear = endYear; }

    public String getName () { return this.name; }
    public Date getStartYear () { return this.startYear; }
    public Date getEndYear () { return this.endYear; }
}
