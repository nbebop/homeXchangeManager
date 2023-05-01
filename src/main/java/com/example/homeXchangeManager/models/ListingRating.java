package com.example.homeXchangeManager.models;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ListingRating")
public class ListingRating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId")
    private int ratingId;

    @ManyToOne
    @JoinColumn(name = "reviewerId", referencedColumnName = "id")
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "reviewedId", referencedColumnName = "listingId")
    private Listing listing;

    @Column(name = "ratingScore")
    private int ratingScore;

    @Column(name = "reviewComments")
    private String reviewComments;

    public ListingRating() {}

    public ListingRating(User reviewer, Listing listing, int ratingScore, String reviewComments) {
        this.reviewer = reviewer;
        this.listing = listing;
        this.ratingScore = ratingScore;
        this.reviewComments = reviewComments;
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

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }
}
