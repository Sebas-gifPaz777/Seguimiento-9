package model;

public class Customer {
	
	private String id;
	private int num;
	public Customer(String id, int num) {
		this.id=id;
		this.num=num;
	}
	public String getId() {
		return id;
	}
	public int getNum() {
		return num;
	}
	
}
