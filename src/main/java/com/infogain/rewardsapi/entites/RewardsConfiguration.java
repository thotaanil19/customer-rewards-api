package com.infogain.rewardsapi.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REWARDS_CONFIGURATION")
public class RewardsConfiguration {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="REWARDS")
	private Long rewards;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getRewards() {
		return rewards;
	}

	public void setRewards(Long rewards) {
		this.rewards = rewards;
	}

}
