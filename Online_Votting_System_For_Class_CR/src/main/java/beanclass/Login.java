package beanclass;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	public Login(){}
	
	//setter method
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public void setPassWord(String passWord) {
		this.password=passWord;
	}
	
	//getter method
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return password;
	}
	
	
	
	

}
