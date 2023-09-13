package com.driver.ui.controller;

import java.util.List;

import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.model.response.OperationStatusModel;
import com.driver.service.FoodService;
import com.driver.service.impl.FoodServiceImpl;
import com.driver.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping(path = "/{id}")
    public FoodDetailsResponse getFood(@PathVariable String id) throws Exception {
        FoodDto foodById = foodService.getFoodById(id);
        FoodDetailsResponse response = new FoodDetailsResponse();

        response.setFoodId(foodById.getFoodId());
        response.setFoodName(foodById.getFoodName());
        response.setFoodPrice(foodById.getFoodPrice());
        response.setFoodCategory(foodById.getFoodCategory());

        return response;
    }

    @PostMapping("/create")
    public FoodDetailsResponse createFood(@RequestBody FoodDetailsRequestModel foodDetails) {
        FoodDto foodDto = new FoodDto();
        foodDto.setFoodName(foodDetails.getFoodName());
        foodDto.setFoodPrice(foodDetails.getFoodPrice());
        foodDto.setFoodCategory(foodDetails.getFoodCategory());

        FoodDto foodById = foodService.createFood(foodDto);
        
        FoodDetailsResponse response = new FoodDetailsResponse();

        response.setFoodId(foodById.getFoodId());
        response.setFoodName(foodById.getFoodName());
        response.setFoodPrice(foodById.getFoodPrice());
        response.setFoodCategory(foodById.getFoodCategory());

        return response;
    }

    @PutMapping(path = "/{id}")
    public FoodDetailsResponse updateFood(@PathVariable String id, @RequestBody FoodDetailsRequestModel foodDetails) throws Exception {

        return null;
    }

    @DeleteMapping(path = "/{id}")
    public OperationStatusModel deleteFood(@PathVariable String id) throws Exception {

        return null;
    }

    @GetMapping()
    public List<FoodDetailsResponse> getFoods() {

        return null;
    }
}
