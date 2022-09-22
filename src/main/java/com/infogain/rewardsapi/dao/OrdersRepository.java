package com.infogain.rewardsapi.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infogain.rewardsapi.entites.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	List<Orders> findAllByCustomerId(Long customerId);
	
	List<Orders> findAllByCustomerIdAndOrderDateGreaterThanEqual(Long customerId, LocalDate orderDate);
	
	List<Orders> findAllByCustomerIdAndOrderDateLessThanEqual(Long customerId, LocalDate orderDate);
	
	List<Orders> findAllByCustomerIdAndOrderDateBetween(Long customerId, LocalDate fromOrderDate, LocalDate toOrderDate);

}
