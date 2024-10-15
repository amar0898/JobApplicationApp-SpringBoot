package com.amar.jobMicroservices.job.dto;

import com.amar.jobMicroservices.job.Job;
import com.amar.jobMicroservices.job.external.Company;

public class JobWithCompanyDTO {

    private Job job;
    private Company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
