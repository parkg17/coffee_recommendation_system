package com.gyeol.coffee.controller;

import com.gyeol.coffee.dto.request.GetItemRecommendationRequest;
import com.gyeol.coffee.dto.request.GetSimilarityRecommendationRequest;
import com.gyeol.coffee.dto.response.GetItemRecommendationResponse;
import com.gyeol.coffee.dto.response.GetSimilarityRecommendationResponse;
import com.gyeol.coffee.service.CoffeeReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class MainController {
    private final CoffeeReviewService coffeeReviewService;

    @GetMapping("/item")
    public  GetItemRecommendationResponse getItemRecommendation(@RequestBody GetItemRecommendationRequest req)
            throws IOException {

        return coffeeReviewService.getItemRecommendation(req.getCondition1(), req.getCondition2(), req.getCondition3());
    }

    @GetMapping("/similar")
    public GetSimilarityRecommendationResponse getSimilarRecommendation(@RequestBody GetSimilarityRecommendationRequest req)
            throws IOException {
        return coffeeReviewService.getSimilarityRecommendation(req);

        //return coffeeReviewService.getSimilarityRecommendation(req.getGrowing_region(), req.getTree_variety(), req.getRoast_level());
    }
}
