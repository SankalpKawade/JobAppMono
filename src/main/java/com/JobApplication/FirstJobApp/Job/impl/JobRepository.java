package com.JobApplication.FirstJobApp.Job.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import com.JobApplication.FirstJobApp.Job.JobVar;
public interface JobRepository extends JpaRepository<JobVar, Long> {
}
