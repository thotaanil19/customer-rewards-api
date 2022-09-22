package com.infogain.rewardsapi.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.infogain.rewardsapi.dao.RewardsConfigurationRepository;

@SpringBootTest
class UtilIntegrationTest {

	@Autowired
	private RewardsConfigurationRepository rewardsConfigurationRepository;
	
	@Test
	void testCalculateRewards() {
		Assertions.assertEquals(90D, Util.calculateRewards(120D, rewardsConfigurationRepository.findAll()));
	}
	
	

}
