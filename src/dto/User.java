package dto;

public class User {
	private final String id;
	private final String password;
	private int account = 0;
	
	User(String idpw){
		String[] arr = idpw.split("/");
		this.id = arr[0].trim();
		this.password = arr[1].trim();
	}
	
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getAccount(){
		return account;
	}
	
	public void deposit(int amount) {
		account += amount;
		System.out.println("���� �� �ܾ��� "+account+"�� �Դϴ�.");
	}
}
