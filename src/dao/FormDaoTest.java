package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import po.Form;
import vo.FormVo;

class FormDaoTest {
	
	private FormDao dao = new FormDao();

	@Test
	void testAdd() {
		Form form = new Form(0, 1, "2019-10-31", "09:45", "10:45", 7, "是", "####", "审核通过", "2019-10-31 08:22:40");
		System.out.println(dao.addForm(form));
	}
	
	@Test
	void testDeleteById() {
		int id = 3;
		System.out.println(dao.deleteForm(id));
	}
	
	@Test
	void testFindById() {
		int id = 2;
		System.out.println(dao.findById(id).toString());
	}
	
	@Test
	void testFindByStatus() {
		String status = "待审核";
		System.out.println(dao.findByStatus(status).toString());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testFindAll() {
		ArrayList<FormVo> fromList = dao.findAll("2019-12-09", "2019-12-15");
		String[][] timeTable = new String[7][30]; // 时刻表（empty\wait\occupied）
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 30; j++)
				timeTable[i][j] = "empty";
		
		for (FormVo formVo : fromList) {
			System.out.println(formVo.toString());
			int i = 0;
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = dateFormat1.parse(formVo.getApplydate());
				i = date.getDay() == 0 ? 6 : date.getDay() - 1; // 星期几
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] start_array = formVo.getStart().split(":"); // 开始时间
			int start = (Integer.parseInt(start_array[0]) - 8) * 2;
			start = (Integer.parseInt(start_array[1]) == 0) ? start : (start + 1);
			String[] end_array = formVo.getEnd().split(":"); // 结束时间
			int end = (Integer.parseInt(end_array[0]) - 8) * 2;
			end = (Integer.parseInt(end_array[1]) == 0) ? end : (end + 1);
			System.out.println(start + " " + end);
			String status = formVo.getStatus();
			for(int j = start; j < end; j++)
				timeTable[i][j] = status;
		}
	}
}