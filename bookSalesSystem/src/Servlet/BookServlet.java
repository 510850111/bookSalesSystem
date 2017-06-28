package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Book;

import java.io.IOException;
import java.util.*;

<<<<<<< HEAD
@WebServlet(name = "BookServlet", urlPatterns = "*")
=======
@SuppressWarnings("serial")
@WebServlet(name = "BookServlet", urlPatterns = "/pages/BookServlet/*")
>>>>>>> a121398e74acc65ad9c3de790276a9a6e4ce40c7
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
<<<<<<< HEAD
    	String url="";
=======
    	String url="/pages/index.html";
    	
    	request.setAttribute("url", url);
>>>>>>> a121398e74acc65ad9c3de790276a9a6e4ce40c7
    
    	
		return "/pages/forward.jsp";
    	
    }
    
    

   
}


<<<<<<< HEAD
/*
 * 
 * url : "localhost : 8080/pages/BookServlet/getAllBooks"
 * 
 * */


=======
>>>>>>> a121398e74acc65ad9c3de790276a9a6e4ce40c7
