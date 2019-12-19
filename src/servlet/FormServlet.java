package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import po.Form;
import service.FormService;
import vo.FormVo;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet(description = "申请表的相关业务", urlPatterns = { "/FormServlet" })
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FormService formService = new FormService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // 提交申请表
 	protected void submitApply(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		
 		int userid = Integer.parseInt(request.getParameter("userid"));
 		String applydate = request.getParameter("applydate");
 		String start = request.getParameter("start");
 		String end = request.getParameter("end");
 		int number = Integer.parseInt(request.getParameter("number"));
 		String ifmedia = request.getParameter("ifmedia");
 		String reason = request.getParameter("reason");
 		String status = "待审核"; // request.getParameter("status");
 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
 		String submitdatetime = df.format(new Date());// new Date()为获取当前系统时间
 		
 		Form form = new Form(0, userid, applydate, start, end, number, ifmedia, reason, status, submitdatetime);
 		
 		int result = formService.submitApply(form);
 		
 	}
 	
 	// 撤销申请表
 	protected void deleteApply(HttpServletRequest request, HttpServletResponse response)
  			throws ServletException, IOException {
 		
 		int id = Integer.parseInt(request.getParameter("id"));
 		int result = formService.deleteApply(id);

  	}
 	
 	// 查询所有申请表
 	protected void findAll(HttpServletRequest request, HttpServletResponse response) 
   			throws ServletException, IOException {
 		
 		String date1 = request.getParameter("date1");
 		String date2 = request.getParameter("date2");
 		ArrayList<FormVo> formList = formService.findAll(date1, date2);
 		
 		Gson gson = new Gson();
		String formListJson = gson.toJson(formList);
		response.setCharacterEncoding("utf-8"); // 响应乱码
		response.getWriter().write(formListJson);
   	}
 	
	// 根据申请表审核状态查询所有
	protected void findByStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String status = request.getParameter("status");
		ArrayList<FormVo> formList = formService.findByStatus(status);
		
		Gson gson = new Gson();
		String formListJson = gson.toJson(formList);
		response.setCharacterEncoding("utf-8"); // 响应乱码
		response.getWriter().write(formListJson);

	}

	// 根据申请表id查询
	protected void findById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		FormVo formVo = formService.findById(id);
		
		Gson gson = new Gson();
		String formVoJson = gson.toJson(formVo);
		response.setCharacterEncoding("utf-8"); // 响应乱码
		response.getWriter().write(formVoJson);

	}

	// 根据申请人userid查询所有
	protected void findByUserid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userid = Integer.parseInt(request.getParameter("userid"));
		ArrayList<FormVo> formList = formService.findByUserid(userid);
		
		Gson gson = new Gson();
		String formListJson = gson.toJson(formList);
		response.setCharacterEncoding("utf-8"); // 响应乱码
		response.getWriter().write(formListJson);
	}
	
	// 生成时间选择页
	protected void createTimetable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String date1 = request.getParameter("date1");
 		String date2 = request.getParameter("date2");
 		String[][] timeTable = formService.createTimetable(date1, date2);
 		
 		Gson gson = new Gson();
		String timeTableJson = gson.toJson(timeTable);
		response.setCharacterEncoding("utf-8"); // 响应乱码
		response.getWriter().write(timeTableJson);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ArrayList<FormVo> formList = formService.findAll();
// 		
// 		Gson gson = new Gson();
//		String formListJson = gson.toJson(formList);
//		response.setCharacterEncoding("utf-8"); // 响应乱码
//		System.out.println(formListJson);
		//response.getWriter().write(formListJson);
		
		String method = request.getParameter("method");
		
		if (method.equals("submit")) {
			submitApply(request, response);

		} else if (method.equals("delete")) {
			deleteApply(request, response);
			
		} else if (method.equals("findAll")) {
			findAll(request, response);

		} else if (method.equals("findByStatus")) {
			findByStatus(request, response);

		} else if (method.equals("findById")) {
			findById(request, response);

		} else if (method.equals("findByUserid")) {
			findByUserid(request, response);

		} else if (method.equals("timeTable")) {
			createTimetable(request, response);

		}
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
