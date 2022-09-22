package com.infogain.rewardsapi.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.infogain.rewardsapi.entites.RewardsConfiguration;

public class Util {

	private Util() {
		// Hide implicit constructor
	}

	/**
	 * Calculate Reward points for given purchase amount
	 * 
	 * @param amount
	 * @param rewardsConfigurations
	 * @return Double
	 */
	public static Double calculateRewards(Double amount, List<RewardsConfiguration> rewardsConfigurations) {

		/*
		if (amount > 100D) {
			rewards += (amount - 100D) * 2;
			amount = 100D;
		}

		if (amount > 50D) {
			rewards += (amount - 50D) * 1;
		}*/
		
		
		Double rewards = 0D;
		for (RewardsConfiguration rewardsConfiguration : rewardsConfigurations) {
			if (amount > rewardsConfiguration.getPrice()) {
				rewards += (amount - rewardsConfiguration.getPrice()) *  rewardsConfiguration.getRewards();
				amount =  rewardsConfiguration.getPrice();
			}
		}
		
		return roundDoubleValue(rewards);
	}
	
	/**
	 * Round Double value to Double with 2 digits precision
	 * 
	 * @param rewards
	 * @return Double
	 */
	private static Double roundDoubleValue(Double rewards) {
		return BigDecimal.valueOf(rewards).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
	}

	/**
	 * Convert given LocalDate to Month and Year combination Ex: 2022-02-20 => Feb,
	 * 2022
	 * 
	 * @param localDate
	 * @return String
	 */
	public static String localDateToMonthAndYear(LocalDate localDate) {
		return localDate.format(DateTimeFormatter.ofPattern("MMM, yyyy"));
	}

}
