package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import dao.FormDao;
import po.Form;
import vo.FormVo;

/**
 * 	申请表服务
 * @author 汪wqs
 *
 * 2019年11月08日 上午8:17:02
 * 2019年11月12日
 * 2019年11月19日
 * 2019年12月02日
 * 2019年12月19日
 */

public class FormService {
	private FormDao formDao = new FormDao();
	
	// 提交申请表
	public int submitApply(Form form) {
		return formDao.addForm(form);
	}
	
	// 撤销申请表
	public int deleteApply(int id) {
		return formDao.deleteForm(id);
	}
	
	// 查询所有申请表
	public ArrayList<FormVo> findAll(String date1, String date2) {
		return formDao.findAll(date1, date2);
	}
	
	public ArrayList<FormVo> findAll() {
		return formDao.findAll();
	}
	
	// 根据申请表审核状态查询所有
	public ArrayList<FormVo> findByStatus(String status) {
		return formDao.findByStatus(status);
	}
	
	// 根据申请表id查询
	public FormVo findById(int id) {
		return formDao.findById(id);
	}
		
	// 根据申请人userid查询所有
	public ArrayList<FormVo> findByUserid(int userid) {
		return formDao.findByUserid(userid);
	}
	
	// 生成时间选择页
	@SuppressWarnings("deprecation")
	public String[][] createTimetable(String date1, String date2) {
		ArrayList<FormVo> formList = formDao.findAll(date1, date2);
		System.out.println(new Gson().toJson(formList));
		String[][] timeTable = new String[7][30]; // 时刻表（empty\wait\occupied）
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 30; j++) {
				timeTable[i][j] = "";
			}
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("待审核", "occupied");
		map.put("审核通过", "confirmed");
		map.put("未通过", "");
		
		
		for (FormVo formVo : formList) {
			int day = 0;  //表示星期
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = dateFormat.parse(formVo.getApplydate());
				day = date.getDay() == 0 ? 6 : date.getDay() - 1; // 星期几
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String[] start_array = formVo.getStart().split(":"); // 开始时间
			int start = (Integer.parseInt(start_array[0]) - 8) * 2;
			start = (Integer.parseInt(start_array[1]) == 0) ? start : (start + 1);
			String[] end_array = formVo.getEnd().split(":"); // 结束时间
			int end = (Integer.parseInt(end_array[0]) - 8) * 2;
			end = (Integer.parseInt(end_array[1]) == 0) ? end : (end + 1);
			
			String status = formVo.getStatus();
			for(int j = start; j < end; j++) {
				timeTable[day][j] = map.get(status);
			}
			timeTable[day][end-1] += " last";
		}
		return timeTable;
	}
	
	public int changeStatus(int id, String status) {
		return formDao.updateStatus(id, status);
	}
}
