package com.amar.jobMicroservices.job.mapper;

import com.amar.jobMicroservices.job.Job;
import com.amar.jobMicroservices.job.dto.JobWithDTO;
import com.amar.jobMicroservices.job.external.Company;
import com.amar.jobMicroservices.job.external.Review;

import java.util.List;

public class JobMapper {

    public static JobWithDTO mapToJobWithCompanyDTO(Job job, Company company, List<Review> reviews) {
      JobWithDTO jobWithDTO = new JobWithDTO();
      jobWithDTO.setId(job.getId());
      jobWithDTO.setTitle(job.getTitle());
      jobWithDTO.setDescription(job.getDescription());
      jobWithDTO.setLocation(job.getLocation());
      jobWithDTO.setMinSalary(job.getMinSalary());
      jobWithDTO.setMaxSalary(job.getMaxSalary());
      jobWithDTO.setCompany(company);
      jobWithDTO.setReview(reviews);

      return jobWithDTO;
    }
}
