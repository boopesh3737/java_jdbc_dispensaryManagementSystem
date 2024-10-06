package com.mini;

public class medicinedetail {
    private String Id;
    private String Name;
    private int Price;
    private int Quantity; // New attribute
    private String ExpiryDate;
	public medicinedetail(String id, String name, int price, int quantity, String expiryDate) {
		super();
		Id = id;
		Name = name;
		Price = price;
		Quantity = quantity;
		ExpiryDate = expiryDate;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}
    
    
}
