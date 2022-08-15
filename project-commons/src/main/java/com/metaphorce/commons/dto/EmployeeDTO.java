package com.metaphorce.commons.dto;

public class EmployeeDTO {

	private String fullName;
	private String taxNumber;
	private String email;
	private Object contract;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getContract() {
		return contract;
	}
	public void setContract(Object contract) {
		this.contract = contract;
	}
	
	/*• Nombre del tipo de contrato (ContractType.Name) en el que se encuentre actualmente activo. Si
	no cuenta con contrato activo enviar valor NULL.
	• Fecha inicio del contrato en el que se encuentre actualmente activo (Contract.DateFrom). Si no
	cuenta con contrato activo enviar valor NULL.
	• Fecha final del contrato en el que se encuentre actualmente vigente (Contract.DateTo), Si no
	cuenta con contrato activo enviar valor NULL.
	• Salario diario (Contract.SalaryPerDay), si no cuenta con contrato activo enviar valor NULL.
	*/

	
}
