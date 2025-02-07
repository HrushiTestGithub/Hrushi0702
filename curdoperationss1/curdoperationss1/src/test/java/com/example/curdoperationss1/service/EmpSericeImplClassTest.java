package com.example.curdoperationss1.service;
 
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;  // ✅ Correct one!
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock; 
import org.mockito.junit.jupiter.MockitoExtension;
 
import com.example.curdoperationss1.entity.EntityCLass;
import com.example.curdoperationss1.repo.EmpRepoInterface;

import jakarta.validation.constraints.AssertTrue;

@ExtendWith(MockitoExtension.class)
class EmpSericeImplClassTest {

	@Mock
	 private EmpRepoInterface empRepo;
	
	@InjectMocks
	private EmpSericeImplClass empservice;
	
	
	private EntityCLass entityClass;
	
	@BeforeEach
	public void setValue()
	{
		entityClass=new EntityCLass(1,"gayathri","SDE1",5000000);
		
		
	}
	
	@Test
	public void postMethod()
	{
		when(empRepo.save(entityClass)).thenReturn(entityClass);
		EntityCLass eClass=empservice.post(entityClass);
		assertNotNull(eClass);
		assertEquals("gayathri",eClass.getEmpName());	
	}  
	
	@Test
	public void getAll()
	{
		when(empRepo.findAll()).thenReturn(Arrays.asList(entityClass));
		List<EntityCLass> eClass=empservice.getAllValues();
		assertEquals(1, eClass.size());
	}

	@Test
	public void getEmpIdMethod()
	{
	    // Mock the repository call to return an Optional containing entityClass
	    when(empRepo.findById(1)).thenReturn(Optional.of(entityClass));
	    
	    // Call the service method, which is expected to return EntityCLass (not Optional)
	    EntityCLass entity = empservice.getById(1);  // The return type is EntityCLass, not Optional
	    
	    // Check that the entity is not null
	    assertNotNull(entity);
	    
	    // Optionally, assert that the returned entity is the same as the mock entityClass
	    assertEquals(entityClass, entity);
	}
	
	@Test
    void testUpdateEmployee() {
        // Create the existing employee entity and updated data
        EntityCLass existingEmployee = new EntityCLass(1, "gayathri", "sde1", 1000000);
        EntityCLass updatedEmployeeData = new EntityCLass(1, "Hrushi", "sde2", 1000000);

        // Mock the repository behavior
        when(empRepo.findById(1)).thenReturn(Optional.of(existingEmployee));
        when(empRepo.save(any(EntityCLass.class))).thenAnswer(invocation -> invocation.getArgument(0));
        // Call the service method to update the employee
        EntityCLass updatedEmployee = empservice.update(updatedEmployeeData, 1);

        // Validate the result
        assertNotNull(updatedEmployee);
        assertEquals("Hrushi", updatedEmployee.getEmpName());
        assertEquals("sde2", updatedEmployee.getEmpDesignation());

        // Verify repository interactions
        verify(empRepo, times(1)).findById(1);
        verify(empRepo, times(1)).save(existingEmployee);

	}

@Test
public void deleteMethod()
{
	doNothing().when(empRepo).deleteById(1);
	empservice.deleteValue(1);
	verify(empRepo,times(1)).deleteById(1);
	
}




	
	
	
}
