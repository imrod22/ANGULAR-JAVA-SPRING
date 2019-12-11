package ttps.spring.helpers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import ttps.spring.services.TokenService;

/**
 * Servlet Filter implementation class JWTAuthenticationFilter
 */
@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "*")
public class JWTAuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public JWTAuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		 if ("/ttps-spring/login".equals(req.getRequestURI()) || "/ttps-spring/registrar".equals(req.getRequestURI()) || HttpMethod.OPTIONS.matches(req.getMethod())) {
			 	chain.doFilter(request, response);
			 	return;
		 }
		 
		 String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		 
		 if (token == null || !TokenService.validateToken(token)) {
			 HttpServletResponse res = (HttpServletResponse) response;
			 res.setStatus(HttpStatus.FORBIDDEN.value());
			 return;
		 }
		 
		 chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
