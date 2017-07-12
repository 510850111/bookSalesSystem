package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "LoginFilter",urlPatterns = {"login.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(); // 取得session接口对象
        if (session.getAttribute("uid") != null){ // 表示有内容存在
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            request.setAttribute("msg","你还未登录，请先登录后操作!");
            request.setAttribute("url","/login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

