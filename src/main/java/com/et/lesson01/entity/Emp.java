package com.et.lesson01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Emp {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)//制定主键生成策略
	private int id;
	@Column(name="sname")//此处写数据库中的列名
	private String name;//此处写属性名， 以防数据库列名和属性名不一致
	@Column
	private int deptid;//此处写数据库中的列名一致 时 可以不用谢
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	

	
}
