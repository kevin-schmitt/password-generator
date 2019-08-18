package com.password.generator.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;

import com.password.generator.contracts.PasswordGeneratorInterface;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PasswordRestTest {
	
	@MockBean
	PasswordGeneratorInterface passwordService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void should_gets_passwords() throws Exception  {
		
			int length = 8;
			int number = 4;
            this.mockMvc.perform(get("/passwords/length={length}&number={number}", length, number))
	                .andExpect(status().isOk())
			        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			        .andExpect(jsonPath("$", hasSize(number)));
		
	}

}
