package com.driver.service.impl;

import com.driver.io.entity.FoodEntity;
import com.driver.io.repository.FoodRepository;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;

    @Override
    public FoodDto createFood(FoodDto food) {
        FoodEntity foodEntityToBeSaved = new FoodEntity();

        foodEntityToBeSaved.setFoodName(food.getFoodName());
        foodEntityToBeSaved.setFoodCategory(food.getFoodCategory());
        foodEntityToBeSaved.setFoodPrice(food.getFoodPrice());
        foodEntityToBeSaved.setFoodId(UUID.randomUUID().toString());

        FoodEntity foodEntity = foodRepository.save(foodEntityToBeSaved);
        return getFoodDto(foodEntity);
    }

    private FoodDto getFoodDto(FoodEntity foodEntity) {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(foodEntity.getId());
        foodDto.setFoodId(foodEntity.getFoodId());
        foodDto.setFoodName(foodEntity.getFoodName());
        foodDto.setFoodPrice(foodEntity.getFoodPrice());
        foodDto.setFoodCategory(foodEntity.getFoodCategory());

        return foodDto;
    }

    @Override
    public FoodDto getFoodById(String foodId) throws Exception {
        FoodEntity foodEntity = foodRepository.findByFoodId(foodId);

        return getFoodDto(foodEntity);
    }

    @Override
    public FoodDto updateFoodDetails(String foodId, FoodDto foodDetails) throws Exception {
        return null;
    }

    @Override
    public void deleteFoodItem(String id) throws Exception {

    }

    @Override
    public List<FoodDto> getFoods() {
        return null;
    }
}