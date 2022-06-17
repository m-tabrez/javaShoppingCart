package com.basicShoppingCart.learnCleaverly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shoppingCartRunner {

	static int choice = 0;
	static Scanner scan = new Scanner(System.in);
	static Customer customer = null;

	static List<Product> products = List.of(new Product("P101", "Nokia-C20", "Mobiles", 20, 2000),
			new Product("P102", "One-Plus Lite", "Mobiles", 25, 5000),
			new Product("P103", "Noise Pulse", "Smart Watch", 10, 1000),
			new Product("P104", "Apple Ear Buds", "Head Phones", 20, 1000),
			new Product("P105", "Portronics Ear Buds", "Head Phones", 30, 500));

	static List<Product> allProducts = new ArrayList<>(products);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			showProducts();
			System.out.println("1. Add product to cart");
			System.out.println("2. View Cart Items");
			System.out.println("3. Remove product from cart");
			System.out.println("4. Exit");
			System.out.println("");
			System.out.println("Enter your choice");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				if (customer == null) {
					getCustomerDetails();
				}
				getProductDetailandAddToCart();
				break;
			case 2:
				CartService.viewCartItems();
				break;
			case 3:
				CartService.deleteCartItem(customer.getId());
				break;
			default:
				System.out.println("Thank you");
				break;

			}
		} while (choice < 4);

	}

	private static void getProductDetailandAddToCart() {
		// TODO Auto-generated method stub
		System.out.println("Enter Product Id");
		String prodId = scan.next();
		System.out.println("Enter Quantity");
		int qty = scan.nextInt();

		Product custSelectedProduct = findProductById(prodId);
		CartService.addProductToCart(custSelectedProduct, qty, customer.getId());
		System.out.println("");
	}

	private static void getCustomerDetails() {
		// TODO Auto-generated method stub

		System.out.println("Enter Customer Id");
		String customerId = scan.next();
		System.out.println("Enter Customer Name");
		String customerName = scan.next();
		System.out.println("Enter Customer City");
		String customerCity = scan.next();

		customer = new Customer(customerId, customerName, customerCity);
	}

	private static void showProducts() {
		// TODO Auto-generated method stub
		System.out.printf("%-8s %-20s %-15s %-8s %-8s", "PROD-ID", "NAME", "CATEGORY", "PRICE", "QTY-AVL").println();
		System.out.println("-----------------------------------------------------------------------");
		for (Product p : allProducts) {
			System.out.printf("%-8s %-20s %-15s %-8s %-8d", p.getId(), p.getName(), p.getCategory(), "$" + p.getPrice(),
					p.getQoh()).println();

		}
		System.out.println("");
	}

	static Product findProductById(String prodId) {
		Product product = null;
		for (Product p : allProducts) {
			if (p.getId().equals(prodId)) {
				product = p;
			}
		}
		return product;
	}


}
