package com.kms.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kms.entities.Currency;
import com.kms.repositories.CurrencyRepository;

@Service
public class ATMMachineUtils {

	@Autowired
	private CurrencyRepository currencyRepository;

	public boolean addNotes(String currencyName, int value, int number) {

			if (validateValues(value, number)) {

				if (!currencyRepository.existsByName(currencyName)) {
					System.out.println("Here");
					Currency currency = new Currency();
					currency.setName(currencyName);
					updateDB(currency, value, number);
					currencyRepository.save(currency);
					System.out.println(currency);

				}else {
				
					System.out.println("Here");
					Currency currency = currencyRepository.findByName(currencyName);
					updateDB(currency, value, number);
					currencyRepository.save(currency);
					System.out.println(currency);


				}

			}

		return false;

	}

	private boolean validateValues(int value, int number) {

		if (number > 0 && number % 1 == 0) {

			for (int n = 0; n <= 3; n++) {

				if (Math.pow(10, n) == value || Math.pow(50, n) == value) {
					return true;
				}

			}
		}
		return false;
	}

	private void updateDB(Currency currency, int value, int number) {

		if (value == 1) {
			currency.setBankNoteOf_1(number);
		} else if (value == 10) {
			currency.setBankNoteOf_10(number);
		} else if (value == 100) {
			currency.setBankNoteOf_100(number);
		} else if (value == 1000) {
			currency.setBankNoteOf_100(number);
		} else if (value == 5) {
			currency.setBankNoteOf_5(number);
		} else if (value == 50) {
			currency.setBankNoteOf_50(number);
		} else if (value == 500) {
			currency.setBankNoteOf_500(number);
		} else {
			currency.setBankNoteOf_5000(number);
		}

	}

}
