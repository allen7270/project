package project;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 * 
 * @projectName project
 * @className DataBase
 * @author allen
 * @date 2022年8月3日 下午12:52:08
 */
public class DataBase {
	private String username, passwd;
	private String url= "jdbc:mysql://localhost:3306/project";
	
	// constructor login MySQL
	public DataBase() throws IOException {
		// fileMySQL(account, passwd)
		String file= "/Users/allen/Documents/Servlet&JSP/Servlet_111_A/workspace/project/src/main/java/project/login.txt";
		var name= new File(file);
		try {
			DataInputStream input = new DataInputStream(
			        new FileInputStream(name));
			String[] data= input.readLine().split(",");
	        this.username= data[0];
	        this.passwd= data[1];
	        input.close();          // close Stream
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	// Connection to MySQL
	public Connection getConnection() {
		try {
			Connection con= DriverManager.getConnection(this.url,this.username,this.passwd);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// input data to member
	public void add(Data data) {
		try {
			var con= getConnection();
			var st= con.createStatement();
			
			// MySQL(insert data)
			String sql= String.format("insert into member(id ,username, account, passwd, mail, phone) values('I02','%s', '%s', '%s', '%s', '%s')",
					data.getUsername(), data.getAccount(), data.getPasswd(), data.getMail(), data.getphone());
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// update member data to database
	public void alter(Data data, String passwdAlter) {
		try {
			var treat= new Treat();
			var con= getConnection();
			var st= con.createStatement();
			String sql= String.format("update project.member set passwd='%s',mail='%s', phone='%s' where account ='%s' and passwd='%s';",
					treat.Encryption(passwdAlter), data.getMail(), data.getphone(),data.getAccount(), treat.Encryption(data.getPasswd()));
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// show member data
	public ArrayList<String> showMember() {
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql= "SELECT * FROM member;";
			var rs= st.executeQuery(sql);
			var data= new ArrayList<String>();
			var treat= new Treat();
			while(rs.next()) {
				String id= rs.getString("id");
				if(id.equals("I02")) {
					data.add(rs.getString("username"));
					data.add(rs.getString("account"));
					data.add(treat.decrypt(rs.getString("passwd")));
					data.add(rs.getString("mail"));
					data.add(rs.getString("phone"));
				}
			}
			return data;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	// show order data
	public ArrayList<String> showOnlineOrder(){
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql= "SELECT * FROM onlineOrderDetail;";
			var rs= st.executeQuery(sql);
			var data= new ArrayList<String>();
			while(rs.next()) {
				for(int i=5; i<16; i++) {
					data.add(rs.getString(i));
				}
			}
			return data;
		} catch (SQLException e) {
			return null;
		}
	}
	
	// show order Info
	public ArrayList<String> showOnlineOrderInfo(){
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql= "SELECT * FROM onlineOrderDetail;";
			var rs= st.executeQuery(sql);
			var data= new ArrayList<String>();
			while(rs.next()) {
				for(int i=1; i<5; i++) {
					data.add(rs.getString(i));
				}
			}
			return data;
		} catch (SQLException e) {
			return null;
		}
	}
	
	// show reserved data
	public ArrayList<String> showReservrd(){
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql= "select `no`, r.username,`deptno`,`date`,`time`,`number`,`mail`,`phone` from reservedDetail r join member m on r.username= m.username;";
			var rs= st.executeQuery(sql);
			var data= new ArrayList<String>();
			while(rs.next()) {
				data.add(Integer.toString(rs.getInt("no")));
				data.add(rs.getString("username"));
				data.add(rs.getString("deptno"));
				data.add(rs.getString("date"));
				data.add(rs.getString("time"));
				data.add(rs.getString("number"));
				data.add(rs.getString("mail"));
				data.add(rs.getString("phone"));
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// show punch data
	public ArrayList<String> showPunch(){
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql="SELECT * FROM punch;";
			var rs= st.executeQuery(sql);
			var data= new ArrayList<String>();
			while(rs.next()) {
				for(int i=1; i<5; i++) {
				data.add(rs.getString(i));
				}
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// verify data from database
	public String verify(String account, String passwd){
		try {
			var treat= new Treat();
			var con= getConnection();
			var st= con.createStatement();
			// MySQL(select data)
			String sql= String.format("select * from member where account='%s' and passwd='%s';",
					account,treat.Encryption(passwd));
			var rs= st.executeQuery(sql);
			while(rs.next()) {
	            String accountDB= rs.getString("account");
	            String passwdDB= rs.getString("passwd");
	            if(accountDB.length()>0||passwdDB.length()>0) {
	            	String id= rs.getString("id");
	            	if(id.equals("I01")) {
	            		return "root";
	            	} else if (id.equals("I02")){
	            		return "member";
	            	}
	            } 
	        }
			return "error";
		} catch (SQLException e) {
			return "error";
		}
	}
	
	// insert into orderDetail(online)
	public void order(ArrayList<String> data, OrderData orderData) {
		try {
			var con= getConnection();
			var st= con.createStatement();
			Date date= new Date();
			String day= date.toString().substring(4,10);
			String sqlInfo= String.format("insert into orderInfo (`username`, `loc`, `mail`, `phone`) values('%s','%s','%s','%s');",
					orderData.getUsername(), orderData.getLoc(), orderData.getMail(), orderData.getPhone());
			st.executeUpdate(sqlInfo);
			// if user name duplicate (catch SQLException)
			String sqlDetail= String.format("insert into onlineOrderDetail (username, date, set1, set2, set3, carte1, carte2, carte3, carte4, carte5, carte6, carte7, carte8) values('%s', '%s', %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);",
					orderData.getUsername(), day, data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
			st.executeUpdate(sqlDetail);
		} catch (SQLException e) {
			try {
				var con= getConnection();
				var st= con.createStatement();
				Date date= new Date();
				String day= date.toString().substring(4,10);
				// update Info
				String sqlUpdateInfo= String.format("UPDATE orderInfo SET `loc` = '%s', `mail` = '%s', `phone` = '%s' WHERE `username` = '%s';",
						orderData.getLoc(), orderData.getMail(), orderData.getPhone(), orderData.getUsername());
				st.executeUpdate(sqlUpdateInfo);
				String sqlDetail= String.format("insert into onlineOrderDetail (username, date, set1, set2, set3, carte1, carte2, carte3, carte4, carte5, carte6, carte7, carte8) values('%s', '%s', %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);",
						orderData.getUsername(), day, data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
				st.executeUpdate(sqlDetail);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	// show total cost
	public String show(OrderData orderData) {
		try {
			var con= getConnection();
			var st= con.createStatement();
			// get orderDetail(`no`)
			int no=0;
			var rs1=st.executeQuery("select `no` from onlineOrderDetail WHERE username = '"+orderData.getUsername()+"';");
			while(rs1.next()) {
				no= rs1.getInt("no");
			}
			String sql= String.format("SELECT SUM(`set1` * 1399 + `set2` * 1399 + `set3` * 1399 + `carte1` * 398 + `carte2` * 398 + `carte3` * 298 + `carte4` * 298 + `carte5` * 68 + `carte6` * 110 + `carte7` * 88 + `carte8` * 128) FROM onlineOrderDetail WHERE `no` = %d;",
					no);
			var rs=st.executeQuery(sql);
			String sum="";
			while(rs.next()) {
				sum= rs.getString(1);
			}
			return sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// update payment method
	public void updatePay(OrderData orderData) {
		try {
			var con= getConnection();
			var st= con.createStatement();
			// get orderDetail(`no`)
			int no=0;
			var rs1=st.executeQuery("select `no` from onlineOrderDetail WHERE username = '"+orderData.getUsername()+"';");
			while(rs1.next()) {
				no= rs1.getInt("no");
			}
			String sql= String.format("update onlineOrderDetail set payno='%s' where no= %d;",
					orderData.getPaymentmethod(), no);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// insert into orderDetail(onsite)
	public void orderSite(ArrayList<String> data, String account) {
		var con= getConnection();
		try {
			var st= con.createStatement();
			Date date= new Date();
			String day= date.toString().substring(4,10);
			String sqlDetail= String.format("insert into onsiteOrderDetail (username, date, set1, set2, set3, carte1, carte2, carte3, carte4, carte5, carte6, carte7, carte8) values('%s', '%s', %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s);",
					account, day, data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
			st.executeUpdate(sqlDetail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// show order
	public ArrayList<String> searchOrder(String name, String date) {
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql= String.format("select `set1`,`set2`,`set3`,`carte1`,`carte2`,`carte3`,`carte4`,`carte5`,`carte6`,`carte7`,`carte8` from onlineOrderDetail d join orderInfo n on d.username= n.username where d.username='%s' and d.date='%s';",
					name, date);
			var rs= st.executeQuery(sql);
			var data= new ArrayList<String>();
			String[] titel= {"set1","set2","set3","carte1","carte2","carte3","carte4","carte5","carte6","carte7","carte8"};
			while(rs.next()) {
				for(int i=0; i<titel.length; i++) {
					data.add(rs.getString(titel[i]));
				}
			}
			return data;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	// show orderInfo
	public ArrayList<String> orderInfo(String name) {
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql= String.format("SELECT * FROM orderInfo where username='%s';",
					name);
			var rs= st.executeQuery(sql);
			var data= new ArrayList<String>();
			
			while(rs.next()) {
				data.add(rs.getString("loc"));
				data.add(rs.getString("mail"));
				data.add(rs.getString("phone"));
			}
			return data;
		} catch (SQLException e) {
			return null;
		}
	}
	
	// show payment method
	public ArrayList<String> paymethod(String name, String date) {
		var con= getConnection();
		try {
			var st= con.createStatement();
			String sql= String.format("select `payno` from onlineOrderDetail where username='%s' and date='%s';",
					name, date);
			var rs= st.executeQuery(sql);
			String payno="";
			var data= new ArrayList<String>();
			
			while(rs.next()) {
				data.add(rs.getString("payno"));
			}
			var pay= new ArrayList<String>();
			for(int i=0; i<data.size(); i++) {
				var rs1= st.executeQuery("select `paymentMethod` from paymentMethod p where p.payno='"+data.get(i)+"';");
				while(rs1.next()) {
					payno=rs1.getString("paymentMethod");
				} pay.add(payno);
			}
			return pay;
		} catch (SQLException e) {
			return null;
		}
	}
	
	// insert into reservedDetail
	public void insert(ReservedData rdata) {
		try {
			var con= getConnection();
			var st= con.createStatement();
			
			String sql= String.format("select * from member where username='%s'",
					rdata.getName());
			var rs= st.executeQuery(sql);
			while(rs.next()) {
	            String username= rs.getString("username");
	            // if member
	            if(username.length()>0) {
	    			throw new MyException();
	            }
	        }
			// non-member(insert into member(id='I03'), reservedDetail)
			String sql2= String.format("insert into member(id ,username, mail, phone) values('I03','%s', '%s', '%s');",
					rdata.getName(), rdata.getMail(), rdata.getPhone());
        	st.executeUpdate(sql2);
        	String sql1= String.format("insert into reservedDetail(username, deptno, date, time, number) values('%s', '%s', '%s', '%s', '%s');",
					rdata.getName(),rdata.getDeptno(), rdata.getDate(), rdata.getTime(), rdata.getNumber());
			st.executeUpdate(sql1); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyException e) {
			try {
				// if member insert into reservedDetail
				var con= getConnection();
				var st= con.createStatement();
				String sql1= String.format("insert into reservedDetail(username, deptno, date, time, number) values('%s', '%s', '%s', '%s', '%s');",
						rdata.getName(),rdata.getDeptno(), rdata.getDate(), rdata.getTime(), rdata.getNumber());
				st.executeUpdate(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	// loading data Info
	public String[] loadData(String account, String passwd) {
		try {
			var treat= new Treat();
			var con= getConnection();
			var st= con.createStatement();
			String name="", mail="", phone="";
			// MySQL(select data)
			String sql= String.format("select * from member where account='%s' and passwd='%s';",
					account,treat.Encryption(passwd));
			var rs= st.executeQuery(sql);
			while(rs.next()) {
				name= rs.getString("username");
				mail= rs.getString("mail");
				phone= rs.getString("phone");
			}
			String[] data= {name, account, passwd, mail, phone};
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String[] data= {};
			return data;
		}
	}
	
	// loading punch data
	public String[] loadPunchdata(String account, String passwd) {
		try {
			Date date= new Date();
			String day= date.toString().substring(4,10);
			var treat= new Treat();
			var con= getConnection();
			var st= con.createStatement();
			String name="",mail="",phone="",in="", out="";
			// MySQL(select data)
			String sql= String.format("select * from member where account='%s' and passwd='%s';",
					account,treat.Encryption(passwd));
			var rs= st.executeQuery(sql);
			while(rs.next()) {
				name= rs.getString("username");
				mail= rs.getString("mail");
				phone= rs.getString("phone");
			}
			String sql1= String.format("select * from punch where account='%s' and date='%s';", 
					account,day);
			var rs1= st.executeQuery(sql1); 
			while(rs1.next()) {
				in= rs1.getString("in");
				out= rs1.getString("out");
			}
			String[] data= {name, account, passwd, mail, phone, day, in, out};
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	// root punch
		public void punch(String account) {
			Date date= new Date();
			String day= date.toString().substring(4,10);
			String time= date.toString().substring(11,16);
			try {
				var con= getConnection();
				var st= con.createStatement();
		        var rs= st.executeQuery("select * from punch where account='"+account+"' and date= '"+day+"';");
		        String i="null";
		        while(rs.next()) {
		            i=rs.getString("date");
		        }
		        if(!i.equals("null")) {
		        	st.executeUpdate("update punch set `out`='"+time+"' where account='"+account+"' and date='"+day+"';");
		        } 
		        else {
		        	st.executeUpdate("insert into punch (`date`, `account`,`in`) values ('"+day+"','"+account+"', '"+time+"')");
		        }
		        st.close();
		        con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
