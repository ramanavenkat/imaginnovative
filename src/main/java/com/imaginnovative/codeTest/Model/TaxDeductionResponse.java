package com.imaginnovative.codeTest.Model;

public class TaxDeductionResponse {
	
	private String employeeId;
	private String firstname;
	private String lastname;
	private double totalSalary;
	private double taxAmount;
	private double cessAmount;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getCessAmount() {
		return cessAmount;
	}
	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	@Override
	public String toString() {
		return "TaxDeductionResponse [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", totalSalary=" + totalSalary + ", taxAmount=" + taxAmount + ", cessAmount=" + cessAmount + "]";
	}
	
	

}
