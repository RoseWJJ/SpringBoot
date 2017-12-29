package com.et.lesson03.service.impl;



import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.et.lesson03.dao.EmpMapper;
import com.et.lesson03.entity.Emp;
import com.et.lesson03.entity.EmpExample;
import com.et.lesson03.entity.EmpExample.Criteria;
import com.et.lesson03.service.EmpService;
import com.et.lesson03.util.PageTools;

@Service
public class EmpServiceImpl implements  EmpService {
	
	@Autowired
	EmpMapper em;
	public int queryEmpTotalCount(EmpExample fe){
		
		int totalCount =(int)em.countByExample(fe);
		
		return totalCount;
	}
	public PageTools queryEmp(String sname,Integer page,Integer rows){
		if(sname==null){
			sname="";
		}
		EmpExample example = new EmpExample();
		//构造一个条件
		Criteria c = example.createCriteria();
		c.andSnameLike("%"+sname+"%");
		//查询总记录数
		int total=queryEmpTotalCount(example);
		PageTools ps=new PageTools(page, total, rows);
		System.out.println(page+"-------------"+total+"-------------"+rows);
		//通过RowBounds自动生成每页的数据
		RowBounds rb = new RowBounds(ps.getStartIndex()-1,rows);
		List<Emp> empList = em.selectByExampleWithRowbounds(example, rb);
		ps.setRows(empList);
		return ps;
	}
	public void deleteEmp(String id) {
		em.deleteByPrimaryKey(Integer.valueOf(id));
	}

	public void updateEmp(Emp dept) {
		em.updateByPrimaryKey(dept);
	}
	public void addEmp(Emp dept) {
		
		em.insert(dept);
	}
}
