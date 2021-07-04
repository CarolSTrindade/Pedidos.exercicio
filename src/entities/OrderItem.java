package entities;

public class OrderItem {
	
	private int quantity;
	
	private Product product;
	
	public OrderItem() {}

	public OrderItem(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}	
	
	public double subtotal() {
		return this.product.getPrice() * this.quantity;
	}

	@Override
	public String toString() {
		return product.toString() + " Quantity: " + quantity + String.format(", Subtotal: $ %.2f.", subtotal());
	}
	
	

}
