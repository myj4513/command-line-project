package DTO;

import java.util.*;

public class Product {
	private final String name;
	private final int goalAmount;
	private int currentAmount=0;
	private final int fundingPrice;
	private List<User> sponsor = new ArrayList<User>();
	
	public Product(String name, int goalAmount, int fundingPrice){
		this.name = name;
		this.goalAmount = goalAmount;
		this.fundingPrice = fundingPrice;
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

	public void setCurrentAmount(int currentAmount){
		this.currentAmount = currentAmount;
	}

	public String toString(){
		UTIL.ProductService.setCurrentProduct(this);
		return "이름 : "+name+"\n목표액 : "+goalAmount+"원\n현재 펀딩액 : "+currentAmount+"원\n달성률 : "+((double)currentAmount/goalAmount*100)+"%\n금액 : "+fundingPrice+"원";
	}
}
