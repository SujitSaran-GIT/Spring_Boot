package com.social.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtProvider {

	private static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
	public static String generateToken(Authentication auth) {
	    String jwt = Jwts.builder()
	            .setIssuer("SUJIT SARAN")
	            .setIssuedAt(new Date())
	            .setExpiration(new Date(new Date().getTime() +86400000)) // 1 day expiry
	            .claim("email", auth.getName())
	            .signWith(key)
	            .compact();
	    return jwt; // Return the generated token
	}
	
	public static String getEmailFromJwtToken(String jwt) {
		// Bearer token
		// Remove "Bearer " prefix safely
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        }
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		
		String email = String.valueOf(claims.get("email"));
		
		return email;
	}
}
