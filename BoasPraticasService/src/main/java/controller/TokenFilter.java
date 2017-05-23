package controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			
		HttpServletRequest req = (HttpServletRequest) request;
		String header = req.getHeader("Authorization");
		
		if(header == null || header.startsWith("Bearer "))
			throw new ServletException("Token inexistente.");
		
		String token = header.substring(7);
		
		try{
			Jwts.parser().setSigningKey("manual").parseClaimsJws(token).getBody();
		}catch (SignatureException e) {
			throw new ServletException("Token inv�lido.");
		}
		
		chain.doFilter(request, response);
		
	}

}
