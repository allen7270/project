package project;
/**
 * 
 * @projectName project
 * @className Treat
 * @author allen
 * @date 2022年8月04日 下午4:12:31
 */
public class Treat {
	
	public String Encryption(String passwd) {
		char[] a= passwd.toCharArray();
		String b="";
		for(var c:a) {
			c+=1;
			b += Character.toString(c);
		}
		return b;
	}
	
	public String decrypt(String passwd) {
		char[] b= passwd.toCharArray();
		String a="";
		for(var c:b) {
			c-=1;
			a += Character.toString(c);
		}
		return a;
	}
}

