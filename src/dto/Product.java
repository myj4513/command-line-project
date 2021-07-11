package dto;

public class Product {
	private final String name;
	private final int goalAmount;
	private int currentAmount=0;
	private final int fundingPrice;
	
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

	public void setCurrentAmount(int currentAmount){
		this.currentAmount = currentAmount;
	}
}
