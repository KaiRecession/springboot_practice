//package top.kairecession.demo01.controller;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import org.springframework.core.annotation.Order;
//
//@WebFilter(
//        filterName = "codsaf",
//        urlPatterns = {"/*"}
//)
//@Order(1)
//public class Filter_test01 implements Filter {
//    public Filter_test01() {
//    }
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("初始化！！");
//        Filter.super.init(filterConfig);
//    }
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("拦截到了！！");
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
