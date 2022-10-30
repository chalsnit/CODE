/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author nghia
 */
class CarsComparator implements Comparator<Cars> {

    @Override
    public int compare(Cars s1, Cars s2) {
        return s1.getBrandName().compareTo(s2.getBrandName());
    }
}

public class CarsManager extends Cars {

    Vector<Cars> dataCarsList = new Vector();
    Vector<Cars> dataCarsList2 = new Vector();
    BrandsManager brands = new BrandsManager();

    public void inputFile() {
        dataCarsList.clear();
        boolean cont = false;
        int i;
        do {
            try {
                FileReader fileInput = new FileReader("C:\\Users\\nghia\\destop\\Desktop\\CHUYENNGANH2\\PPRO192\\CODE\\Assignment\\src\\DTO\\Cars.txt");
                BufferedReader br = new BufferedReader(fileInput);
                String line = br.readLine();

                while (line != null && line != "") {
                    //    System.out.println(line);
                    StringTokenizer st = new StringTokenizer(line, ",", false);
                    while (st.hasMoreTokens()) {
                        String ID = st.nextToken().trim();
                        if (ID == null || ID.equals("") || searchID(ID) >= 0) {
                            //  System.out.println("");
                            System.out.println("\nERROR ID cars already exists or error");
                            throw new Exception();
                        }
                        String brandID;
                        String color;
                        String frameID;
                        String engineID;

                        brandID = st.nextToken().trim();
                        if (brandID == null || brandID.equals("")) {
                            System.out.println("\nERROR brandID");
                            throw new Exception();
                        }
                        color = st.nextToken().trim();
                        if (color == null || color.equals("")) {

                            System.out.println("\nERROR color");
                            throw new Exception();
                        }
                        frameID = st.nextToken().trim();
                        String pattern = "^F[0-9]{5}$";
                        if (frameID == null || frameID.equals("") || !frameID.matches(pattern) || searchFrameID(frameID) >= 0) {
                            System.out.println("\nERROR frameID");
                            throw new Exception();
                        }

                        engineID = st.nextToken().trim();
                        pattern = "^E[0-9]{5}$";
                        if (engineID == null || engineID.equals("") || !engineID.matches(pattern)) {
                            System.out.println("\nERROR engineID");
                            throw new Exception();
                        }

                        dataCarsList.add(new Cars(ID, brandID, color, frameID, engineID));
                        // System.out.println(new Cars(ID, brandID, color, frameID, engineID));

                        line = br.readLine();
                        cont = false;
                    }

                    // System.out.println(line);
                }
                br.close();
                fileInput.close();

            } catch (Exception e) {

                System.out.println("Please, Check input and press ENTER to continue");
                Scanner sc = new Scanner(System.in);
                String st = sc.nextLine();
                cont = true;
                dataCarsList.clear();

            }
        } while (cont);

        System.out.println("Input Cars done");
    }

    public void importBrandsName() {
        dataCarsList2.clear(); // clear vector truoc khi nhap vao de tranh trung lap
        brands.inputFile();
        String brandID;
        String ID;
        String color;
        String frameID;
        String engineID;
        String brandName;

        for (int i = 0; i < dataCarsList.size(); i++) {
            brandID = dataCarsList.get(i).getBrandID();
            ID = dataCarsList.get(i).getID();
            color = dataCarsList.get(i).getColor();
            frameID = dataCarsList.get(i).getFrameID();
            engineID = dataCarsList.get(i).getEngineID();
            brandName = brands.dataBrandsList.get(brands.searchID(brandID)).getBrandName();
            dataCarsList2.add(new Cars(ID, brandID, color, frameID, engineID, brandName));

        }

    }

    public void listAllCars() {
        System.out.println("\n----List all cars----");
        for (int i = 0; i < dataCarsList.size(); i++) {
            System.out.println(dataCarsList.get(i).getID() + ", " + dataCarsList.get(i).getBrandID() + ", " + dataCarsList.get(i).getColor() + ", " + dataCarsList.get(i).getFrameID() + ", " + dataCarsList.get(i).getEngineID());
        }
    }

    public void listAllCarsInAscending() {
        importBrandsName();

        Collections.sort(dataCarsList2, new CarsComparator());

        for (int i = 0; i < dataCarsList2.size(); i++) {
            System.out.println(dataCarsList2.get(i));
        }

    }

    public int searchID(String brandID) {
        for (int i = 0; i < dataCarsList.size(); i++) {
            if (dataCarsList.get(i).getID().equals(brandID)) {

//                System.out.println(brandID);
                return i;
            }
        }
        return -1;
    }

    public int searchFrameID(String frameID) {
        for (int i = 0; i < dataCarsList.size(); i++) {
            if (dataCarsList.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1;
    }

    public void listCarsBaseOnAPartOfInput() {
        importBrandsName();
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a part of brand name which you want search");
        String brandName = sc.nextLine();
        for (int i = 0; i < dataCarsList2.size(); i++) {
            if (dataCarsList2.get(i).getBrandName().contains(brandName)) {
                count++;
                System.out.println(dataCarsList2.get(i).getID() + ", " + dataCarsList2.get(i).getBrandID() + ", " + dataCarsList2.get(i).getColor() + ", " + dataCarsList2.get(i).getFrameID() + ", " + dataCarsList2.get(i).getEngineID());
            }
        }

        if (count == 0) {
            System.out.println("No car is detected!");
        }
    }

    public void addANewCar() {

        System.out.println("\n----Add a new car----");
        inputFile();
        dataCarsList2.clear();
        System.out.println("Input car");
        boolean cont = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();

                //    System.out.println(line);
                StringTokenizer st = new StringTokenizer(line, ",", false);
                while (st.hasMoreTokens()) {
                    String ID = st.nextToken().trim();
                    if (ID == null || ID.equals("") || searchID(ID) >= 0) {
                        //  System.out.println("");
                        System.out.println("\nERROR ID cars already exists or error");
                        throw new Exception();
                    }
                    String brandID;
                    String color;
                    String frameID;
                    String engineID;

                    brandID = st.nextToken().trim();
                    if (brandID == null || brandID.equals("")) {
                        System.out.println("\nERROR brandID");
                        throw new Exception();
                    }

                    color = st.nextToken().trim();
                    if (color == null || color.equals("")) {

                        System.out.println("\nERROR color");
                        throw new Exception();
                    }
                    frameID = st.nextToken().trim();
                    String pattern = "^F[0-9]{5}$";
                    if (frameID == null || frameID.equals("") || !frameID.matches(pattern) || searchFrameID(frameID) >= 0) {
                        System.out.println("\nERROR frameID");
                        throw new Exception();
                    }

                    engineID = st.nextToken().trim();
                    pattern = "^E[0-9]{5}$";
                    if (engineID == null || engineID.equals("") || !engineID.matches(pattern)) {
                        System.out.println("\nERROR engineID");
                        throw new Exception();
                    }

                    dataCarsList.add(new Cars(ID, brandID, color, frameID, engineID));
                    // System.out.println(new Cars(ID, brandID, color, frameID, engineID));

                    cont = false;

                }

                // System.out.println(line);
            } catch (Exception e) {

                System.out.println("Please, Check and input again");

                cont = true;
            }
        } while (cont);

        System.out.println("Add new car success");
    }

    public void removeCar() {
        System.out.println("\n----Remove a new car----");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ID car to remove");
        String line = sc.nextLine();
        int pos = searchID(line);
        if (pos < 0) {
            System.out.println("Not found");
        } else {
            dataCarsList.remove(pos);
            System.out.println("Remove successfully");
        }

    }

    public void updateCar() {
        System.out.println(" \n---- UPDATE CAR ---- ");
        boolean cont = false;
        System.out.println("Which Car do you want update?: ");

        do {
            try {
                Scanner sc = new Scanner(System.in);
                String brandID = sc.nextLine();

                // System.out.println(searchID(brandID));
                if (searchID(brandID) == -1) {
                    throw new Exception();
                } else if (searchID(brandID) >= 0) {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.println("ERROR. Brand is  not found\nInput again");
                cont = true;

            }
        } while (cont);

        System.out.println("How do you want to update?: ");
        do {
            try {
                Scanner sc2 = new Scanner(System.in);
                String st2 = sc2.nextLine();
                StringTokenizer st = new StringTokenizer(st2, ",", false);
                while (st.hasMoreTokens()) {
                    String ID = st.nextToken().trim();
                    if (ID == null || ID.equals("") || searchID(ID) >= 0) {
                        //  System.out.println("");
                        System.out.println("\nERROR ID cars already exists or error");
                        throw new Exception();
                    }
                    String brandID;
                    String color;
                    String frameID;
                    String engineID;

                    brandID = st.nextToken().trim();
                    if (brandID == null || brandID.equals("")) {
                        System.out.println("\nERROR brandID");
                        throw new Exception();
                    }

                    color = st.nextToken().trim();
                    if (color == null || color.equals("")) {

                        System.out.println("\nERROR color");
                        throw new Exception();
                    }
                    frameID = st.nextToken().trim();
                    String pattern = "^F[0-9]{5}$";
                    if (frameID == null || frameID.equals("") || !frameID.matches(pattern) || searchFrameID(frameID) >= 0) {
                        System.out.println("\nERROR frameID");
                        throw new Exception();
                    }

                    engineID = st.nextToken().trim();
                    pattern = "^E[0-9]{5}$";
                    if (engineID == null || engineID.equals("") || !engineID.matches(pattern)) {
                        System.out.println("\nERROR engineID");
                        throw new Exception();
                    }

                    dataCarsList.add(new Cars(ID, brandID, color, frameID, engineID));
                    // System.out.println(new Cars(ID, brandID, color, frameID, engineID));

                    cont = false;

                }

            } catch (Exception e) {
                System.out.println("Input again\n");
                cont = true;
            }

        } while (cont);

    }

    public void saveToFile() throws IOException {
        File f = new File("C:\\Users\\nghia\\destop\\Desktop\\CHUYENNGANH2\\PPRO192\\CODE\\Assignment\\src\\DTO\\Cars.txt");
        FileWriter fw = new FileWriter(f); //
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < dataCarsList.size(); i++) {
            if (dataCarsList.get(i) != null) {
                String s = "";
                s += dataCarsList.get(i) + "\n";
                pw.write(s);
            }
        }
        System.out.println("Data successfully ");
        fw.close();
        pw.close();

    }

//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        CarManager car = new CarManager();
//        car.inputFile();
//        //car.listAllCarsInAscending();
//        // car.listCarsBaseOnAPartOfInput();
//        //System.out.println(car.brands.dataBrandsList.get(0).getBrandName());
//        car.listAllCars();
//        car.removeCar();
//        car.listAllCars();
//
//    }
}
