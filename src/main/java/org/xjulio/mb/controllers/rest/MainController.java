/*
 * @(#)MainController.java
 *
 * Copyright 2018
 */
package org.xjulio.mb.controllers.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xjulio.mb.services.TimeZoneService;
import org.xjulio.mb.services.VersionService;

import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;

@Controller
/**
 * @author <a href="mailto:xjulio@gmail.com">Julio Cesar Damasceno</a>
 */
public class MainController {

	@Autowired
	private TimeZoneService tzService;
	
	@Autowired
	private VersionService versionService;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	static final Counter homerRequests = Counter.build().name("homersimpson_requests_total").help("Total number of requests.")
			.register();

	// Define a histogram metric for /prometheus
	static final Histogram homerRequestLatency = Histogram.build().name("homersimpson_requests_latency_seconds")
			.help("Request latency in seconds.").register();

	static final Counter covilhaRequests = Counter.build().name("covilha_requests_total").help("Total number of requests.").register();

	// Define a histogram metric for /prometheus
	static final Histogram covilhaRequestLatency = Histogram.build().name("covilha_requests_latency_seconds")
			.help("Request latency in seconds.").register();

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		
		System.out.println("Versao: "+this.versionService.getJarVersion());
		model.put("version", this.versionService.getJarVersion());

		return "welcome";
	}

	@RequestMapping("/homersimpson")
	public String homer(Map<String, Object> model) {
		// Increase the counter metric
		homerRequests.inc();
		// Start the histogram timer
		Histogram.Timer requestTimer = homerRequestLatency.startTimer();

		try {
			model.put("message", this.message);

			return "homer";
		} finally {
			// Stop the histogram timer
			requestTimer.observeDuration();
		}
	}

	@RequestMapping(value = "/covilha", method = RequestMethod.GET)
	public ResponseEntity<?> getCovilhaTime() {
		// Increase the counter metric
		covilhaRequests.inc();
		// Start the histogram timer
		Histogram.Timer requestTimer = covilhaRequestLatency.startTimer();

		try {

			String timeString = tzService.getTimeByTimeZone("Europe", "Covilha");

			return new ResponseEntity<>(timeString, HttpStatus.OK);
		} finally {
			// Stop the histogram timer
			requestTimer.observeDuration();
		}

	}

	@RequestMapping(value = "/tz/{region:.*}/{country:.*}", method = RequestMethod.GET)
	public ResponseEntity<?> getTzTime(@PathVariable String region, @PathVariable String country) {
		String timeString = tzService.getTimeByTimeZone(region, country);
		return new ResponseEntity<>(timeString, HttpStatus.OK);
	}
}