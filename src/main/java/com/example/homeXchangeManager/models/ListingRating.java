package com.example.homeXchangeManager.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "listing_rating")
public class ListingRating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId")
    private int ratingId;

    @ManyToOne
    @JoinColumn(name = "reviewerId", referencedColumnName = "id")
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "listings", referencedColumnName = "listing_id")
    private Listing listing;
    private int score;
    private String description;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YYYY")
    @Column
    private Date reviewDate;

    public ListingRating() {
    }

    public ListingRating(User reviewer, Listing listing, int score, String description, Date reviewDate) {
        this.reviewer = reviewer;
        this.listing = listing;
        this.score = score;
        this.description = description;
        this.reviewDate = reviewDate;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int ratingScore) {
        this.score = ratingScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String reviewComments) {
        this.description = reviewComments;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
}
