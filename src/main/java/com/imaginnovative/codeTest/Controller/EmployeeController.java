package com.imaginnovative.codeTest.Controller;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovative.codeTest.Model.EmployeeModel;
import com.imaginnovative.codeTest.Model.TaxDeductionResponse;
import com.imaginnovative.codeTest.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;
	
	@GetMapping("/")
	public String welcomeApi() {
		return "Welcome to app";
	}
	
	@PostMapping("/storeData")
	public ResponseEntity<?> storeEmployeeData(@RequestBody EmployeeModel model) {
        
        if (service.isValidEmployeeModel(model)) {
        	EmployeeModel savedEmployee = service.saveEmployee(model);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Invalid employee data", HttpStatus.BAD_REQUEST);
        }
    }
	
	
	 @GetMapping("/tax-deduction")
	    public TaxDeductionResponse calculateTaxDeduction(@RequestParam String employeeId) {
	        LocalDate currentDate = LocalDate.now();
	        EmployeeModel request = service.getEmployeeDetails(employeeId);
	        LocalDate doj = request.getDateOfJoining();
	        Period period = Period.between(doj, currentDate);
	        int monthsWorked = period.getYears() * 12 + period.getMonths();
	        double totalSalary = request.getSalary() * monthsWorked;
	        double taxAmount = service.calculateTaxAmount(totalSalary);
	        double cessAmount = service.calculateCessAmount(totalSalary);
	        
	        TaxDeductionResponse response = new TaxDeductionResponse();
	        response.setEmployeeId(employeeId);
	        response.setFirstname(request.getFirstName());
	        response.setLastname(request.getLastName());
	        response.setTotalSalary(totalSalary);
	        response.setTaxAmount(taxAmount);
	        response.setCessAmount(cessAmount);
	        
	        return response;
	    }

    
}
