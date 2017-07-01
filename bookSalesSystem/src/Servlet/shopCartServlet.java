package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import vo.shopCar;

/**
 * Servlet implementation class shopCartServlet
 */
@WebServlet("/shopCartServlet")
public class shopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/pages/errors.jsp"; // 定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
        if (status != null) {
            System.out.println("status = " + status);
            if("shopCart".equals(status)){
            	path=this.shopCart(request, response);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
	}
	public String shopCart(HttpServletRequest request,HttpServletResponse response){
		int num=Integer.parseInt((String) request.getAttribute("num"));
		String msg="";
    	String url="";
    	List<shopCar> data=null;
    	try{
    		msg="请求购物车成功";
    		url="/pages/index.html";
    		data=ServiceFactory.getIShopCartServiceInstance().shopCart();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	request.setAttribute("url", url);	
		return "/pages/forward.jsp";
	}

	
}
