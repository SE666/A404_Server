package dao;

import org.junit.jupiter.api.Test;

import po.User;

class UserDaoTest {
	
	private UserDao dao = new UserDao();

	@Test
	void testAdd() {
		User user = new User(0, "17020031071", "王wmx", "1071", "17863998708", 0);
		System.out.println(dao.addUser(user));
	}
	
	@Test
	void testfindByStuidAndPwd() {
		String stuid = "17020031068";
		String password = "1068";
		User user = dao.findByStuidAndPwd(stuid, password);
		System.out.println(user.toString());
	}
}
