package com.example.curdoperationss1.entity;
 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
 
//modification1

@Entity
@Table(name="empDetails")
public class EntityCLass {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@Column
	private String empName;
	
	@Column
	private String empDesignation;
	
	@Column 
	private double salary;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		System.out.println("EntityCLass [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", salary=" + salary + "]");
		return "EntityCLass [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", salary=" + salary + "]";
	}

	public EntityCLass(int empId, String empName, String empDesignation, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.salary = salary;
	}

	public EntityCLass() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	
	
}
