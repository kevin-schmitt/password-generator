package com.password.generator.contracts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class PasswordGeneratorAbstract implements PasswordGeneratorInterface {

		protected int defaultSizePassword = 8;
		
		protected static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
		protected static final String UPPER_CASE = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
		
		
		protected Map<String, String> options = new HashMap();
		private static final Random RANDOM = new Random();


		/**
		 * Generate multiple passwords
		 * @param length number of passwords
		 * @return Arraylist passwords generated
		 */
		@Override
		public ArrayList<String> passwordGenerator(int number) {

			ArrayList<String> tmp = new ArrayList<String>();
			
			for(int i = 0; i <= number - 1; i++) {
				tmp.add(passwordGenerator());
			}
			
			return tmp;
			
		}
		
		protected int random(int min, int max) {
			return RANDOM.nextInt(max) + min;
			
		}

	   @Override
	public void setOption(String name, String value)
       {  
		    this.options.put(name, value);
       }
	   
	   protected  boolean isOption(String name) {
			return this.options.get(name) != null;
			
	   }
	   
	   protected abstract String passwordGenerator();

	   @Override
	public abstract void setLength(int length);
}
