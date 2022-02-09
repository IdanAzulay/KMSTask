package com.kms.services;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kms.entities.Currency;
import com.kms.repositories.CurrencyRepository;

@Service
public class ATMCommandsImpl implements ATMCommands {

	private static final String CURRENCY_PATTERN = ".*[A-Z].*";

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private Logger logger;

	@Override
	public void printCash() {

		List<Currency> currencies = currencyRepository.findAll();
		for (Currency currency : currencies) {
			if (currency.getBankNoteOf_1() > 0) {
				logger.info("\033[3m " + currency.getName() + " 1 " + currency.getBankNoteOf_1() + " \033[0m");
			}
			if (currency.getBankNoteOf_10() > 0) {
				logger.info("\033[3m " + currency.getName() + " 10 " + currency.getBankNoteOf_10() + " \033[0m");
			}
			if (currency.getBankNoteOf_100() > 0) {
				logger.info("\033[3m " + currency.getName() + " 100 " + currency.getBankNoteOf_100() + " \033[0m");
			}
			if (currency.getBankNoteOf_1000() > 0) {
				logger.info("\033[3m " + currency.getName() + " 1000 " + currency.getBankNoteOf_1000() + " \033[0m");
			}
			if (currency.getBankNoteOf_5() > 0) {
				logger.info("\033[3m " + currency.getName() + " 5 " + currency.getBankNoteOf_5() + " \033[0m");
			}
			if (currency.getBankNoteOf_50() > 0) {
				logger.info("\033[3m " + currency.getName() + " 50 " + currency.getBankNoteOf_50() + " \033[0m");
			}
			if (currency.getBankNoteOf_500() > 0) {
				logger.info("\033[3m " + currency.getName() + " 500 " + currency.getBankNoteOf_500() + " \033[0m");
			}
			if (currency.getBankNoteOf_5000() > 0) {
				logger.info("\033[3m " + currency.getName() + " 5000 " + currency.getBankNoteOf_5000() + " \033[0m");
			}
		}
		logger.info("\033[3m OK \033[0m");

	}

	@Override
	public String addNotes(String currencyName, int value, int number) {

		if (currencyName.length() != 3 || Pattern.compile(CURRENCY_PATTERN).matcher(currencyName).matches()) {
			logger.info("ERROR");

		}

		if (validateValues(value, number)) {

			if (!currencyRepository.existsByName(currencyName)) {
				Currency currency = new Currency();
				currency.setName(currencyName);
				updateDB(currency, value, number);
				currencyRepository.save(currency);
				logger.info("OK");
			} else {

				Currency currency = currencyRepository.findByName(currencyName);
				updateDB(currency, value, number);
				currencyRepository.save(currency);
				logger.info("OK");

			}

			return "OK";
		}

		return "error";

	}

	@Override
	public String getCash(String currency, int amount) {
		// TODO Auto-generated method stub
		return null;
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
			currency.setBankNoteOf_1(currency.getBankNoteOf_1() + number);
		} else if (value == 10) {
			currency.setBankNoteOf_10(currency.getBankNoteOf_10() + number);
		} else if (value == 100) {
			currency.setBankNoteOf_100(currency.getBankNoteOf_100() + number);
		} else if (value == 1000) {
			currency.setBankNoteOf_1000(currency.getBankNoteOf_1000() + number);
		} else if (value == 5) {
			currency.setBankNoteOf_5(currency.getBankNoteOf_5() + number);
		} else if (value == 50) {
			currency.setBankNoteOf_50(currency.getBankNoteOf_50() + number);
		} else if (value == 500) {
			currency.setBankNoteOf_500(currency.getBankNoteOf_500() + number);
		} else {
			currency.setBankNoteOf_5000(currency.getBankNoteOf_5000() + number);
		}

	}

}
