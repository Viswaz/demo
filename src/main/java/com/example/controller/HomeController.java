package com.example.controller;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping(value="/")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String home(@AuthenticationPrincipal OAuth2User user) {
		String result="";
		Map<String, Object> attrs = user.getAttributes(); 
		for (Map.Entry<String, Object> entry : attrs.entrySet()) {
		    result += (entry.getKey() + " = " + entry.getValue() + "<br>");
		}
		return "Hello User !!! <br> Here are your details: <br>" + result;
	}
	
}
