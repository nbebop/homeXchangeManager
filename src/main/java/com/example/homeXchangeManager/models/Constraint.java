package com.example.homeXchangeManager.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "constraints")
public class Constraint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int constraintId;

    @NotNull
    @NotEmpty
    private String constraintName;

    @NotNull
    @NotEmpty
    private String constraintText;

    @NotNull
    @NotEmpty
    private String constraintDescription;

    // Default constructor
    public Constraint() {}

    // Constructor with parameters
    public Constraint(String constraintName, String constraintText, String constraintDescription) {
        this.constraintName = constraintName;
        this.constraintText = constraintText;
        this.constraintDescription = constraintDescription;
    }

    // Getters and Setters
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

    public String getConstraintText() {
        return constraintText;
    }

    public void setConstraintText(String constraintText) {
        this.constraintText = constraintText;
    }

    public String getConstraintDescription() {
        return constraintDescription;
    }

    public void setConstraintDescription(String constraintDescription) {
        this.constraintDescription = constraintDescription;
    }
}
