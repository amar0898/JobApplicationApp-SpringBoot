package com.amar.companyMicroservices.company.impl;


import com.amar.companyMicroservices.company.Company;
import com.amar.companyMicroservices.company.CompanyRepository;
import com.amar.companyMicroservices.company.CompanyService;
import com.amar.companyMicroservices.company.clients.ReviewClient;
import com.amar.companyMicroservices.company.dto.ReviewMessage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private ReviewClient reviewClient;

    public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient) {
     this.companyRepository = companyRepository;
     this.reviewClient = reviewClient;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return true;
        }

        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
            Company company = getCompanyById(reviewMessage.getCompanyId());
            double averageRating = reviewClient.getAverageRating(reviewMessage.getCompanyId());
            company.setRating(averageRating);
            companyRepository.save(company);

    }
}
