package com.rcamis.smis.model;

import com.rcamis.smis.enums.ProjectStatus;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private ProjectStatus status;
    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "finished_at")
    private Date finishedAt;

    public Project () {}
    public Project (String name, String description, ProjectStatus status, String image, User user, Date createAt, Date finishedAt) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.status = status;
        this.user = user;
        this.createAt = createAt;
        this.finishedAt = finishedAt;
    }

    public void setName (String name) { this.name = name; }
    public void setDescription (String description) { this.description = description; }
    public void setStatus (ProjectStatus status) { this.status = status; }
    public void setImage (String image) { this.image = image; }
    public void setUser (User user) { this.user = user; }
    public void setCreateAt (Date date) { this.createAt = date; }
    public void setFinishedAt (Date date) { this.finishedAt = date; }

    public String getName () { return this.name; }
    public String getDescription () { return this.description; }
    public ProjectStatus getStatus () { return this.status; }
    public String getImage () { return this.image; }
    public User getUser () { return this.user; }
    public Date getCreateAt () { return this.createAt; }
    public Date getFinishedAt () { return this.finishedAt; }
}
