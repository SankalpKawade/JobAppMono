package com.JobApplication.FirstJobApp.Job.impl;

import com.JobApplication.FirstJobApp.Job.JobVar;
import com.JobApplication.FirstJobApp.Job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//consist of logic for our requests in controller
@Service
public class JobServiceImpl implements JobService {

    // public List<Job> jobs = new ArrayList<>();
    @Autowired
    JobRepository jobRepository; // bean which is managed by spring

    // this constructor help to autowire bean at runtime, so that we dont need to initialize JobRepository
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //Method to find all the jobs
    @Override
    public List<JobVar> findAll() {
        return jobRepository.findAll();
    }
//Method to create
    @Transactional
    @Override
    public void createJob(JobVar job) {
        jobRepository.save(job);
    }
//Method to get job by id
    @Override
    public JobVar getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
    }
//Method to delete
    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
//Method to update
    @Override
    public boolean updateJob(Long id, JobVar updatedJob) {
        Optional<JobVar> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()){
            JobVar job = jobOptional.get();

                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
        }
        return false;
    }
}