package com.amar.jobMicroservices.job;

import com.amar.jobMicroservices.job.dto.JobWithDTO;

import java.util.List;

public interface JobService {

    List<JobWithDTO> findAll();

    void createJob(Job job);

    JobWithDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJob);
}
