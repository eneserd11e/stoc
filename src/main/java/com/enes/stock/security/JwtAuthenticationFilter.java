package com.enes.stock.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.enes.stock.service.UserDetailsServiceImpl;



public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwtToken = extractJwtFromRequest(request);
			if(StringUtils.hasText(jwtToken) && jwtTokenProvider.validateToken(jwtToken)) {
				Long id = jwtTokenProvider.getUserIDFromJwt(jwtToken);
				UserDetails user = userDetailsService.loadUserById(id);
				if(user != null) {
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(auth);//security ile alaka bilgileri tutan local storage gibi düşünülebilir.
					//bir local thread yaratıyor ve bu user için gerekli bilgileri içerisinde tutuyor. service erişebilcek
				}
			}
		}catch (Exception e) {
			return;
		}
		filterChain.doFilter(request, response);//yukarıda kendi filterımızı yaptık. burada ise spring kendi filteresine devam etmesini söylüyoruz.
		
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearer = request.getHeader("Authorization");
		if(StringUtils.hasText(bearer) && bearer.startsWith("Bearer "))
			return bearer.substring("Bearer".length()+1);
		return null;
	}

}
