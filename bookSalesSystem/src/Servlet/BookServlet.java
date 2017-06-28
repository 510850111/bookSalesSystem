package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Book;

import java.io.IOException;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet(name = "BookServlet", urlPatterns = "/pages/BookServlet/*")
public class BookServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        if (status != null) {
            System.out.println("status = " + status);
            if("getAllBooks".equals(status)){
            	path = this.getAllBooks(request,response);
            }
            
        }
        request.getRequestDispatcher(path).forward(request, response);

    }
    
    public String getAllBooks(HttpServletRequest request,HttpServletResponse response){
    	Book vo = new Book();
    	vo.setBid(1);
    	vo.setBookName("bookName");
    	vo.setPrice(34);
    	vo.setImg("../img/1.jpg");
    	vo.setAuthor("鲁迅");
    	vo.setSalesNumber(100);
    	vo.setScore("9.9");
    	vo.set_abstract("自传");
    	vo.setDetail("就是自传");
    	vo.setSurplus(2);
    	vo.setCategoryName("都市");
    	
    	request.setAttribute("bid", vo.getBid());
    	request.setAttribute("bookName", vo.getBookName());
    	request.setAttribute("price", vo.getPrice());
    	request.setAttribute("img", vo.getImg());
    	request.setAttribute("author", vo.getAuthor());
    	request.setAttribute("salesNumber", vo.getSalesNumber());
    	request.setAttribute("score", vo.getScore());
    	request.setAttribute("_abstract", vo.get_abstract());
    	request.setAttribute("detail", vo.getDetail());
    	request.setAttribute("surplus", vo.getSurplus());
    	request.setAttribute("categoryName", vo.getCategoryName());
    	
    	String msg="";
    	String url="/pages/index.html";
    	
    	request.setAttribute("url", url);
    
    	
		return "/pages/forward.jsp";
    	
    }
    
    

   
}


