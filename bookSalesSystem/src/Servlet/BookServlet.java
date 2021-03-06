﻿package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import net.sf.json.JSONArray;
import util.test.TestMD5Code;
import vo.Book;
import vo.Category;

import java.io.Console;
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
			} else if ("getHotBooks".equals(status)) {
				path = this.getHotBook(request, response);
			} else if("insertBook".equals(status)){
				this.insertBook(request, response);
			}

		}
		// request.getRequestDispatcher(path).forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("bookName");
		String price = request.getParameter("price");
		String counts = request.getParameter("counts");
		String author = request.getParameter("author");
		
		Book book = new Book();
		book.setBookName(bookName);
		book.setPrice(Integer.parseInt(price));
		book.setSurplus(Integer.parseInt(counts));
		book.setAuthor(author);
		boolean flag = false;
		
		try {
			flag = ServiceFactory.getIBookServiceInstance().insertBook(book);
			if (flag) {
				out.print("[{\"status\" : true}]");
			}else {
				out.print("[{\"status\" : false}]");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
		
	}

	public String getAllBooks(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();

		String msg = "";
		String url = "/pages/index.html";

		try {
			List<Book> data;
			data = ServiceFactory.getIBookServiceInstance().getAllBooks();
			JSONArray jsonArray = JSONArray.fromObject(data);
			System.out.println("getAllBooks:" + jsonArray);
			// 输出数据
			out.print(jsonArray);

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
			data = ServiceFactory.getIBookServiceInstance().getBooksBySplite(index, num);
			JSONArray jsonArray = JSONArray.fromObject(data);
			// 输出数据
			out.print(jsonArray);

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

		String msg = "";
		String url = "";

		try {
			msg = "获取分类成功";
			url = "/pages/index.html";
			List<Category> data;
			data = ServiceFactory.getICategoryServiceInstance().getCategory();
			JSONArray jsonArray = JSONArray.fromObject(data);
			System.out.println("getCategory:" + jsonArray);
			// 输出数据
			out.print(jsonArray);

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
			JSONArray jsonArray = JSONArray.fromObject(data);
			System.out.println("getAD:" + jsonArray);
			// 输出数据
			out.print(jsonArray);

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
			JSONArray jsonArray = JSONArray.fromObject(data);
			System.out.println("getHotBook:" + jsonArray);
			out.print(jsonArray);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("url", url);
		return "";

	}
	public List<Book> getbookDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Book> data=null;
		int bid=0;
		bid=(int) request.getAttribute("bid");
		data=ServiceFactory.getIBookServiceInstance().getbookDetails(bid);
		return null;
	}

}
