package me.hekuan.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 实现所有路径的过滤
 */
@WebFilter(filterName = "EncodingFilter" ,urlPatterns = "/*")
/**
 * Created by Oscar on 2017/5/26.
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);//放行
        servletResponse.setCharacterEncoding("UTF-8");;

    }

    @Override
    public void destroy() {

    }
}
