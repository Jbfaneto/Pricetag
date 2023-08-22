import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (type == 'c') {
                products.add(new Product(name, price));
            } else if (type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, manufactureDate));
            } else {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }
        sc.close();
    }
}