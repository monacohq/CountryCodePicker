package com.sithagi.countrycodepicker;

import java.text.Normalizer;
import java.util.Locale;

public class Country {
	private String code;
	private String name;
	private String dialCode;
	private String currency;
	private String currencySymbol;
	private String flagDrawableName;

	public String getDialCode() {
		return dialCode;
	}

	public void setDialCode(String dialCode) {
		this.dialCode = dialCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getFlagDrawableName(){
		String drawableName = this.getName().toLowerCase(Locale.ENGLISH).replace(" ", "_");
		drawableName = Normalizer.normalize(drawableName, Normalizer.Form.NFD);
		drawableName = drawableName.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		drawableName = drawableName.replaceAll("[-\\[\\]^/,'’*:.!><~@#$%&+=?|\"\\\\()]+","");
		return drawableName;
	}
}