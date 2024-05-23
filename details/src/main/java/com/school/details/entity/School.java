package com.school.details.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "school")
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address_1", nullable = true)
	private String address1;
	
	@Column(name = "address_2")
	private String address2;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	
	
	
}
