package po;

/**
 * 	申请表
 * @author 汪wqs
 *
 * 2019年11月05日 上午8:04:24
 */

public class Form {
	
	private int id; // 申请表id
	private int userid; // 申请人id
	private String applydate; // 申请使用日期
	private String start; // 开始时刻
	private String end; // 结束时刻
	private int number; // 使用人数
	private String ifmedia; // 是否使用多媒体
	private String reason; // 申请理由
	private String status; // 审核状态
	private String submitdatetime; // 提交日期时间 
	
	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Form(int id, int userid, String applydate, String start, String end, int number, String ifmedia,
			String reason, String status, String submitdatetime) {
		super();
		this.id = id;
		this.userid = userid;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
		return "Table [id=" + id + ", userid=" + userid + ", applydate=" + applydate + ", start=" + start + ", end="
				+ end + ", number=" + number + ", ifmedia=" + ifmedia + ", reason=" + reason + ", status=" + status
				+ ", submitdate=" + submitdatetime + "]";
	}
}
