package com.infogain.rewardsapi.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.infogain.rewardsapi.exception.NoOrdersFoundException;
import com.infogain.rewardsapi.model.RewardsApiResponse;

@SpringBootTest
class CustomerRewardsServiceIntegrationTest {

	@Autowired
	private CustomerRewardsService customerRewardsService;

	
	@Test
	void testGetCustomerRewards() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L, null, null);
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}
	
	@Test
	void testGetCustomerRewardsWithStartAndEndDates() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L, LocalDate.of(2022, 01, 01), LocalDate.of(2022, 9, 22));
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}
	
	@Test
	void testGetCustomerRewardsWithStartDate() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L, LocalDate.of(2022, 01, 01), null);
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}
	
	@Test
	void testGetCustomerRewardsWithEndDate() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L, null, LocalDate.of(2022, 9, 22));
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}

	@Test
	void testGetCustomerRewards_InvalidCustomerId() {
		Assertions.assertThrows(NoOrdersFoundException.class, () -> customerRewardsService.getCustomerRewards(200L,  LocalDate.of(2022, 01, 01), LocalDate.of(2022, 9, 22)));
	}

}
