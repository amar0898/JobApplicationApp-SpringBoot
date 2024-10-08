package com.amardeep.JobApplication.review.impl;

import com.amardeep.JobApplication.company.Company;
import com.amardeep.JobApplication.company.CompanyRepository;
import com.amardeep.JobApplication.company.CompanyService;
import com.amardeep.JobApplication.review.Review;
import com.amardeep.JobApplication.review.ReviewRepository;
import com.amardeep.JobApplication.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findAllByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
       Company company = companyService.getCompanyById(companyId);
       if(company !=null){
           review.setCompany(company);
           reviewRepository.save(review);
           return true;
       }
       return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findAllByCompanyId(companyId);
        return reviews.stream().filter(r -> r.getReviewId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId)!=null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setReviewId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId)!=null && reviewRepository.existsById(reviewId)){
          Review review = reviewRepository.findById(reviewId).orElse(null);
          Company company = companyService.getCompanyById(companyId);
          company.getReviews().remove(review);
          review.setCompany(null);
          companyService.updateCompany(company,companyId);
          reviewRepository.deleteById(reviewId);
          return true;
        }
        return false;
    }
}
