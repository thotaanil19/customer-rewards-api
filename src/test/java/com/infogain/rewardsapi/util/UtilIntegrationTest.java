package com.infogain.rewardsapi.util;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.infogain.rewardsapi.dao.RewardsConfigurationRepository;
import com.infogain.rewardsapi.entites.RewardsConfiguration;

@SpringBootTest
class UtilIntegrationTest {

	@Autowired
	private RewardsConfigurationRepository rewardsConfigurationRepository;

	@Test
	void testCalculateRewards() {

		List<RewardsConfiguration> rewardsConfigurations = rewardsConfigurationRepository.findAll();

		// User will get 0 rewards if He/She buys less than or equals to 50
		Assertions.assertEquals(0D, Util.calculateRewards(20D, rewardsConfigurations));
		Assertions.assertEquals(0D, Util.calculateRewards(49D, rewardsConfigurations));
		Assertions.assertEquals(0D, Util.calculateRewards(50D, rewardsConfigurations));

		// 0.01 * 1 = 0
		Assertions.assertEquals(0D, Util.calculateRewards(50.001D, rewardsConfigurations));

		// 0.41 * 1 = 0.41
		Assertions.assertEquals(0.41D, Util.calculateRewards(50.41D, rewardsConfigurations));

		// 0.413 * 1 = 0.41
		Assertions.assertEquals(0.41D, Util.calculateRewards(50.413D, rewardsConfigurations));

		// 0.415 * 1 = 0.41
		Assertions.assertEquals(0.41D, Util.calculateRewards(50.415D, rewardsConfigurations));

		// 0.416 * 1 = 0.42
		Assertions.assertEquals(0.42D, Util.calculateRewards(50.416D, rewardsConfigurations));

		// 0.5 * 1 = 0.5
		Assertions.assertEquals(0.5D, Util.calculateRewards(50.5D, rewardsConfigurations));

		// 0.6 * 1 = 0.6
		Assertions.assertEquals(0.6D, Util.calculateRewards(50.6D, rewardsConfigurations));

		// 1 * 1 = 1
		Assertions.assertEquals(1.0D, Util.calculateRewards(51D, rewardsConfigurations));

		// 5.1 * 1 = 51.1
		Assertions.assertEquals(5.1D, Util.calculateRewards(55.1D, rewardsConfigurations));

		// 49 * 1 = 49
		Assertions.assertEquals(49D, Util.calculateRewards(99D, rewardsConfigurations));

		// 50 * 1 = 50
		Assertions.assertEquals(50D, Util.calculateRewards(100D, rewardsConfigurations));

		// (0.1 * 2) + (50 * 1) = 50.2
		Assertions.assertEquals(50.2D, Util.calculateRewards(100.1D, rewardsConfigurations));

		// (0.01 * 2) + (50 * 1) = 50.02
		Assertions.assertEquals(50.02D, Util.calculateRewards(100.01D, rewardsConfigurations));

		// (20 * 2) + (50 * 1) = 90
		Assertions.assertEquals(90D, Util.calculateRewards(120D, rewardsConfigurations));

		// (100 * 2) + (50 * 1) = 250
		Assertions.assertEquals(250D, Util.calculateRewards(200D, rewardsConfigurations));

		// (900 * 2) + (50 * 1) = 1850
		Assertions.assertEquals(1850D, Util.calculateRewards(1000D, rewardsConfigurations));
	}

	@Test
	void testCalculateRewardsWithPurchaseAmountZero() {
		List<RewardsConfiguration> rewardsConfigurations = rewardsConfigurationRepository.findAll();
		// User will get 0 rewards if purchase amount is 0
		Assertions.assertEquals(0D, Util.calculateRewards(0D, rewardsConfigurations));
	}

}
