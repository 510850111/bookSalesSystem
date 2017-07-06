package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import vo.Book;

import java.io.IOException;
import java.io.PrintWriter;
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
			if ("getAllBooks".equals(status)) {
				path = this.getAllBooks(request, response);
			} else if ("getBooksBySplite".equals(status)) {
				path = this.getBooksBySplite(request, response);
			} else if ("getCategory".equals(status)) {
				path = this.getCategory(request, response);
			} else if ("getAD".equals(status)) {
				path = this.getAD(request, response);
			} else if (" getHotBooks".equals(status)) {
				path = this.getHotBook(request, response);
			}

		}
//		request.getRequestDispatcher(path).forward(request, response);

	}

	public String getAllBooks(HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		String msg = "";
		String url = "/pages/index.html";
		try {
			List<Book> data = null;
			data = ServiceFactory.getIBookServiceInstance().getAllBooks();
			request.setAttribute("data", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "/pages/forward.jsp";

	}

	public String getBooksBySplite(HttpServletRequest request, HttpServletResponse response) {
		String msg="";
		String url="";
		int index = Integer.parseInt((String) request.getAttribute("index"));
		int num = Integer.parseInt((String) request.getAttribute("num"));
		List<Book> data = null;

		try {		
			data = ServiceFactory.getIBookServiceInstance().getBooksBySplite(index, num);
			msg = "查询成功";
			url = "/pages/index.html";
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/pages/forward.jsp";

	}

	public String getCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
		String categoryName = (String) request.getAttribute("categoryName");
		String msg = "";
		String url = "";
		PrintWriter out = response.getWriter();
		List<Book> data=null;
		try{
			msg="获取分类成功";
			url = "/pages/index.html";
//			data= ServiceFactory.getIBookServiceInstance().getCategory(categoryName);
			String json = "{\"id\":1,\"name\":\"张三\",\"age\":18}";
			out.print(json);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("url", url);
//		return "/pages/forward.jsp";
		return "";

	}

	public String getAD(HttpServletRequest request, HttpServletResponse response) {

		String msg = "";
		String url = "";
		List<Book> data =null;
		try{
			msg="获取广告";
			url = "/pages/index.html";
			data=ServiceFactory.getIBookServiceInstance().getAD();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "/pages/forward.jsp";

	}

	public String getHotBook(HttpServletRequest request, HttpServletResponse response) {
		String msg = "";
		String url = "";
		List<Book> data=null;
		try{
			msg = "请求热门书籍成功";
			url = "/pages/index.html";
			data=ServiceFactory.getIBookServiceInstance().getHotBook();
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "/pages/forward.jsp";

	}

}
