package com.amar.jobMicroservices.job;

import com.amar.jobMicroservices.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {

    List<JobWithCompanyDTO> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);
}