package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities_enum.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> list = new ArrayList<>();
	
	public Order() {}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}
	
	public void addItem(OrderItem item) {
		list.add(item);
	}
	public void removeItem(OrderItem item) {
		list.remove(item);
	}
	
	public double total() {
		double total = 0;
		for (OrderItem i : list) {
			total += i.subtotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (OrderItem c : list) {
			sb.append(c.toString() +  "\n");					
		}
		
		sb.append(String.format("Total price: $ %.2f", total()));
		
		return sb.toString();
	}
	
	
	
	

}
