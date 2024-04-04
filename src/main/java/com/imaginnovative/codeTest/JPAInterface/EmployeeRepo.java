package com.imaginnovative.codeTest.JPAInterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovative.codeTest.Model.EmployeeModel;

public interface EmployeeRepo extends JpaRepository<EmployeeModel,String>{

	EmployeeModel findByEmployeeId(String employeeId);

}
