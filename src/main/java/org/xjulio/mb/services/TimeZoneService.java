/*
 * @(#)TimeZoneService.java
 *
 * Copyright 2018
 */
package org.xjulio.mb.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:xjulio@gmail.com">Julio Cesar Damasceno</a>
 */
@Service
public class TimeZoneService {
	public String getTimeByTimeZone(String continent, String country) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		df.setTimeZone(TimeZone.getTimeZone(continent + "/" + country));
		
		return df.format(date);
	}
}