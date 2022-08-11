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
	// input data to database
	public void add(Data data) {
		try {
			var con= getConnection();
			var st= con.createStatement();
			// MuSQL(create table)
			st.executeUpdate("CREATE TABLE IF NOT EXISTS member (\n"
					+ "    `id` VARCHAR(10) NOT NULL,\n"
					+ "    `username` VARCHAR(20) NOT NULL,\n"
					+ "    `account` VARCHAR(20) DEFAULT 'null',\n"
					+ "    `passwd` VARCHAR(20) DEFAULT 'null',\n"
					+ "    `mail` VARCHAR(20) NOT NULL,\n"
					+ "    `phone` VARCHAR(20) NOT NULL,\n"
					+ "    PRIMARY KEY (`username`),\n"
					+ "    FOREIGN KEY (`id`)\n"
					+ "        REFERENCES id (`idno`)\n"
					+ ");");
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
//	            	return true;
	            	String id= rs.getString("id");
	            	if(id.equals("I01")) {
	            		return "root";
	            	} else if (id.equals("I02")){
	            		return "member";
	            	}
	            } 
	        }
			return "";
		} catch (SQLException e) {
			return "";
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
			// non-member
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
	
	// loading data
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
			String d= date.toString().substring(4,10);
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
			String[] data0= {name, account, passwd, mail, phone, d,"",""};

			// confirm punch table exists
			var rs2= st.executeQuery("show tables like '"+d+"';");
			String exists= rs2.next()? rs2.getString(1): "null";
			if(!exists.equals("null")) {
				String sql1= String.format("select * from `"+d+"` where account='%s';",
						account);
				var rs1= st.executeQuery(sql1); 
				while(rs1.next()) {
					in= rs1.getString("in");
					out= rs1.getString("out");
				}
				String[] data= {name, account, passwd, mail, phone, d, in, out};
				return data;
			} else {
				return data0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	// root punch
	public void punch(String account) {
		Date date= new Date();
		String d= date.toString().substring(4,10);
		String t= date.toString().substring(11,16);
		try {
			var con= getConnection();
			var st= con.createStatement();
			st.executeUpdate("create table if not exists `"+d+"`(like IO);");
	        var rs= st.executeQuery("select * from `"+d+"` where account='"+account+"';");
	        String i="null";
	        while(rs.next()) {
	            i=rs.getString("in");
	        }
	        if(!i.equals("null")) {
	        	st.executeUpdate("update `"+d+"` set `out`='"+t+"' where account='"+account+"';");
	        } 
	        else {
	        	st.executeUpdate("insert into `"+d+"` (`account`,`in`) values ('"+account+"', '"+t+"')");
	        }
	        st.close();
	        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
