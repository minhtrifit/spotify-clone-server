package com.spotifyclone.api.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spotifyclone.api.services.JwtService;
import com.spotifyclone.api.services.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService; 
  
    @Autowired
    private UserService userDetailsService; 
  
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { 
        try {
            String authHeader = request.getHeader("Authorization"); 
            String token = null; 
            String username = null;

            if (authHeader != null && authHeader.startsWith("Bearer ")) { 
                token = authHeader.substring(7); 
                username = jwtService.extractUsername(token); 
            } 
    
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { 
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                
                if (jwtService.validateToken(token, userDetails)) {
                    System.out.print("Verify token successfully\n"); 
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
                    SecurityContextHolder.getContext().setAuthentication(authToken); 
                } 
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}\n", e);
        }
         
        filterChain.doFilter(request, response); 
    }
}
