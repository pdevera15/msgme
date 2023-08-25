package com.ccy.msgme;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class SecurityFilter implements Filter{

    private final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);
    
    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("Filter started");
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        logger.info("Request took " + elapsedTime + "ms to process");
    }
    
    @Override
    public void destroy() {
        System.out.println("Filter Destroy");
    }
}
