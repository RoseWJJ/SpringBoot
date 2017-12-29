package com.et.lesson03.service;

import com.et.lesson03.entity.Food;
import com.et.lesson03.util.PageTools;

public interface FoodService {

	public abstract PageTools queryFood(String foodame, Integer page, Integer rows);
	public void deleteFood(String foodid);
	public void updateFood(Food food);
	public void addFood(Food food);

}