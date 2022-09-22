package com.infogain.rewardsapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.infogain.rewardsapi.dao.OrdersRepository;
import com.infogain.rewardsapi.dao.RewardsConfigurationRepository;
import com.infogain.rewardsapi.entites.Orders;
import com.infogain.rewardsapi.entites.RewardsConfiguration;
import com.infogain.rewardsapi.exception.NoOrdersFoundException;
import com.infogain.rewardsapi.model.RewardsApiResponse;

class CustomerRewardsServiceTest {

	@Mock
	private OrdersRepository ordersRepository;

	@Mock
	private RewardsConfigurationRepository rewardsConfigurationRepository;

	@InjectMocks
	private CustomerRewardsService customerRewardsService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		// Mock the DB calls
		Mockito.doReturn(rewardsConfigurations()).when(rewardsConfigurationRepository).findAll();
		Mockito.doReturn(orders()).when(ordersRepository).findAllByCustomerId(1L);
		Mockito.doReturn(orders()).when(ordersRepository).findAllByCustomerIdAndOrderDateGreaterThanEqual(Mockito.eq(1L), Mockito.any(LocalDate.class));
		Mockito.doReturn(orders()).when(ordersRepository).findAllByCustomerIdAndOrderDateLessThanEqual(Mockito.eq(1L), Mockito.any(LocalDate.class));
		Mockito.doReturn(orders()).when(ordersRepository).findAllByCustomerIdAndOrderDateBetween(Mockito.eq(1L), Mockito.any(LocalDate.class), Mockito.any(LocalDate.class));
	}

	@Test
	void testGetCustomerRewards() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L,  null, null);
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}
	
	@Test
	void testGetCustomerRewardsWithStartDate() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L,  LocalDate.of(2022, 01, 01), null);
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}
	
	@Test
	void testGetCustomerRewardsWithEndDate() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L,  null, LocalDate.of(2022, 9, 22));
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}
	
	@Test
	void testGetCustomerRewardsWithStartDateAndDate() {
		RewardsApiResponse rewardsApiResponse = customerRewardsService.getCustomerRewards(1L,  LocalDate.of(2022, 01, 01), LocalDate.of(2022, 9, 22));
		Assertions.assertNotNull(rewardsApiResponse);
		Assertions.assertEquals(1L, rewardsApiResponse.getCustomerId());
		Assertions.assertNotNull(rewardsApiResponse.getTotalRewardPoints());
		Assertions.assertNotNull(rewardsApiResponse.getMonthlyRewardPoints());
	}

	@Test
	void testGetCustomerRewards_InvalidCustomerId() {
		Assertions.assertThrows(NoOrdersFoundException.class, () -> customerRewardsService.getCustomerRewards(200L,  LocalDate.of(2022, 01, 01), LocalDate.of(2022, 9, 22)));
	}

	private List<RewardsConfiguration> rewardsConfigurations() {
		List<RewardsConfiguration> rewardsConfigurations = new ArrayList<>();
		RewardsConfiguration rewardsConfiguration1 = new RewardsConfiguration();
		rewardsConfiguration1.setId(1L);
		rewardsConfiguration1.setPrice(100D);
		rewardsConfiguration1.setRewards(2L);
		rewardsConfigurations.add(rewardsConfiguration1);

		RewardsConfiguration rewardsConfiguration2 = new RewardsConfiguration();
		rewardsConfiguration2.setId(2L);
		rewardsConfiguration2.setPrice(50D);
		rewardsConfiguration2.setRewards(1L);
		rewardsConfigurations.add(rewardsConfiguration2);
		return rewardsConfigurations;
	}

	private List<Orders> orders() {
		List<Orders> orders = new ArrayList<>();
		Orders order1 = new Orders();
		order1.setId(1L);
		order1.setPrice(120D);
		order1.setCustomerId(1L);
		order1.setOrderDate(LocalDate.now());
		orders.add(order1);

		return orders;
	}

}
