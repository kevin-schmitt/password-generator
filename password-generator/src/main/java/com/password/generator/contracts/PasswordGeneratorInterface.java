package com.password.generator.contracts;

import java.util.ArrayList;

public interface PasswordGeneratorInterface {

	/**
	 * Generate multiple passwords
	 * @param length number of passwords
	 * @return Arraylist passwords generated
	 */
	ArrayList<String> passwordGenerator(int number);

	void setOption(String name, String value);

	void setLength(int length);

}