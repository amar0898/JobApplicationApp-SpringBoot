package com.amar.jobMicroservices.job.clients;

import com.amar.jobMicroservices.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANYMICROSERVICES", url = "${company-service.url}")
public interface CompanyClient {

    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable("id") Long Id);
}
