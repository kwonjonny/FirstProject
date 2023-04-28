package product;

public class Product {
	
	
	private String[] list = {"item1","item2","itme3","item4"};
	private int price = 1000;
	
	
	public String[] getList() {
		return list;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setList(String[] list) {
		this.list = list;
	}

	
	
}
