package com.amar.jobMicroservices.job.Impl;


import com.amar.jobMicroservices.job.Job;
import com.amar.jobMicroservices.job.JobRepository;
import com.amar.jobMicroservices.job.JobService;
import com.amar.jobMicroservices.job.dto.JobWithDTO;
import com.amar.jobMicroservices.job.external.Company;
import com.amar.jobMicroservices.job.external.Review;
import com.amar.jobMicroservices.job.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    RestTemplate restTemplate;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobWithDTO> findAll() {
        List<Job> jobs = jobRepository.findAll();
        List<JobWithDTO> jobWithDTOS = new ArrayList<>();
        return jobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private JobWithDTO convertToDTO(Job job) {
            Company company = restTemplate.getForObject("http://COMPANYMICROSERVICES:8083/companies/" + job.getCompanyId(), Company.class);

            ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange(
                    "http://REVIEWMICROSERVICES:8084/reviews?companyId="+job.getCompanyId(),
                    HttpMethod.GET,null,
                    new ParameterizedTypeReference<List<Review>>() {});

            List<Review> reviews = reviewResponse.getBody();

            JobWithDTO jobWithDTO = JobMapper.mapToJobWithCompanyDTO(job,company,reviews);

            return jobWithDTO;
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public JobWithDTO getJobById(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        return convertToDTO(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepository.save(job);
                return true;
            }

        return false;
    }
}
