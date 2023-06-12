package com.example.homeXchangeManager.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "constraints")
public class Constraint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constraint_id")
    private int constraintId;

    @NotNull
    @NotEmpty
    private String constraintName;

    @NotNull
    @NotEmpty
    private String constraintDescription;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "constraints")
    private List<Listing> listings;

    public Constraint() {
    }

    public Constraint(int constraintId, String constraintName, String constraintDescription) {
        this.constraintId = constraintId;
        this.constraintName = constraintName;
        this.constraintDescription = constraintDescription;
    }

    public int getConstraintId() {
        return constraintId;
    }

    public void setConstraintId(int constraintId) {
        this.constraintId = constraintId;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

    public String getConstraintDescription() {
        return constraintDescription;
    }

    public void setConstraintDescription(String constraintDescription) {
        this.constraintDescription = constraintDescription;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }
}
