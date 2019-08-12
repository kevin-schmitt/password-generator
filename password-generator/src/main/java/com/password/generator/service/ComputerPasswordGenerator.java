package com.password.generator.service;


import org.springframework.stereotype.Service;

import com.password.generator.contracts.PasswordGeneratorAbstract;

@Service
public class ComputerPasswordGenerator extends PasswordGeneratorAbstract {
	
	private int length;

	/**
	 * Constructor
	 */
	public ComputerPasswordGenerator() {
		this.setOption("LOWER_CASE", PasswordGeneratorAbstract.LOWER_CASE);
	}
	
	public String getCharacterList() {
		String password = "";
		
		if(this.isOption("LOWER_CASE"))
			password += PasswordGeneratorAbstract.LOWER_CASE;
		
		return password;
	}

	
	@Override
	protected String passwordGenerator() {
		String password = "";
		String characterList = getCharacterList();
		int length = characterList.length();
		
		for(int i = 0; i < this.getLength(); i++)
		{
			password += characterList.charAt(random(0,length));
		}
		return password;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
