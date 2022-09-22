package com.infogain.rewardsapi.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.rewardsapi.CustomerApi;
import com.infogain.rewardsapi.model.RewardsApiResponse;
import com.infogain.rewardsapi.service.CustomerRewardsService;

/**
 * 
 * @author Thota, Anil
 *
 */
@RestController
public class CustomerRewardsController implements CustomerApi {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerRewardsController.class);

	@Autowired
	private CustomerRewardsService customerRewardsService;

	/**
	 * Getting Rewards for given customer and with in given date periods
	 * 
	 * @param id
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return ResponseEntity<RewardsApiResponse>
	 */
	@Override
	public ResponseEntity<RewardsApiResponse> getCustomerRewards(Long id, LocalDate fromDate, LocalDate toDate) {
		LOG.info("Start: getting Rewards for customer id: {} with order date from: {}, order to date: {}", id, fromDate, toDate);
		return new ResponseEntity<>(customerRewardsService.getCustomerRewards(id, fromDate, toDate), HttpStatus.OK);
	}

}
