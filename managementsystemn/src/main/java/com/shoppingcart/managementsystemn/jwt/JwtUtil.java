package com.shoppingcart.managementsystemn.jwt;


import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.shoppingcart.managementsystemn.service.CustomUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private String key;
	
	
	public JwtUtil() throws NoSuchAlgorithmException {
		
		KeyGenerator generator = KeyGenerator.getInstance("HmacSHA256");
		SecretKey secretKey =  generator.generateKey();
		this.key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
		
	}
	
	
	public String generateToken(String username) {
		Map<String,Object> claims =  new HashMap();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration((new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)))
				.and()
				.signWith(generateKey())
				.compact();
				
	}

		private  SecretKey generateKey() {
			byte[] bytes = Decoders.BASE64.decode(key);
			return Keys.hmacShaKeyFor(bytes);
		
		
	     }
		
		 public Boolean validateToken(String token, UserDetails userDetails) {
		        final String username = extractUsername(token);
		        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
		    }
		    
		    public String extractUsername(String token) {
		        return extractClaim(token, Claims::getSubject);
		    }
		    
		    public Date extractExpiration(String token) {
		        return extractClaim(token, Claims::getExpiration);
		    }
		    
		    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		        final Claims claims = extractAllClaims(token);
		        return claimsResolver.apply(claims);
		    }
		    
		    private Claims extractAllClaims(String token) {
		        return Jwts.parser()
		                .verifyWith(generateKey())
		                .build()
		                .parseSignedClaims(token)
		                .getPayload();
		    }
		    
		    private Boolean isTokenExpired(String token) {
		        return extractExpiration(token).before(new Date());
		    }

}
