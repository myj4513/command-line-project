package DTO;

import java.util.*;

public class Product {
	private final String name;
	private final int goalAmount;
	private int currentAmount=0;
	private final int fundingPrice;
	private List<User> sponsor = new ArrayList<User>();
	
	public Product(String str){
		String[] arr = str.split("/");
		this.name = arr[0].trim();
		this.goalAmount = Integer.parseInt(arr[1].trim());
		this.fundingPrice = Integer.parseInt(arr[2].trim());
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getGoalAmount() {
		return this.goalAmount;
	}
	
	public int getCurrentAmount() {
		return this.currentAmount;
	}
	
	public int getFundingPrice() {
		return this.fundingPrice;
	}

	public List<User> getSponsor(){ return this.sponsor; }


	public void addCurrentAmount(){ this.currentAmount += this.fundingPrice; }

	public void subtractCurrentAmount(){
		this.currentAmount -= this.fundingPrice;
	}

	public String toString(){
		UTIL.ProductService.setCurrentProduct(this);
		return "이름 : "+name+"\n목표액 : "+goalAmount+"원\n현재 펀딩액 : "+currentAmount+"원\n달성률 : "+((double)currentAmount/goalAmount*100)+"%\n금액 : "+fundingPrice+"원";
	}
}
