package com.rcamis.smis.model;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private String shortDescription;
    private String longDescription;
    private String imageCover;
    private User writer;
    private int likes;
    private Date createdAt;

    public News () {}
    public News (String title, String sDescribe, String lDescribe, String imageCover, User writer, int likes, Date createdAt) {
        this.title = title;
        this.shortDescription = sDescribe;
        this.longDescription = lDescribe;
        this.imageCover = imageCover;
        this.writer = writer;
        this.likes = likes;
        this.createdAt = createdAt;
    }

    public void setTitle (String title) { this.title = title; }
    public void setShortDescription (String sDescribe) { this.shortDescription = sDescribe; }
    public void setLongDescription (String lDescribe) { this.longDescription = lDescribe; }
    public void setImageCover (String imageCover) { this.imageCover = imageCover; }
    public void setWriter (User writer) { this.writer = writer; }
    public void setLikes (int likes) { this.likes = likes; }
    public void setCreatedAt (Date createdAt) { this.createdAt = createdAt; }

    public String getTitle () { return this.title; }
    public String getShortDescription () { return this.shortDescription; }
    public String getLongDescription () { return this.longDescription; }
    public String getImageCover () { return this.imageCover; }
    public User getWriter () { return this.writer; }
    public int getLikes () { return this.likes; }
    public Date getCreatedAt () { return this.createdAt; }
}
