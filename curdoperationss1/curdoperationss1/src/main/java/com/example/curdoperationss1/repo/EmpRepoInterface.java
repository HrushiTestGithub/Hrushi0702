package com.example.curdoperationss1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.curdoperationss1.entity.EntityCLass;

@Repository
public interface EmpRepoInterface extends JpaRepository<EntityCLass, Integer>{
   
}
