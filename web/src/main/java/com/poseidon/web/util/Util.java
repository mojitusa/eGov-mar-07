package com.poseidon.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class Util {
	
	public HttpServletRequest req() {
		  // 리턴 타입
		ServletRequestAttributes sra = 
				(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		
		return request;
	}
	
	public HttpSession getSession() {
		HttpSession session = req().getSession();
		
		return session;
	}
	
	
	
	//ip
    public String getIP() {
    	HttpServletRequest request = req();
        String ip = request.getHeader("X-FORWARDED-FOR");
        if(ip == null) {
           ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null) {
           ip = request.getHeader("WL-Proxy-Client-IP");   
        }
        if(ip == null) {
           ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip == null) {
           ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip == null) {
           ip = request.getRemoteAddr();
        }
        return ip;
     }

	public int str2Int(String inputstr) {
		
		int result = 0;
		String res;
		
		
		if (!(inputstr == null)) {
			res = extractNumber(inputstr);
			
			if (!(res.equals(""))) {
				result = Integer.parseInt(res);
			}
		}
		
		return result;
	}
	
	private String extractNumber(String str) {
		
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(str);
		
		StringBuilder result = new StringBuilder();
		while (matcher.find()) {
			result.append(matcher.group());
			
		}
		
		return result.toString();
	}
    
}
