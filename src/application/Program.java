package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> pdt = new ArrayList<Product>();

		System.out.print("Enter the number of products: ");
		int numOfProduct = sc.nextInt();

		for (int i = 0; i < numOfProduct; i++) {

			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				Double customFee = sc.nextDouble();
				pdt.add(new ImportProduct(name, price, customFee));
			}
			else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				pdt.add(new UsedProduct(name, price, manufactureDate));
			}
			else {
				pdt.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product c : pdt) {
			System.out.println(c.priceTag());
		}

		sc.close();

	}

}
