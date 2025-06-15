package com.loan_eligibility_system_email_verification;

import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheOTPService {
	
//	 private static final int EXPIRE_MIN = 5;
//
//	    @Autowired
//	    private CacheManager cacheManager;
//
//	    public String generateOTP(String email) {
//	        String otp = String.format("%06d", new SecureRandom().nextInt(999999));
//	        Cache cache = cacheManager.getCache("otpCache");
//	        cache.put(email, otp); // stored in Redis
//	        return otp;
//	    }
//
//	    public boolean verifyOTP(String email, String userInputOtp) {
//	        Cache cache = cacheManager.getCache("otpCache");
//	        String storedOtp = cache.get(email, String.class);
//	        return storedOtp != null && storedOtp.equals(userInputOtp);
//	    }
//
//	    public void clearOTP(String email) {
//	        cacheManager.getCache("otpCache").evict(email);
//	    }
	
	private static final Map<String, OTPDetails> otpCache = new ConcurrentHashMap<>();
    private static final long EXPIRATION_TIME = 5 * 60 * 1000; // 5 minutes in milliseconds

    public String generateOTP(String email) {
        String otp = String.valueOf(100000 + new SecureRandom().nextInt(900000));
        long currentTime = System.currentTimeMillis();
        otpCache.put(email, new OTPDetails(otp, currentTime));
        return otp;
    }

    public boolean validateOTP(String email, String userInputOtp) {
        OTPDetails details = otpCache.get(email);

        if (details == null) return false;

        long currentTime = System.currentTimeMillis();
        boolean isExpired = (currentTime - details.getTimestamp()) > EXPIRATION_TIME;

        if (isExpired) {
            otpCache.remove(email); // clear expired entry
            return false;
        }

        return details.getOtp().equals(userInputOtp);
    }

}
