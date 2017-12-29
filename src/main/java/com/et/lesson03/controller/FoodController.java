package com.et.lesson03.controller;

import java.io.File;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.et.lesson03.entity.Food;
import com.et.lesson03.entity.Result;
import com.et.lesson03.service.FoodService;
import com.et.lesson03.util.PageTools;

@Controller
public class FoodController {
	@Autowired
	FoodService fService;
	
	@RequestMapping("/queryFood")
	@ResponseBody
	public PageTools queryFood(@Param("foodname")String foodname,Integer page,Integer rows){
		
		
		return fService.queryFood(foodname,page,rows);
	}
	@ResponseBody
	@RequestMapping(value="/Food/{foodid}",method={RequestMethod.DELETE})
	public Result deleteFood(@PathVariable String foodid) throws Exception {
		
		String [] arr =	foodid.split(",");
	
		Result r = new Result();
		r.setCode(1);
		try {
			for(int i = 0 ; i < arr.length;i++){
				fService.deleteFood(arr[i]);
			}
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/saveFood",method={RequestMethod.POST})
	public Result saveFood(Food food,MultipartFile aa) throws Exception {
		Result r = new Result();
		try {
			r.setCode(1);
			String fileName = aa.getOriginalFilename();
			File  file = new File("C:\\myImag\\"+fileName);
			aa.transferTo(file);
			food.setImgpath(fileName);
			fService.addFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		
		return r;
	}
	@ResponseBody
	@RequestMapping(value="/updateFood/{foodid}",method={RequestMethod.PUT})
	public Result updateFood(@PathVariable Integer foodid,Food food) throws Exception{
		Result r = new Result();
		r.setCode(1);
		try {
	
			fService.updateFood(food);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
}
