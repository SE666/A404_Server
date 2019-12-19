package vo;

/**
 * 	完整申请表
 * @author 汪wqs
 *
 * 2019年11月05日 上午8:36:22
 */

public class FormVo {
	private int id; // 申请表id
	private String stuid; // 申请人学号
	private String username; // 申请人姓名
	private String phone; // 申请人联系方式
	private String applydate; // 申请使用日期
	private String start; // 开始时刻
	private String end; // 结束时刻
	private int number; // 使用人数
	private String ifmedia; // 是否使用多媒体
	private String reason; // 申请理由
	private String status; // 审核状态
	private String submitdatetime; // 提交日期时间 
	public FormVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormVo(int id, String stuid, String username, String phone, String applydate, String start, String end,
			int number, String ifmedia, String reason, String status, String submitdatetime) {
		super();
		this.id = id;
		this.stuid = stuid;
		this.username = username;
		this.phone = phone;
		this.applydate = applydate;
		this.start = start;
		this.end = end;
		this.number = number;
		this.ifmedia = ifmedia;
		this.reason = reason;
		this.status = status;
		this.submitdatetime = submitdatetime;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getIfmedia() {
		return ifmedia;
	}
	public void setIfmedia(String ifmedia) {
		this.ifmedia = ifmedia;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubmitdatetime() {
		return submitdatetime;
	}
	public void setSubmitdatetime(String submitdatetime) {
		this.submitdatetime = submitdatetime;
	}
	@Override
	public String toString() {
		return "FormVo [id=" + id + ", stuid=" + stuid + ", username=" + username + ", phone=" + phone + ", applydate="
				+ applydate + ", start=" + start + ", end=" + end + ", number=" + number + ", ifmedia=" + ifmedia
				+ ", reason=" + reason + ", status=" + status + ", submitdatetime=" + submitdatetime + "]";
	}
}
