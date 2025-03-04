package com.JobApplication.FirstJobApp.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Defines the API's for our application, user can access these
@RestController //help to return data in json or xml
@RequestMapping("/jobs") //Created base url for all methods
public class JobController {
    private JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobVar>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createJob (@RequestBody JobVar job){
        jobService.createJob(job);
        return new ResponseEntity<>( "Job added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobVar> getJobById(@PathVariable Long id) {
        JobVar job = jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody JobVar updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}
