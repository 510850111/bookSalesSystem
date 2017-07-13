package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.ServiceFactory;
import net.sf.json.JSONArray;
import vo.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet(name = "CategoryServlet", urlPatterns = "/pages/CategoryServlet/*")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/pages/errors.jsp"; // 定义错误页面
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		System.out.println("status = " + status);
		if (status != null) {
			if ("getAllBooks".equals(status)) {this.search(request, response);}
			
		}

	}
	private String search(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String categoryName="";
		String msg="";
		String url="";
		try{
			categoryName=(String) request.getAttribute("categoryName");
			List<Category> data = new ArrayList<Category>();
			data = ServiceFactory.getICategoryServiceInstance().search(categoryName);
			JSONArray jsonArray = JSONArray.fromObject(data);
			System.out.println("search-CategoryServlet:" + jsonArray);
			out.print(data);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

}
