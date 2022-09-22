package com.infogain.rewardsapi.entites;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Orders {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="ORDER_DATE")
	private LocalDate orderDate;
	
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	
	@Column(name="PRICE")
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
