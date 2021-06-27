package dto;

public class Product {
	private final String name;
	private final int goalAmount;
	private int currentAmount=0;
	private final int fundingPrice;
	
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
}
