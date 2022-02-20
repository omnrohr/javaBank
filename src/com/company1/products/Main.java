package com.company1.products;

import com.company1.products.models.Pants;
import com.company1.products.models.Product;
import com.company1.products.models.Shirt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  
    static final String FILE_NAME = "D:\\bankProject\\src\\com\\company1\\products\\products.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Product[] products = getDAta();
        Arrays.sort(products);
        printArray(products);

    }

    public static void printArray(Product[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Function Name: getData
     * @return Product[]
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   1. Loads the data from products.txt
     */
    public static Product[] getDAta() throws FileNotFoundException{
        Product[] products = new Product[18];
        FileInputStream fis = new FileInputStream(FILE_NAME);
        Scanner scan = new Scanner(fis);
        for (int i = 0; i < products.length; i++) {
            switch (scan.next()){
                case "PANTS":
                    products[i] = new Pants(scan.nextInt(),scan.nextDouble(),scan.next(), scan.nextLine()); break;

                case "SHIRT":
                    products[i] = new Shirt(Shirt.Size.valueOf(scan.next()), scan.nextDouble(),scan.next(), scan.next()); break;

            }
        }

        return products;
    }
}
