package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class calcBB {
	private String currency1;
	private String currency2;
	private String value;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getCurrency1() {
		return currency1;
	}

	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}

	public String getCurrency2() {
		return currency2;
	}

	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public void calc() {
		try {
			double value = Double.parseDouble(this.value);
			
			if (currency1.equals("PLN")) {
				if (currency2.equals("PLN")) {
					result = value;
				} else if (currency2.equals("EUR")) {
					result = value / 4.57;
				} else {
					result = value / 3.88;
				}
			}

			if (currency1.equals("EUR")) {
				if (currency2.equals("PLN")) {
					result = value * 4.57;
				} else if (currency2.equals("EUR")) {
					result = value;
				} else {
					result = value * 1.18;
				}
			}

			if (currency1.equals("USD")) {
				if (currency2.equals("PLN")) {
					result = value * 3.88;
				} else if (currency2.equals("EUR")) {
					result = value / 1.18;
				} else {
					result = value;
				}
			}
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));


		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d podczas przetwarzania parametrów", null));

		}
	}

}
