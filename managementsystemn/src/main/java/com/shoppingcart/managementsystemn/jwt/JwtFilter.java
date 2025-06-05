package com.shoppingcart.managementsystemn.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.shoppingcart.managementsystemn.service.CustomUserDetailService;

public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
	CustomUserDetailService userDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String header =  request.getHeader("Authorization");
		
		String token =  null;
		String username = null;
		if(header != null && header.startsWith("Bearer ")) {
		 token =  header.substring(7);
		 username = jwtUtil.extractUsername(token);
		}
		
		if(username != null) {
			
			UserDetails userDetails =  userDetailService.loadUserByUsername(username);
			
			if(jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authentication =  new
						         UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				//we have to set the details of request in to the authentication object 
	    		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	    		SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		filterChain.doFilter(request, response);
	}

}
