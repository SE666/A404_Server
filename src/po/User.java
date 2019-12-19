package po;

/**
 * user基本信息
 * @author 汪wqs
 *
 * 2019年10月28日 下午3:12:24
 * 2019年11月12日
 */
public class User {
	private int id; // 用户id
	private String stuid; // 学号
	private String name; // 姓名
	private String password; // 登录密码
	private String phone; // 联系方式
	private int flag; // 标识
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String stuid, String name, String password, String phone, int flag) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.flag = flag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", stuid=" + stuid + ", name=" + name + ", password=" + password + ", phone=" + phone
				+ ", flag=" + flag + "]";
	}
}


