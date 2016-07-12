package com.jimmy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jim on 15-12-27.
 */
public class MyEncodingFilter implements Filter{

    String code = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("CODE");
        System.out.println("code==="+code);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(code);
        response.setCharacterEncoding(code);
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("-----encodeing filter结束了-----");
    }
}
