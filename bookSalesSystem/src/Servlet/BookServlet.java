package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import util.test.TestMD5Code;
import vo.Book;
import vo.Category;

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
		// request.getRequestDispatcher(path).forward(request, response);

	}

	public String getAllBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String msg = "";
		String url = "/pages/index.html";
		
		boolean flag = false;
		try {
			List<Book> data = null;
			data = ServiceFactory.getIBookServiceInstance().getAllBooks();
			
			String json = "{";
			for (Book book : data) {
				if (!flag) {
					json += "["
									+ "\"bid\" : " + "\"" + book.getBid() 
									+	"\"bookName\"" + "\"" + book.getBookName() 
									+	"\"price\"" + "\"" + book.getPrice() 
									+	"\"img\"" + "\"" + book.getImg() 
									+	"\"author\"" + "\"" + book.getAuthor() 
									+	"\"salesNumber\"" + "\"" + book.getSalesNumber()
									+	"\"score\"" + "\"" + book.getScore() 
									+	"\"abstract\"" + "\"" + book.get_abstract() 
									+	"\"surplus\"" + "\"" + book.getSurplus() 
									+	"\"categoryName\"" + "\"" + book.getCategoryName()+
								"]";
					flag = true;
				} else if (flag) {
					json += ",["
							+ "\"bid\" : " + "\"" + book.getBid() 
							+	"\"bookName\"" + "\"" + book.getBookName() 
							+	"\"price\"" + "\"" + book.getPrice() 
							+	"\"img\"" + "\"" + book.getImg() 
							+	"\"author\"" + "\"" + book.getAuthor() 
							+	"\"salesNumber\"" + "\"" + book.getSalesNumber()
							+	"\"score\"" + "\"" + book.getScore() 
							+	"\"abstract\"" + "\"" + book.get_abstract() 
							+	"\"surplus\"" + "\"" + book.getSurplus() 
							+	"\"categoryName\"" + "\"" + book.getCategoryName()+
						"]";
				}
			}
			flag = false;
			json += "}";
			// 输出数据
			System.out.println("json:" + json);
			out.print(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "";

	}

	public String getBooksBySplite(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int index = Integer.parseInt((String) request.getAttribute("index"));
		int num = Integer.parseInt((String) request.getAttribute("num"));
		
		String msg = "";
		String url = "/pages/index.html";
		
		boolean flag = false;
		try {
			List<Book> data = null;
			data = ServiceFactory.getIBookServiceInstance().getBooksBySplite(index,num);
			
			String json = "{";
			for (Book book : data) {
				if (!flag) {
					json += "["
									+ "\"bid\" : " + "\"" + book.getBid() 
									+	"\"bookName\"" + "\"" + book.getBookName() 
									+	"\"price\"" + "\"" + book.getPrice() 
									+	"\"img\"" + "\"" + book.getImg() 
									+	"\"author\"" + "\"" + book.getAuthor() 
									+	"\"salesNumber\"" + "\"" + book.getSalesNumber()
									+	"\"score\"" + "\"" + book.getScore() 
									+	"\"abstract\"" + "\"" + book.get_abstract() 
									+	"\"surplus\"" + "\"" + book.getSurplus() 
									+	"\"categoryName\"" + "\"" + book.getCategoryName()+
								"]";
					flag = true;
				} else if (flag) {
					json += ",["
							+ "\"bid\" : " + "\"" + book.getBid() 
							+	"\"bookName\"" + "\"" + book.getBookName() 
							+	"\"price\"" + "\"" + book.getPrice() 
							+	"\"img\"" + "\"" + book.getImg() 
							+	"\"author\"" + "\"" + book.getAuthor() 
							+	"\"salesNumber\"" + "\"" + book.getSalesNumber()
							+	"\"score\"" + "\"" + book.getScore() 
							+	"\"abstract\"" + "\"" + book.get_abstract() 
							+	"\"surplus\"" + "\"" + book.getSurplus() 
							+	"\"categoryName\"" + "\"" + book.getCategoryName()+
						"]";
				}
			}
			flag = false;
			json += "}";
			// 输出数据
			System.out.println("json:" + json);
			out.print(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "";

	}

	public String getCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean flag = false;

		String categoryName = (String) request.getAttribute("categoryName");
		String msg = "";
		String url = "";

		String json = "{";

		try {
			msg = "获取分类成功";
			url = "/pages/index.html";
			List<Category> data =null;
			data= ServiceFactory.getICategoryServiceInstance().getCategory();
			// 遍历数据
			for (Category category : data) {
				if (!flag) {
					json += "\"categoryName\" : " + "\"" + category.getCategoryName() + "\"";
					flag = true;
				} else if (flag) {
					json += "," + "\"categoryName\" : " + "\"" + category.getCategoryName() + "\"";
				}
			}
			flag = false;
			json += "}";
			// 输出数据
			System.out.println("json:" + json);
			out.print(json + new TestMD5Code().getMD5Code());

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "";

	}

	public String getAD(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean flag = false;

		String msg = "";
		String url = "";
		String json = "{";
		List<Book> data = null;
		try {
			msg = "获取广告";
			url = "/pages/index.html";
			data = ServiceFactory.getIBookServiceInstance().getAD();
			
			for (Book book : data) {
				if (!flag) {
					json += "\"categoryName\" : " + "\"" + book.getImg() + "\"";
					flag = true;
				} else if (flag) {
					json += "," + "\"categoryName\" : " + "\"" +  book.getImg()+ "\"";
				}
			}
			flag = false;
			json += "}";
			// 输出数据
			System.out.println("json:" + json);
			out.print(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "";

	}

	public String getHotBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String msg = "";
		String url = "/pages/index.html";
		
		boolean flag = false;
		try {
			List<Book> data = null;
			data = ServiceFactory.getIBookServiceInstance().getHotBook();
			
			String json = "{";
			for (Book book : data) {
				if (!flag) {
					json += "["
									+ "\"bid\" : " + "\"" + book.getBid() 
									+	"\"bookName\"" + "\"" + book.getBookName() 
									+	"\"price\"" + "\"" + book.getPrice() 
									+	"\"img\"" + "\"" + book.getImg() 
									+	"\"abstract\"" + "\"" + book.get_abstract() +
								"]";
					flag = true;
				} else if (flag) {
					json += ",["
							+ "\"bid\" : " + "\"" + book.getBid() 
							+	"\"bookName\"" + "\"" + book.getBookName() 
							+	"\"price\"" + "\"" + book.getPrice() 
							+	"\"img\"" + "\"" + book.getImg() 
							+	"\"abstract\"" + "\"" + book.get_abstract() +
						"]";
				}
			}
			flag = false;
			json += "}";
			// 输出数据
			System.out.println("json:" + json);
			out.print(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "";

	}

}
