package com.kms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Currency {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;
	
	private int bankNoteOf_1;
	
	private int bankNoteOf_10;

	private int bankNoteOf_100;

	private int bankNoteOf_1000;

	private int bankNoteOf_5;

	private int bankNoteOf_50;

	private int bankNoteOf_500;

	private int bankNoteOf_5000;
	
	
	
	public Currency() {}

	
	public Currency(@Size(min = 3, max = 3) @NotBlank String name, int bankNoteOf_1, int bankNoteOf_10,
			int bankNoteOf_100, int bankNoteOf_1000, int bankNoteOf_5, int bankNoteOf_50, int bankNoteOf_500,
			int bankNoteOf_5000) {
		super();
		this.name = name;
		this.bankNoteOf_1 = bankNoteOf_1;
		this.bankNoteOf_10 = bankNoteOf_10;
		this.bankNoteOf_100 = bankNoteOf_100;
		this.bankNoteOf_1000 = bankNoteOf_1000;
		this.bankNoteOf_5 = bankNoteOf_5;
		this.bankNoteOf_50 = bankNoteOf_50;
		this.bankNoteOf_500 = bankNoteOf_500;
		this.bankNoteOf_5000 = bankNoteOf_5000;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBankNoteOf_1() {
		return bankNoteOf_1;
	}

	public void setBankNoteOf_1(int bankNoteOf_1) {
		this.bankNoteOf_1 = bankNoteOf_1;
	}

	public int getBankNoteOf_10() {
		return bankNoteOf_10;
	}

	public void setBankNoteOf_10(int bankNoteOf_10) {
		this.bankNoteOf_10 = bankNoteOf_10;
	}

	public int getBankNoteOf_100() {
		return bankNoteOf_100;
	}

	public void setBankNoteOf_100(int bankNoteOf_100) {
		this.bankNoteOf_100 = bankNoteOf_100;
	}

	public int getBankNoteOf_1000() {
		return bankNoteOf_1000;
	}

	public void setBankNoteOf_1000(int bankNoteOf_1000) {
		this.bankNoteOf_1000 = bankNoteOf_1000;
	}

	public int getBankNoteOf_5() {
		return bankNoteOf_5;
	}

	public void setBankNoteOf_5(int bankNoteOf_5) {
		this.bankNoteOf_5 = bankNoteOf_5;
	}

	public int getBankNoteOf_50() {
		return bankNoteOf_50;
	}

	public void setBankNoteOf_50(int bankNoteOf_50) {
		this.bankNoteOf_50 = bankNoteOf_50;
	}

	public int getBankNoteOf_500() {
		return bankNoteOf_500;
	}

	public void setBankNoteOf_500(int bankNoteOf_500) {
		this.bankNoteOf_500 = bankNoteOf_500;
	}

	public int getBankNoteOf_5000() {
		return bankNoteOf_5000;
	}

	public void setBankNoteOf_5000(int bankNoteOf_5000) {
		this.bankNoteOf_5000 = bankNoteOf_5000;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + name + ", bankNoteOf_1=" + bankNoteOf_1 + ", bankNoteOf_10="
				+ bankNoteOf_10 + ", bankNoteOf_100=" + bankNoteOf_100 + ", bankNoteOf_1000=" + bankNoteOf_1000
				+ ", bankNoteOf_5=" + bankNoteOf_5 + ", bankNoteOf_50=" + bankNoteOf_50 + ", bankNoteOf_500="
				+ bankNoteOf_500 + ", bankNoteOf_5000=" + bankNoteOf_5000 + "]";
	}

}
