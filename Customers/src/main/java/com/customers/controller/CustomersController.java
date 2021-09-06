package com.customers.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customers.dto.CustomersDto;
import com.customers.service.CustomersService;

@RestController
public class CustomersController {
	
	@Autowired
	CustomersService customersService;
	
	@GetMapping("/hello")
	public ResponseEntity<Map<String, String>> hello() {
	    try {
	        Map<String, String> body = new HashMap<>();
	        body.put("message", "Hello world");
	        return new ResponseEntity<>(body, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	@GetMapping("/getDetails")
	public ResponseEntity<List<CustomersDto>> getCustomersDetais() {
	    try {
	        List<CustomersDto>customersDtos=new ArrayList<>();
	        customersDtos=customersService.getCustomersDetails();
	        return new ResponseEntity<>(customersDtos, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	

}
