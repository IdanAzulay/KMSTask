package com.kms.services;

public interface ATMCommands {
	
	void printCash();
	
	String addNotes(String currency , int value , int number);
	
	String getCash(String currency , int amount);

}
