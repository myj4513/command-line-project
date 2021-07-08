package DTO;

import java.util.*;

public class User {
	private String id;
	private String password;
	private int account = 0;
	private List<Product> fundingHistory = new LinkedList<Product>();
	
	public User(String idpw){
		String[] strArr = idpw.split("/");
		this.id = strArr[0].trim();
		this.password = strArr[1].trim();
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

	public List<Product> getFundingHistory(){ return fundingHistory; }

	public void setAccount(int account){
		this.account = account;
	}
	
	public void deposit(int amount) {
		account += amount;
		System.out.println("���� �� �ܾ��� "+account+"�� �Դϴ�.");
	}

	public String toString(){
		return id + "," + password + "," + account;
	}
}
