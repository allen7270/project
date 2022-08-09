package project;

import java.io.Serializable;

public class Data implements Serializable{
	private String username, account, passwd, mail, phone;
	public Data(){}
	public Data(String username, String account, String passwd, String mail, String phone){
		this.username= username;
		this.account= account;
		this.passwd= passwd;
		this.mail= mail;
		this.phone= phone;
	}
	public void setUsername(String username) {
		this.username= username;
	}
	public String getUsername() {
		return this.username;
	}
	
	public void setAccount(String account) {
		this.account= account;
	}
	public String getAccount() {
		return this.account;
	}
	
	public void setPasswd(String passwd) {
		this.passwd= passwd;
	}
	public String getPasswd() {
		return passwd;
	}
	
	public void setMail(String mail) {
		this.mail= mail;
	}
	public String getMail() {
		return this.mail;
	}
	
	public void setphone(String phone) {
		this.phone= phone;
	}
	public String getphone() {
		return this.phone;
	}
}
