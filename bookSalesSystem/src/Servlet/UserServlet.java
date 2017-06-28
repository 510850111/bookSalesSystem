package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.User;

@WebServlet(name = "adminServlet", urlPatterns = "/pages/back/AdminServlet/*")
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
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String changePassword(HttpServletRequest request, HttpServletResponse response) {
		String userName = (String) request.getAttribute("phoneNumber");
		String oldPassword = (String) request.getAttribute("oldPAssword");
		String newPassword = (String) request.getAttribute("newPassword");
		// 先验证旧密码正确性
		// 如果旧密码正确,修改密码
		// 修改成功
		// 修改失败

		return null;
	}

	private String validMessage(HttpServletRequest request, HttpServletResponse response) {
		String phoneNumber = (String) request.getAttribute("phoneNumber");
		String validCode = (String) request.getAttribute("validCode");

		// 调用第三方API,验证验证码正确性
		return null;
	}

	public String register(HttpServletRequest request, HttpServletResponse response) {

		User vo = new User();
		vo.setUserName((String) request.getAttribute("userName"));
		vo.setPhoneNumber((String) request.getAttribute("phoneNumber"));
		vo.setPassword((String) request.getAttribute("password"));

		// 把这些信息添加到数据库

		return null;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {

		String msg = "";
		String url = "";

		String userName = (String) request.getAttribute("userName");
		String password = (String) request.getAttribute("password");

		User vo = new User();

		vo.setUserName(userName);
		vo.setPassword(password);

		if (true) {
			vo.setIsAdmin(true);
		}

		return "/pages/forward.jsp";
	}

	public String logout(HttpServletRequest request, HttpServletResponse response) {
		String msg = ""; // 表示提示信息
		String url = ""; // 表示跳转路径
		request.setAttribute("aid", null);
		msg = "注销成功";
		url = "/login.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}

}
