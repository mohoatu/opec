package org.opec.xnk.service;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
	private  HashMap<String,String> tokens = new HashMap<String, String>();
	
	public String check(String token) {
		return tokens.get(token);
	}
	
	public String generate() {
		String uid = UUID.randomUUID().toString();
		tokens.put(uid, uid);
		return uid;
	}
	
	public void remove(String token) {
		tokens.remove(token);
	}
}
