package com.et.lesson01.service;

import com.et.lesson01.entity.Emp;

public interface EmpService {
	public abstract int save(Emp emp);
	public abstract Emp query(Integer id);
	public abstract int delete(Integer id);
	public int update(Emp emp);
}
