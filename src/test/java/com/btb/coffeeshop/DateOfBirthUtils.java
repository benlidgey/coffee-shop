package com.btb.coffeeshop;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class DateOfBirthUtils {

	public static Date getDateInPast(int i) {
		return getDate(i * -1);
	}

	public static Date getDateInFuture(int i) {
		return getDate(i);
	}

	private static Date getDate(int i) {
		Date date = new Date();
		return DateUtils.addYears(date, i);
	}

}
