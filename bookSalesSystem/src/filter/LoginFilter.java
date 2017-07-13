package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.BookDaoImpl;
import factory.ServiceFactory;

import java.io.IOException;
import java.sql.SQLException;
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/pages/shop/Admin/booklist.html","/pages/shop/Admin/AddBook.html"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Boolean flag = false;
        HttpSession session = request.getSession(); // 取得session接口对象
        try {
			flag = ServiceFactory.getIUserServiceInstance().isAdmin((String) session.getAttribute("userName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (flag ){ // 表示有内容存在
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            request.setAttribute("msg","你还未登录，请先登录后操作!");
            request.setAttribute("url","/login.jsp");
//            request.getRequestDispatcher("/pages/shop/login.html").forward(servletRequest,servletResponse);
            response.sendRedirect("/bookSalesSystem/pages/shop/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}

