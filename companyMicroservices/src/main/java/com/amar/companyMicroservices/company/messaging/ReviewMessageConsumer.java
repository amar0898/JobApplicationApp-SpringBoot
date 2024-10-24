package com.amar.companyMicroservices.company.messaging;

import com.amar.companyMicroservices.company.CompanyService;
import com.amar.companyMicroservices.company.dto.ReviewMessage;
import org.apache.hc.core5.http.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {

    private final CompanyService companyService;

    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage) {
        companyService.updateCompanyRating(reviewMessage);
    }
}
