package com.example.curdoperationss1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curdoperationss1.entity.EntityCLass;
import com.example.curdoperationss1.repo.EmpRepoInterface;

@Service
public class EmpSericeImplClass implements EmpServiceInterface{

	@Autowired
	EmpRepoInterface repo;

	@Override
	public EntityCLass post(EntityCLass emp) {
		// TODO Auto-generated method stub
		repo.save(emp);
		return emp;
	}

	@Override
	public void deleteValue(int empId) {
		// TODO Auto-generated method stub
		repo.deleteById(empId);
		
		
	}

	@Override
	public List<EntityCLass> getAllValues() {
		// TODO Auto-generated method stub
		List<EntityCLass> empList=new ArrayList<EntityCLass>();
		repo.findAll().forEach(gayathri -> empList.add(gayathri));
		return empList;
	}

	@Override
	public EntityCLass getById(int empId) { 
		
		return repo.findById(empId).get();
		//return empId;
	}

	@Override
	public EntityCLass update(EntityCLass emp, int empId) { 
		
		repo.save(emp);
		return emp;
	}

	 
}
