package com.basic.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemcachedSessionFilter implements Filter {


FilterConfig filterConfig;

public void destroy() {

}

public void doFilter(ServletRequest servletRequest,
        ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    if (!(request instanceof HttpServletRequestMemcacheWrapper)) {
        request = new HttpServletRequestMemcacheWrapper(request, response,
                filterConfig);
    }
    filterChain.doFilter(request, response);

}

public void init(FilterConfig arg0) throws ServletException {
    this.filterConfig = arg0;
}
}