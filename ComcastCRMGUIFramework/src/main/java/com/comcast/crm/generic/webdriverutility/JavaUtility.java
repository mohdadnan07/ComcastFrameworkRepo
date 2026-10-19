package com.comcast.crm.generic.webdriverutility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int randInt = random.nextInt(1000);
		return randInt;
	}

}
