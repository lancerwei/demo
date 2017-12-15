package user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfo {
	private int id;
	private String card;//卡号
	private String username;//卡主
	private String password;//密码
	private String telephone;//手机号
	private String sfnumber;//身份证
	private String extype;//交易类型
	private double exmoney;//交易金额
	private double balance;//卡内余额
	private Date extime;//交易时间
	
	public UserInfo() {
		
	}
	
	public UserInfo(int id, String card, String username, String password, String telephone, String sfnumber,
			String extype, double exmoney, double balance, Date extime) {
		super();
		this.id = id;
		this.card = card;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.sfnumber = sfnumber;
		this.extype = extype;
		this.exmoney = exmoney;
		this.balance = balance;
		this.extime = extime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSfnumber() {
		return sfnumber;
	}

	public void setSfnumber(String sfnumber) {
		this.sfnumber = sfnumber;
	}

	public String getExtype() {
		return extype;
	}

	public void setExtype(String extype) {
		this.extype = extype;
	}

	public double getExmoney() {
		return exmoney;
	}

	public void setExmoney(double exmoney) {
		this.exmoney = exmoney;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getExtime() {
		return extime;
	}

	public void setExtime(Date extime) {
		this.extime = extime;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", card=" + card + ", username=" + username + ", password=" + password
				+ ", telephone=" + telephone + ", sfnumber=" + sfnumber + ", extype=" + extype + ", exmoney=" + exmoney
				+ ", balance=" + balance + ", extime=" + extime + "]";
	}
	public static void main(String[] args) {
		final UserInfo user = new UserInfo(); user.setUsername("aaa"); List<UserInfo> userList = new ArrayList<UserInfo>(); userList .add(user); user.setUsername("bbb"); System.out.println(userList.get(0).getUsername());
	}
}
