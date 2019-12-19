package service;

import dao.UserDao;
import po.User;

/**
 * 	user服务
 * @author 汪wqs
 *
 * 2019年10月31日 上午7:39:38
 */

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	// 注册
	public int register(User user) {
		// 判断学号是否已经存在
		if(userDao.findByStuid(user.getStuid()) != null) {
			return -1; // 学号已存在
		}
		return userDao.addUser(user); //注册
	}
	
	// 登录 ---- 根据学号和密码查询
	public User login(String stuid, String password) {
		return userDao.findByStuidAndPwd(stuid, password);
	}
	
/*	// 获取用户个人信息 ---- 根据用户id查询
	public User getInfo(int id) {
		return userDao.findById(id);
	}*/

}
