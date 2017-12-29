package com.et.lesson03.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.lesson03.dao.FoodMapper;
import com.et.lesson03.entity.Food;
import com.et.lesson03.entity.FoodExample;
import com.et.lesson03.service.FoodService;
import com.et.lesson03.util.PageTools;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodMapper fMapper;
	
	public int queryFoodTotalCount(FoodExample fe){
	
		int totalCount =(int)fMapper.countByExample(fe);
		return totalCount;
	}
	
	public PageTools queryFood(String foodame, Integer page, Integer rows) {
		if(foodame==null){
			foodame="";
		}
		FoodExample fe = new FoodExample();
		fe.createCriteria().andFoodnameLike("%"+foodame+"%");
		int totalCount =queryFoodTotalCount(fe);
		//发起sql语句查询总记录数
		PageTools pTools = new PageTools(page, totalCount, rows);
		RowBounds rb = new RowBounds(pTools.getStartIndex()-1, rows);
		List<Food> foodList = fMapper.selectByExampleWithRowbounds(fe, rb);
		pTools.setRows(foodList);
		return pTools;
	
	}



	public void deleteFood(String foodid) {
		fMapper.deleteByPrimaryKey(Integer.valueOf(foodid));
	}

	public void updateFood(Food food) {
		fMapper.updateByPrimaryKey(food);
	}
	public void addFood(Food food) {
		
		fMapper.insert(food);
	}
	
}
