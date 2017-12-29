package com.et.lesson03.service;

import java.util.List;


import com.et.lesson03.entity.Emp;
import com.et.lesson03.entity.TreeNode;

public interface DeptService {

	public abstract List<TreeNode> queryTreeNode(Integer pid);
	public abstract List<Emp> queryEmp(Integer id );
	
	

}