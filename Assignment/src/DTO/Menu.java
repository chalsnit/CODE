package DTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nghia
 */
public class Menu extends BrandsManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<String> options = new ArrayList<>();
        options.add("1. List all bands");
        options.add("2. Add a new brand");
        options.add("3. Search a brand based on its ID");
        options.add("4. Update a brand");
        options.add("5. Save brands to the file");
        options.add("6. List all cars in ascending order of brand names");
        options.add("7. List cars based on a part of an input brand name");
        options.add("6. Add a Car");
        options.add("9. Remove a car based on its ID");
        options.add("10. Update a car based on its ID");
        options.add("11. Save cars to file\n");
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        BrandsManager bm = new BrandsManager();
        bm.inputFile();
        CarsManager cm = new CarsManager();
        cm.inputFile();
        do {
            System.out.println("\nCar managing program");

            for (int i = 0; i < options.size(); i++) {
                System.out.println(options.get(i));
            }
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    bm.listAllBrands();
                    break;

                case 2:
                    bm.addANewBrand();
                    break;

                case 3:
                    bm.showBrand();
                    break;

                case 4:
                    bm.updateBrand();
                    break;

                case 5:
                    bm.saveToFile();
                    break;

                case 6:
                    cm.listAllCarsInAscending();
                    ;
                    break;

                case 7:
                    cm.listCarsBaseOnAPartOfInput();
                    break;

                case 8:
                    cm.addANewCar();
                    break;

                case 9:
                    cm.removeCar();
                    break;

                case 10:
                    cm.updateCar();
                    break;

                case 11:
                    cm.saveToFile();
                    break;

                default:
                    System.out.println("Bye!");
            }
        } while (choice > 0 && choice <= 11);
    }

}
