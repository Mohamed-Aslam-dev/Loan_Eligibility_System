package com.loan_eligibility_system_gold_live;

import java.util.Map;

public class GoldRateResponse {

   	    private String timestamp;
	    private String location;
	    private String currency;
	    private Map<String, Double> rates;
	    
	    public GoldRateResponse() {
			// TODO Auto-generated constructor stub
		}

		public GoldRateResponse(String timestamp, String location, String currency, Map<String, Double> rates) {
			super();
			this.timestamp = timestamp;
			this.location = location;
			this.currency = currency;
			this.rates = rates;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public Map<String, Double> getRates() {
			return rates;
		}

		public void setRates(Map<String, Double> rates) {
			this.rates = rates;
		}

		@Override
		public String toString() {
			return "GoldRateResponse [timestamp=" + timestamp + ", location=" + location + ", currency=" + currency
					+ ", rates=" + rates + "]";
		}
	    
	    
	    
}
