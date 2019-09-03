//package com.cashregister.controller.filter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class LocaleFilter implements Filter {
//
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        final HttpServletRequest request = (HttpServletRequest) servletRequest;
//        final HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        String path = request.getRequestURI();
//
//        path = path.replaceAll("language/", "");
//
//        if (path.equals("/views//")) {
//            path = "/";
//        }
//
//        String language = request.getParameter("language");
//
//        boolean isEnglish = language.equals("en");
//        boolean isUkrainian = language.equals("ua");
//
//
//        if (isEnglish) {
//            request.getSession().setAttribute("language", "en");
//        } else if (isUkrainian) {
//            request.getSession().setAttribute("language", "ua");
//        }
//
//        response.sendRedirect(path);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
//
