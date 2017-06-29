package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
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
            }else if("getBooksBySplite".equals(status)){
            	path=this.getBooksBySplite(request, response);
            }else if("getCategory".equals(status)){
            	path=this.getCategory(request, response);
            }else if("getAD".equals(status)){
            	path=this.getAD(request, response);
            }else if(" getHotBooks".equals(status)){
            	path=this.getHotBook(request, response);
            }
            
        }
        request.getRequestDispatcher(path).forward(request, response);

    }
   
    public String getAllBooks(HttpServletRequest request,HttpServletResponse response){ 	

    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("application/json; charset=utf-8");  
    	String msg="";
    	String url="/pages/index.html";
    	try{
    		List<Book> data=null;
    		data=ServiceFactory.getIBookServiceInstance().getAllBooks();
    		request.setAttribute("data", data);
    	}catch(Exception e){
    			e.printStackTrace();
    	}
    	request.setAttribute("url", url);	
		return "/pages/forward.jsp";

    }
    
    public String getBooksBySplite(HttpServletRequest request,HttpServletResponse response){ 	
    	int index = Integer.parseInt((String) request.getAttribute("index"));
    	int num=Integer.parseInt((String) request.getAttribute("num"));
    	
    	String msg="";
    	String url="/pages/index.html";
    	request.setAttribute("url", url);	
    	
		return "/pages/forward.jsp";
		
		
		
		
    }
    public String getCategory(HttpServletRequest request,HttpServletResponse response){ 	
    	String categoryName=(String) request.getAttribute("categoryName");
    	String msg="";
    	String url="/pages/index.html";
    	request.setAttribute("url", url);	
		return "/pages/forward.jsp";

    }
    public String getAD(HttpServletRequest request,HttpServletResponse response){ 	
    	
    	String msg="";
    	String url="/pages/index.html";
    	request.setAttribute("url", url);	
		return "/pages/forward.jsp";

    }
    public String getHotBook(HttpServletRequest request,HttpServletResponse response){ 	
    	String msg="";
    	String url="/pages/index.html";
    	request.setAttribute("url", url);	
		return "/pages/forward.jsp";

    }
  
}


