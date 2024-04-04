package com.imaginnovative.codeTest.Service;

import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovative.codeTest.JPAInterface.EmployeeRepo;
import com.imaginnovative.codeTest.Model.EmployeeModel;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepo repo;

	public EmployeeModel saveEmployee(@Valid EmployeeModel model) {
		EmployeeModel savedModel = repo.save(model);
		return savedModel;
	}
	
	public boolean isValidEmployeeModel(EmployeeModel model) {
        if (model.getEmployeeId() == null || model.getEmployeeId().isEmpty()) {
            return false;
        }
        if (model.getFirstName() == null || model.getFirstName().isEmpty()) {
            return false;
        }
        if (model.getLastName() == null || model.getLastName().isEmpty()) {
            return false;
        }
        if (!isValidEmail(model.getEmail())) {
            return false;
        }
        if (model.getSalary() < 0) {
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }

	public EmployeeModel getEmployeeDetails(String employeeId) {
		EmployeeModel request = repo.findByEmployeeId(employeeId);
		return request;
	}
	
	public double calculateTaxAmount(double totalSalary) {
        if (totalSalary <= 250000) {
            return 0;
        } else if (totalSalary <= 500000) {
            return (totalSalary - 250000) * 0.05;
        } else if (totalSalary <= 1000000) {
            return 12500 + (totalSalary - 500000) * 0.1;
        } else {
            return 62500 + (totalSalary - 1000000) * 0.2;
        }
    }

    public double calculateCessAmount(double totalSalary) {
        if (totalSalary > 2500000) {
            return (totalSalary - 2500000) * 0.02;
        } else {
            return 0;
        }
    }
	

}
