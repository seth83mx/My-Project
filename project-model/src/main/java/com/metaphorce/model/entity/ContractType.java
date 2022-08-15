package com.metaphorce.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.google.gson.Gson;

@Entity
public class ContractType implements Serializable{


	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Integer contractTypeId;
	private String name;
	private String descripcion;
	private boolean isActive;
	private Date dateCreated;
  
	@ManyToOne
	@JoinColumn(name="contract")
    private List<Employee> contractTypeId;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public Date getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}



	public List<Employee> getContractTypeId() {
		return contractTypeId;
	}



	public void setContractTypeId(List<Employee> contractTypeId) {
		this.contractTypeId = contractTypeId;
	}



	public String toString(){
		Gson gson = new Gson();
		return gson.toJson(this);
	}
  
}
