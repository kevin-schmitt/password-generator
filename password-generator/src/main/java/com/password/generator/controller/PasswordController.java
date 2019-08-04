package com.password.generator.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.password.generator.contracts.PasswordGeneratorInterface;
import com.password.generator.service.ComputerPasswordGenerator;

@RestController
@RequestMapping(value = "/passwords")
public class PasswordController {
    
	@GetMapping(value="/length={length:[\\d]+}&number={number:[\\d]+}")
    public ResponseEntity<ArrayList<String>> passwords(@PathVariable(required = false) int length, @PathVariable(required = false) int number) 
    {
       return new ResponseEntity<ArrayList<String>>(getPasswords(length, number), HttpStatus.ACCEPTED);
    }
    
    private ArrayList<String> getPasswords(int length, int number)
    {
    	PasswordGeneratorInterface passwordGenerator = new ComputerPasswordGenerator();
    	passwordGenerator.setLength(length);
		return passwordGenerator.passwordGenerator(number);
    	
    }
    
}