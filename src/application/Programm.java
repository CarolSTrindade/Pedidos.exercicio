package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities_enum.OrderStatus;

public class Programm {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (dd/MM/yyyy): ");
		String birthdate = sc.nextLine();
		Client client = new Client(name,email,sdf.parse(birthdate));
		
		System.out.println("");
		System.out.print("Enter the Order Status: ");
		String orderstatus = sc.next();
		
		Date date = new Date();
		Order order = new Order(date, OrderStatus.valueOf(orderstatus), client);
		
		System.out.println("");
		System.out.print("How many items to this order? ");
		int manyitens = sc.nextInt();
		
		for (int i = 1; i<=manyitens; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String pname = sc.nextLine();
			System.out.print("Product price: ");
			double pprice = sc.nextDouble();
			System.out.print("Product Quantity: ");
			int pquantity = sc.nextInt();
			
			OrderItem orderitem = new OrderItem(pquantity, new Product(pname, pprice));
			order.addItem(orderitem);			
		}
		
		System.out.println("");
		System.out.println("ORDER SUMARY: ");
		System.out.println("Order moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order status: " + order.getStatus());
		System.out.println(client.toString());
		System.out.println("--------------------------");
		System.out.println("Order Itens: ");
		System.out.println(order.toString());
		
		
		
		
		sc.close();

	}

}
