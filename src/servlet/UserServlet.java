package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.User;
import service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(description = "用户进行注册、登录", urlPatterns = { "/UserServlet" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 登录
 	protected void login(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		/*
 		 * 	获取请求参数
 		 */
 		String stuid = request.getParameter("stuid");
 		String password = request.getParameter("password");
 		
 		/*
		 * 	登录成功---
		 * 	失败---
		 */
 		User user = userService.login(stuid, password);
 		
 		if(user != null) {
 			
 		} else {
 			
 		}
 	}
 	
 	// 退出
 	protected void logout(HttpServletRequest request, HttpServletResponse response)
  			throws ServletException, IOException {

 		
  	}
 	
 	// 注册
 	protected void register(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
 		
 		/*
 		 * 	获取请求参数
 		 */
 		String stuid = request.getParameter("stuid");
 		String username = request.getParameter("username");
 		String password = request.getParameter("password");
 		String phone = request.getParameter("phone");

 		// 创建用户对象
 		User user = new User(0, stuid, username, password, phone, 0);
 		// 注册
   		int result = userService.register(user);

   		
   		// 处理结果
   		if (result == -1) {
   			
   		} else if(result == 1) {
   			
   		} else {
   			
   		}
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		
		if (method.equals("login")) {
			login(request, response);

		} else if (method.equals("logout")) {
			logout(request, response);
			
		} else if (method.equals("register")) {
			register(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
