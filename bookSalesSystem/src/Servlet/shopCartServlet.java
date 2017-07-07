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
import vo.Book;
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
	public String shopCart(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int num=Integer.parseInt((String) request.getAttribute("num"));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String number="";
		String msg="";
    	String url="";
    	boolean flag = false;
    	List<shopCar> data=null;
    	try{
    		msg="请求购物车成功";
    		url="/pages/index.html";
    		number=(String) request.getAttribute("number");
    		data=ServiceFactory.getIShopCartServiceInstance().shopCart();
    		String json = "{";
			for (shopCar shopCar : data) {
				if (!flag) {
					json += "["
									+ "\"sid\" : " + "\"" + shopCar.getSid()
									+	"\"uid\"" + "\"" + shopCar.getUid() 
									+	"\"bid\"" + "\"" + shopCar.getBid() 
									+	"\"price\"" + "\"" + shopCar.getPrice() 
									+	"\"isOrder\"" + "\"" + shopCar.getIsOrder() 
									+	"\"isPurchase\"" + "\"" + shopCar.getIsPurchase()
									+	"\"number\"" + "\"" + shopCar.getNumber()+
								"]";
					flag = true;
				} else if (flag) {
					json += ",["
							+ "\"sid\" : " + "\"" + shopCar.getSid()
							+	"\"uid\"" + "\"" + shopCar.getUid() 
							+	"\"bid\"" + "\"" + shopCar.getBid() 
							+	"\"price\"" + "\"" + shopCar.getPrice() 
							+	"\"isOrder\"" + "\"" + shopCar.getIsOrder() 
							+	"\"isPurchase\"" + "\"" + shopCar.getIsPurchase()
							+	"\"number\"" + "\"" + shopCar.getNumber()+
						"]";
				}
			}
			flag = false;
			json += "}";
			// 输出数据
			System.out.println("json:" + json);
			out.print(json);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	request.setAttribute("url", url);	
		return "";
	}

	
}
