package com.javarush.thekillersmod3servlets;

import jakarta.servlet.*;

import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.printf("Logging Filter Init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request received: " + request.getRemoteAddr());

        chain.doFilter(request, response);

        System.out.println("Response send");
    }

    @Override
    public void destroy() {
        System.out.println("Logging Filter Destroy");
    }
}
