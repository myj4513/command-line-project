package DTO;

public class User {
	private String id;
	private String password;
	private int account = 0;
	
	public User(String id, String password){
		this.id = id;
		this.password = password;
	}

	public String getId(){
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public int getAccount(){
		return account;
	}

	public void setAccount(int account){
		this.account = account;
	}

	public String toString(){
		return id + "," + password + "," + account;
	}
}
