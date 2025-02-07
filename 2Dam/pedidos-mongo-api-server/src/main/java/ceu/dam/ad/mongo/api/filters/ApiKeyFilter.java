package ceu.dam.ad.mongo.api.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ApiKeyFilter extends OncePerRequestFilter{
	
	@Value("${api.key}")
	private String apiKey;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String apiKeyReq = request.getHeader("API-KEY");
		String path = request.getRequestURI();
		if (path.startsWith("/docs") || path.startsWith("/swagger") || apiKey.equals(apiKeyReq)) {
			filterChain.doFilter(request, response);
		} else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write("ApiKey incorrecta, no eres bienvenido.");
		}
	}

}
