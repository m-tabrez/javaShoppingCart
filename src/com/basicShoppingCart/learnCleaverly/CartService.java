package com.basicShoppingCart.learnCleaverly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartService {

	static List<CartItem> cartItems = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);

	public static void addProductToCart(Product prod, int qty, String custId) {
		CartItem item = new CartItem(prod.getId(), custId, qty, prod.getPrice());

		CartItem temp = null;
		int index = -1;
		for (CartItem c : cartItems) {
			index++;
			if (c.getCustId().equals(custId) && c.getProdId().equals(prod.getId())) {
				temp = c;
				break;
			}
		}

		if (temp == null) {
			cartItems.add(item);
			System.out.println("Product Added to Cart Successfully");
			prod.setQoh(prod.getQoh() - qty);
		} else {
			temp.setQty(temp.getQty() + qty);
			cartItems.set(index, temp);
			System.out.println("Product Qunatity updated to Cart");
			prod.setQoh(prod.getQoh() - qty);
		}


	}

	public static void viewCartItems() {
		// TODO Auto-generated method stub
		System.out.printf("%-8s %-20s %-15s %-8s %-8s %-8S", "PROD-ID", "NAME", "CATEGORY", "PRICE", "QTY", "Total")
				.println();
		System.out.println("-----------------------------------------------------------------------");
		for (CartItem c : cartItems) {
			Product temp = shoppingCartRunner.findProductById(c.getProdId());
			int total = temp.getPrice() * c.getQty();
			System.out.printf("%-8s %-20s %-15s %-8s %-8d %-8s ", temp.getId(), temp.getName(), temp.getCategory(),
					"$" + temp.getPrice(), c.getQty(), "$" + total).println();
		}
		System.out.println("");
	}

	public static void deleteCartItem(String custId) {
		// TODO Auto-generated method stub
		System.out.println("Enter Prod Id");
		String prodId = scan.next();
		System.out.println("Enter Quantity");
		int qty = scan.nextInt();

		CartItem temp = null;
		Product prod = shoppingCartRunner.findProductById(prodId);
		int index = -1;
		for (CartItem c : cartItems) {
			index++;
			if (c.getCustId().equals(custId) && c.getProdId().equals(prodId)) {
				temp = c;
				break;
			}
		}

		if (temp == null) {
			System.out.println("Kindly Enter a valid prodId again by selecting delete cart option");
		} else {
			if (temp.getQty() <= qty) {
				cartItems.remove(index);
				System.out.println("Item Removed from the cart");
			} else {
				temp.setQty(temp.getQty() - qty);
				cartItems.set(index, temp);
				System.out.println("Cart Updated");
			}

			prod.setQoh(prod.getQoh() + qty);
			System.out.println("");

		}

	}



}
