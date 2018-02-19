package com.example.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/")
	public String home() {
		return "Hello World !!! " + counter.getAndIncrement();
	}
	
}
