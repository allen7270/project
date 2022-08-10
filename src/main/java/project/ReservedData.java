package project;

import java.io.Serializable;
/**
 * 
 * @projectName project
 * @className ReservedData
 * @author allen
 * @date 2022年8月05日 下午4:06:32
 */
public class ReservedData implements Serializable {
	private String name, deptno, date, time, number, mail, phone;
	public ReservedData() {}
	public ReservedData(String name,String deptno, String date, String time, String number, String mail, String phone) {
		this.deptno= deptno;
		this.name= name;
		this.date= date;
		this.time= time;
		this.number= number;
		this.mail= mail;
		this.phone= phone;
	}
	
	public void setDeptno(String deptno) {
		this.deptno= deptno;
	}
	public String getDeptno() {
		return this.deptno;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setDate(String date) {
		this.date= date;
	}
	public String getDate() {
		return this.date;
	}
	
	public void setTime(String time) {
		this.time= time;
	}
	public String getTime() {
		return this.time;
	}
	
	public void setNumber(String number) {
		this.number= number;
	}
	public String getNumber() {
		return number;
	}
	
	public void setMail(String mail) {
		this.mail= mail;
	}
	public String getMail() {
		return mail;
	}
	
	public void setPhone(String phone) {
		this.phone= phone;
	}
	public String getPhone() {
		return phone;
	}
}
