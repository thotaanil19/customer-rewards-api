package com.infogain.rewardsapi.util;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilTest {

	@Test
	void testLocalDateToMonthAndYear() {
		Assertions.assertEquals("Jan, 2020", Util.localDateToMonthAndYear(LocalDate.of(2020, 01, 25)));
	}

}
