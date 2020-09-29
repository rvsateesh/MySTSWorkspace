package com.wellsfargo.fsd.JavaWeb3.filter;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ExecTimeFilter
 */
@WebFilter("/*")
public class ExecTimeFilter implements Filter {

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
		LocalTime startTime = LocalTime.now();
		chain.doFilter(request, response);
		LocalTime endTime = LocalTime.now();
		
		Duration d = Duration.between(startTime, endTime);
		System.out.println("Response Time is: " + d.toMillis() + "ms ");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
