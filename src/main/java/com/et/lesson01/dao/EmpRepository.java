package com.et.lesson01.dao;



import org.springframework.data.repository.CrudRepository;

import com.et.lesson01.entity.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer> {

}
