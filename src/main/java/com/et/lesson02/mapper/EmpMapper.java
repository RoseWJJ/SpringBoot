package com.et.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.et.lesson02.entity.Emp;
@Mapper
public interface EmpMapper {
	@Select("select * from emp")
	List<Emp> queryEmp();
	@Select("select * from emp where id=#{0}")
	Emp queryById(int id);

}
