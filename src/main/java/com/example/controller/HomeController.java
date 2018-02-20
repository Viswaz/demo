package com.example.controller;

import java.util.Map;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(value="/")
	public String home(OAuth2AuthenticationToken authentication) {
		String result="";
		Map<String, Object> attrs = authentication.getPrincipal().getAttributes(); 
		for (Map.Entry<String, Object> entry : attrs.entrySet()) {
		    result += (entry.getKey() + " = " + entry.getValue() + "<br>");
		}
		return "Hello User !!! <br> Here are your details: <br>" + result;
	}
	
}
