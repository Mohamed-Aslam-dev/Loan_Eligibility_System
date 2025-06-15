package com.loan_eligibility_system_gold_live;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

//@RestController
@Controller
@RequestMapping("/gold")
public class GoldLiveRateController {

	private static final String API_KEY = "goldapi-71kcsmbpigjgr-io";
    private static final String API_URL = "https://www.goldapi.io/api/XAU/INR";
    private static final double OUNCE_TO_GRAM = 31.1035;

    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("/live")
    public String getLiveGoldRates(Model model) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-access-token", API_KEY);
            headers.set("Content-Type", "application/json");
            headers.set("User-Agent", "Mozilla/5.0");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, Map.class);

            Map body = response.getBody();

            // API price is assumed per ounce, convert to per gram
            double pricePerOunce = ((Number) body.get("price")).doubleValue();
            double pricePerGram24K = pricePerOunce / OUNCE_TO_GRAM;

            Map<String, Double> karatRates = new LinkedHashMap<>();
            karatRates.put("24K", round(pricePerGram24K));
            karatRates.put("22K", round(pricePerGram24K * 0.916));
            karatRates.put("20K", round(pricePerGram24K * 0.833));
            karatRates.put("18K", round(pricePerGram24K * 0.75));
            karatRates.put("14K", round(pricePerGram24K * 0.585));
            karatRates.put("10K", round(pricePerGram24K * 0.416));

            
            model.addAttribute("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            model.addAttribute("location", "India");
            model.addAttribute("currency", "INR");
            model.addAttribute("rates", karatRates);

            return "goldRates";

        } catch (Exception e) {
            e.printStackTrace();

            Map<String, Object> error = new HashMap<>();
            error.put("error", "Failed to fetch live gold rate");
            error.put("message", e.getMessage());

            return null;
        }
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    
//    @GetMapping("/rates-ui")
//    public String goldRatesUI() {
//        return "goldRates"; // goldRates.jsp file under /WEB-INF/jsp/
//    }

}
