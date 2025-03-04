package com.JobApplication.FirstJobApp.Job;

import java.util.List;
//Interface which consists methods for controller and services class
public interface JobService {
    List<JobVar> findAll();
    void createJob(JobVar job);

    JobVar getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, JobVar updatedJob);


}
