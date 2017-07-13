package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import net.sf.json.JSONArray;
import vo.Book;
import vo.User;

@WebServlet(name = "UserServlet", urlPatterns = "/pages/UserServlet/*")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/pages/errors.jsp"; // 定义错误页面
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		System.out.println("status = " + status);
		if (status != null) {
			if ("login".equals(status)) {
				path = this.login(request, response);
			} else if ("logout".equals(status)) {
				path = this.logout(request, response);
			} else if ("register".equals(status)) {
				path = this.register(request, response);
			} else if ("validMessage".equals(status)) {
				path = this.validMessage(request, response);
			} else if ("changePassword".equals(status)) {
				path = this.changePassword(request, response);
			}
		}
		// request.getRequestDispatcher(path).forward(request, response);
	}

	private String changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String userName = "";
		String oldPassword = "";
		String newPassword = "";
		String msg = "";
		String url = "";

		// 先验证旧密码正确性
		// 如果旧密码正确,修改密码
		// 修改成功
		// 修改失败
		try {
			userName = (String) request.getParameter("userName");
			oldPassword = (String) request.getParameter("oldPassword");
			newPassword = (String) request.getParameter("newPassword");
			
			System.out.println("userName:" + userName + " oldPAssword:" + oldPassword + " newPassword:"+ newPassword);
			
			if(ServiceFactory.getIUserServiceInstance().login(userName, oldPassword)){
				if (ServiceFactory.getIUserServiceInstance().changePassword(userName, oldPassword, newPassword)) {
					msg = "修改成功";
					url = "成功修改密码后的密码";
					out.print("[{\"status\" : true}]");
				}
			}else{
				out.print("[{\"status\" : false}]");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	private String validMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Boolean flag = false;
		String phoneNumber = "";
		String validCode = "";
		List<User> data = null;
		// 调用第三方API,验证验证码正确性
		try {
			phoneNumber = (String) request.getAttribute("phoneNumber");
			validCode = (String) request.getAttribute("validCode");
			data = ServiceFactory.getIUserServiceInstance().validMessage(phoneNumber, validCode);
			JSONArray jsonArray = JSONArray.fromObject(data);
			// 输出数据
			out.print(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String msg = "";
		String url = "";
		String userName = "";
		String phoneNumber = "";
		String password = "";
		try {
			userName = (String) request.getParameter("userName");
			phoneNumber = (String) request.getParameter("phoneNumber");
			password = (String) request.getParameter("password");
			System.out.println("userName:" + userName + " password:" + password + " phoneNumber:"+ phoneNumber);
			if (ServiceFactory.getIUserServiceInstance().register(userName, phoneNumber, password)) {
				msg = "注册成功";
				url = "成功后跳转页面";
				out.print("[{\"status\" : true}]");
			} else {
				msg = "注册失败";
				url = "失败后跳转的页面";
				out.print("[{\"status\" : false}]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 把这些信息添加到数据库

		return null;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		String msg = "";
		String url = "";
		String userName = "";
		String password = "";

		User vo = new User();
		try {
			userName = (String) request.getParameter("userName");
			password = (String) request.getParameter("password");

			System.out.println("userName:" + userName + " password:" + password);

			if (ServiceFactory.getIUserServiceInstance().login(userName, password)) {
				out.print("[{\"status\" : true ,\"userName\" : \"" + userName + "\"}]");
				System.out.println("login:true");
				request.getSession().setAttribute("userName", userName);
				msg = "登录成功！";
				url = "登录成功页面";
			} else {
				out.print("[{\"status\" : false}]");
				System.out.println("login:false");
				msg = "登陆失败，错误的ID或密码";
				url = "登录页面路径";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (true) {
			vo.setIsAdmin(true);
		}

		return "/pages/forward.jsp";
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		String msg = ""; // 表示提示信息
		String url = ""; // 表示跳转路径
		request.setAttribute("userName", null);
		msg = "注销成功";
		url = "/login.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}

}
