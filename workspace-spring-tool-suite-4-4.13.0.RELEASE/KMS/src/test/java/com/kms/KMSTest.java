package com.kms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kms.services.ATMCommandsImpl;

@SpringBootTest
class KMSTest {

	@Autowired
	private ATMCommandsImpl atmCommandsImpl;
	
	
	@Test
	void test() {
		
		atmCommandsImpl.addNotes("asd", 1000, 30);
		atmCommandsImpl.addNotes("USD", 50, 30);
		atmCommandsImpl.addNotes("asd", 10, 30);
		atmCommandsImpl.addNotes("USD", 1000, 30);
		atmCommandsImpl.printCash();

	}

}
