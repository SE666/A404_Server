package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}

	// 撤销申请表
	protected void deleteApply(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		int result = formService.deleteApply(id);
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
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
		PrintWriter out = response.getWriter();
		out.println(formListJson);
		out.flush();
		out.close();

	}

	// 根据申请表id查询
	protected void findById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		FormVo formVo = formService.findById(id);

		Gson gson = new Gson();
		String formVoJson = gson.toJson(formVo);
		PrintWriter out = response.getWriter();
		out.println(formVoJson);
		out.flush();
		out.close();

	}

	// 根据申请人userid查询所有
	protected void findByUserid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userid = Integer.parseInt(request.getParameter("userid"));
		ArrayList<FormVo> formList = formService.findByUserid(userid);

		Gson gson = new Gson();
		String formListJson = gson.toJson(formList);
		PrintWriter out = response.getWriter();
		out.println(formListJson);
		out.flush();
		out.close();

	}

	// 生成时间选择页
	protected void schedule(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String date1 = request.getParameter("dateStart");
		String date2 = request.getParameter("dateEnd");
		String[][] timeTable = formService.createTimetable(date1, date2);

		Gson gson = new Gson();
		String timeTableJson = gson.toJson(timeTable);
		PrintWriter out = response.getWriter();
		out.println(timeTableJson);
		out.flush();
		out.close();
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
		} else if (method.equals("schedule")) {
			schedule(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
