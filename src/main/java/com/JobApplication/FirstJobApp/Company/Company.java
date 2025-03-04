package com.JobApplication.FirstJobApp.Company;

import com.JobApplication.FirstJobApp.Job.JobVar;
import com.JobApplication.FirstJobApp.Review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<JobVar> jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> review;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<JobVar> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobVar> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
