package com.example.curdoperationss1.service;
 
import java.util.List;

import com.example.curdoperationss1.entity.EntityCLass;


public interface EmpServiceInterface {
	
 	public EntityCLass post(EntityCLass emp);
 	
 	public void deleteValue(int empId);
 	
 	public List<EntityCLass> getAllValues();
 	
 	public EntityCLass getById(int empId);
 	
 	public EntityCLass update(EntityCLass emp,int empId);
 	
 	

}
