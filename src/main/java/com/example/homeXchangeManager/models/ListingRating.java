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
    @JoinColumn(name = "listingId", referencedColumnName = "listingId")
    private Listing listing;

    @Column(name = "ratingScore")
    private int score;

    @Column(name = "description")
    private String description;

    public ListingRating() {}

    public ListingRating(User reviewer, Listing listing, int score, String description) {
        this.reviewer = reviewer;
        this.listing = listing;
        this.score = score;
        this.description = description;
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
}
