package com.infogain.rewardsapi.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.infogain.rewardsapi.exception.NoOrdersFoundException;
import com.infogain.rewardsapi.model.RewardsApiResponse;

@SpringBootTest
class CustomerRewardsControllerIntegrationTest {

	@Autowired
	private CustomerRewardsController customerRewardsController;

	@Test
	void testGetCustomerRewards() {
		ResponseEntity<RewardsApiResponse> rewardsApiResponse = customerRewardsController.getCustomerRewards(1L, null, null);
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(HttpStatus.OK, rewardsApiResponse.getStatusCode());
		Assertions.assertNotNull(rewardsApiResponse.getBody());
		Assertions.assertEquals(1L, rewardsApiResponse.getBody().getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getMonthlyRewardPoints());
	}

	@Test
	void testGetCustomerRewardsWithStartAndEndDates() {
		ResponseEntity<RewardsApiResponse> rewardsApiResponse = customerRewardsController.getCustomerRewards(1L, LocalDate.of(2022, 01, 01), LocalDate.of(2022, 9, 22));
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(HttpStatus.OK, rewardsApiResponse.getStatusCode());
		Assertions.assertNotNull(rewardsApiResponse.getBody());
		Assertions.assertEquals(1L, rewardsApiResponse.getBody().getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getMonthlyRewardPoints());
	}

	@Test
	void testGetCustomerRewardsWithStartDate() {
		ResponseEntity<RewardsApiResponse> rewardsApiResponse = customerRewardsController.getCustomerRewards(1L, LocalDate.of(2022, 01, 01), null);
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(HttpStatus.OK, rewardsApiResponse.getStatusCode());
		Assertions.assertNotNull(rewardsApiResponse.getBody());
		Assertions.assertEquals(1L, rewardsApiResponse.getBody().getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getMonthlyRewardPoints());
	}

	@Test
	void testGetCustomerRewardsWithEndDate() {
		ResponseEntity<RewardsApiResponse> rewardsApiResponse = customerRewardsController.getCustomerRewards(1L, null, LocalDate.of(2022, 9, 22));
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(HttpStatus.OK, rewardsApiResponse.getStatusCode());
		Assertions.assertNotNull(rewardsApiResponse.getBody());
		Assertions.assertEquals(1L, rewardsApiResponse.getBody().getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getBody().getMonthlyRewardPoints());
	}

	@Test
	void testGetCustomerRewards_InvalidCustomerId() {
		Assertions.assertThrows(NoOrdersFoundException.class, () -> customerRewardsController.getCustomerRewards(200L,
				LocalDate.of(2022, 01, 01), LocalDate.of(2022, 9, 22)));
	}

}
