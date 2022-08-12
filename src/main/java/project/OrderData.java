package project;

import java.io.Serializable;

public class OrderData implements Serializable {
	private String username, paymentMethod, loc, mail, phone;
	public OrderData() {}
	public OrderData(String username, String paymentMethod, String loc, String mail, String phone) {
		this.username= username;
		this.paymentMethod= paymentMethod;
		this.loc= loc;
		this.mail= mail;
		this.phone= phone;
	}
	public void setUsername(String username) {
		this.username= username;
	}
	public String getUsername() {
		return this.username;
	}
	public void setPaymentmethod(String paymentMethod) {
		this.paymentMethod= paymentMethod;
	}
	public String getPaymentmethod() {
		return this.paymentMethod;
	}
	public void setLoc(String loc) {
		this.loc= loc;
	}
	public String getLoc() {
		return this.loc;
	}
	public void setMail(String mail) {
		this.mail= mail;
	}
	public String getMail() {
		return this.mail;
	}
	public void setPhone(String phone) {
		this.phone= phone;
	}
	public String getPhone() {
		return this.phone;
	}
}
