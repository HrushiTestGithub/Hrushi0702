package com.example.curdoperationss1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.curdoperationss1.entity.EntityCLass;
import com.example.curdoperationss1.service.EmpSericeImplClass;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	@Autowired
	 EmpSericeImplClass empService;
	 
	
	@PostMapping("/post")
	public EntityCLass saveOrUpdate(@RequestBody EntityCLass emp)
	{
		 empService.post(emp);
		 return emp;
	}
	
	@DeleteMapping("/delete/{empId}")
	
	public void deleteValue(@PathVariable int empId)
	{
		empService.deleteValue(empId);
		
	}
	
	@GetMapping("/user/getAll")
	 
	public List<EntityCLass> getAllValue1()
	{
		return empService.getAllValues();
	}
	
	@GetMapping("/admin/getAll")
	 
	public List<EntityCLass> getAllValue()
	{
		return empService.getAllValues();
	}
	
	@GetMapping("/getById/{empId}")
	 
	public EntityCLass getById1(@PathVariable int empId)
	{
		
		return empService.getById(empId);
		
		
	}
	
	@PutMapping("/update/{empId}")
	
	public EntityCLass update(@PathVariable int empId, @RequestBody EntityCLass emp)
	{
		return empService.update(emp, empId);
		//return emp;
	}

}
