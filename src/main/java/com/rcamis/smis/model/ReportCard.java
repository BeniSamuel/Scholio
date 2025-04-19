package com.rcamis.smis.model;

import com.rcamis.smis.enums.ReportStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "report_card")
public class ReportCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "term_id")
    private Term term;
    private ReportStatus status;
    private String file;
    private Date createdAt;
    private Date updatedAt;

    public ReportCard () {}
    public ReportCard (User user, Term term, ReportStatus status, String file, Date createdAt, Date updatedAt) {
        this.user = user;
        this.term = term;
        this.status = status;
        this.file = file;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setUser (User user) { this.user = user; }
    public void setTerm (Term term) { this.term = term; }
    public void setStatus (ReportStatus rStatus) { this.status = status; }
    public void setFile (String file) { this.file = file; }
    public void setCreatedAt (Date newDate) { this.createdAt = newDate; }
    public void setUpdatedAt (Date updateDate) { this.updatedAt = updateDate; }

    public User getUser () { return this.user; }
    public Term getTerm () { return this.term; }
    public ReportStatus getStatus () { return this.status; }
    public String getFile () { return this.file; }
    public Date getCreatedAt () { return this.createdAt; }
    public Date getUpdatedAt () { return this.updatedAt; }
}
