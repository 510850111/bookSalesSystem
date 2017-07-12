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
		String userName ="";
		int uid=0;
		String oldPassword ="";
		String newPassword = "";
		String msg="";
		String url="";
		
		// 先验证旧密码正确性
		// 如果旧密码正确,修改密码
		// 修改成功
		// 修改失败
		try{
			userName = (String) request.getAttribute("phoneNumber");
			oldPassword = (String) request.getAttribute("oldPAssword");
			uid=(int) request.getAttribute("uid");
			newPassword = (String) request.getAttribute("newPassword");
			if(ServiceFactory.getIUserServiceInstance().login(userName, oldPassword)){
				if(ServiceFactory.getIUserServiceInstance().changePassword(uid, newPassword)){
					msg="修改成功";
					url="成功修改密码后的密码";
				}
				else{
					msg="修改失败";
					url="失败后";
				}
			}else{
				msg="旧密码错误";
				url="错误后";
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		return "";
	}

	private String validMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Boolean flag=false;
		String phoneNumber = "";
		String validCode = "";
		List<User> data=null;
		// 调用第三方API,验证验证码正确性
		try{
			phoneNumber = (String) request.getAttribute("phoneNumber");
			validCode = (String) request.getAttribute("validCode");
			data=ServiceFactory.getIUserServiceInstance().validMessage(phoneNumber, validCode);
			JSONArray jsonArray = JSONArray.fromObject(data);
			// 输出数据
			out.print(jsonArray);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String register(HttpServletRequest request, HttpServletResponse response) {

		User vo = new User();
		String msg="";
		String url="";
		String userName="";
		String phoneNumber="";
		String password="";
		Boolean data=false;
		try{
			userName=(String) request.getAttribute("userName");
			phoneNumber=(String) request.getAttribute("phoneNumber");
			password=(String) request.getAttribute("password");
			data=ServiceFactory.getIUserServiceInstance().register(userName, phoneNumber, password);
			if(ServiceFactory.getIUserServiceInstance().register(userName, phoneNumber, password)){
				msg="注册成功";
				url="成功后跳转页面";
			}else{
				msg="注册失败";
				url="失败后跳转的页面";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		// 把这些信息添加到数据库

		return null;
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {

		String msg = "";
		String url = "";
		String userName ="";
		String password ="";
		User vo=new User();
		try{
			userName = (String) request.getAttribute("userName");
			password = (String) request.getAttribute("password");
			if(ServiceFactory.getIUserServiceInstance().login(userName, password)){
				request.getSession().setAttribute("userName",userName );
				request.getSession().setAttribute("password", password);
				msg="登录成功！";
				url="登录成功页面";
			}else{
				msg="登陆失败，错误的ID或密码";
				url="登录页面路径";
			}	
		}catch(Exception e){
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
		request.setAttribute("aid", null);
		msg = "注销成功";
		url = "/login.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/pages/forward.jsp";
	}

}
