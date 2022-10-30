package DTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nghia
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BrandsManager extends Brands {
    
    Vector<Brands> dataBrandsList = new Vector();
    
    public BrandsManager() {
    }
    
    public void inputFile() {
        dataBrandsList.clear();
        boolean cont = false;
        do {
            try {
                FileReader fileInput = new FileReader("C:\\Users\\nghia\\destop\\Desktop\\CHUYENNGANH2\\PPRO192\\CODE\\Assignment\\src\\DTO\\Brands.txt");
                BufferedReader br = new BufferedReader(fileInput);
                String line = br.readLine();
                
                while (line != null) {
//                     System.out.println(line);
                    StringTokenizer st = new StringTokenizer(line, ",:", false);
                    int tmp = 0;
                    while (st.hasMoreTokens()) {
                        String brandName;
                        String soundBrand;
                        double price;
                        String brandID = st.nextToken();
                        brandID = brandID.trim();
                        if (searchID(brandID) >= 0) {
                            System.out.println("\nERROR ID brand already exists");
                            throw new Exception();
                        }
                        brandName = st.nextToken();
                        brandName = brandName.trim();
                        // System.out.println("...."+brandName+"...");

                        if (brandName == null || brandName.equals("")) {
                            System.out.println("\nERROR brandName");
                            throw new Exception();
                        }
                        soundBrand = st.nextToken();
                        soundBrand = soundBrand.trim();
                        
                        if (soundBrand == null) {
                            
                            System.out.println("\nERROR soundBrand");
                            throw new Exception();
                        }
                        price = Double.parseDouble(st.nextToken());
                        
                        if (price < 0) {
                            
                            System.out.println("\nERROR price");
                            throw new Exception();
                        }
                        
                        dataBrandsList.add(new Brands(brandID, brandName, soundBrand, price));
                        // System.out.println(new Brands(brandID, brandName, soundBrand, price));
                        
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
                dataBrandsList.clear();
                
            }
        } while (cont);
        
        System.out.println("Input Brands done");
    }
    
    public void listAllBrands() {
        System.out.println("\n----List all brands----");
        for (int i = 0; i < dataBrandsList.size(); i++) {
            System.out.println(i + 1 + ": " + "ID: " + dataBrandsList.get(i).getID() + ", " + "Brand Name: " + dataBrandsList.get(i).getBrandName() + ", " + "Sound Brand: " + dataBrandsList.get(i).getSoundBrand() + ", " + "price: " + dataBrandsList.get(i).getPrice());
        }
    }
    
    public int searchID(String brandID) {
        for (int i = 0; i < dataBrandsList.size(); i++) {
            if (dataBrandsList.get(i).getID().equals(brandID)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isDuplicated(String brandID) {
        if (searchID(brandID) >= 0) {
            return true;
        }
        return false;
    }
    
    public void addANewBrand() {
        
        System.out.println("\n----Add a new brand----");
        boolean tmp = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                String st = sc.nextLine();
                st = st.trim();
                StringTokenizer stt = new StringTokenizer(st, ",:", false);
                while (stt.hasMoreTokens()) {
                    String brandID = stt.nextToken();
                    brandID = brandID.trim();
                    
                    String brandName;
                    String soundBrand;
                    double price;
                    if (isDuplicated(brandID) || brandID == null || brandID.equals("")) {
                        System.out.println("ID is duplicated or error");
                        throw new Exception();
                    } else {
                        brandName = stt.nextToken();
                        brandName = brandName.trim();
                        
                        if (brandName == null) {
                            System.out.println("ERROR brandName");
                            throw new Exception();
                        } else {
                            soundBrand = stt.nextToken();
                            soundBrand = soundBrand.trim();
                            if (soundBrand == null) {
                                System.out.println("ERROR soundBrand");
                                throw new Exception();
                            } else {
                                price = Double.parseDouble(stt.nextToken());
                                if (price < 0) {
                                    System.out.println("ERROR price");
                                    throw new Exception();
                                } else {
                                    dataBrandsList.add(new Brands(brandID, brandName, soundBrand, price));
                                    tmp = false;
                                }
                            }
                            
                        }
                    }
                    
                }
                
            } catch (Exception e) {
                System.out.println("Error. Input again!");
                tmp = true;
            }
        } while (tmp);
        
    }
    
    public void showBrand() {
        System.out.println(" \n---- Search a brand based on it’s ID ---- ");
        System.out.println("  Input the ID brand you wanna search  ");
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        if (searchID(st) > 0) {
            System.out.println("Brands result is " + dataBrandsList.get(searchID(st)));
        } else {
            System.out.println("Brands is not found");
        }
    }
    
    public void updateBrand() {
        System.out.println(" \n---- UPDATE BRAND ---- ");
        boolean cont = false;
        System.out.println("Which brand do you want update?: ");
        String brandID = null;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                String st = sc.nextLine();
                StringTokenizer stt = new StringTokenizer(st, ",:", false);
                brandID = stt.nextToken();
                // System.out.println(searchID(brandID));
                if (searchID(brandID) == -1) {
                    throw new Exception();
                } else if (searchID(brandID) >= 0) {
                    cont = false;
                }
            } catch (Exception e) {
                System.out.println("ERROR. Brand is  not found\nInput again");
                brandID = null;
                cont = true;
                
            }
        } while (cont);
        
        System.out.println("How do you want to update?: ");
        do {
            try {
                Scanner sc2 = new Scanner(System.in);
                String st2 = sc2.nextLine();
                StringTokenizer stt = new StringTokenizer(st2, ",:", false);
                while (stt.hasMoreTokens()) {
                    String brandID2 = stt.nextToken();
                    String brandName;
                    String soundBrand;
                    double price;
                    brandName = stt.nextToken();
                    if (brandName == null) {
                        System.out.println("ERROR brandName");
                        throw new Exception();
                    } else {
                        soundBrand = stt.nextToken();
                        if (soundBrand == null) {
                            System.out.println("ERROR soundBrand");
                            throw new Exception();
                        } else {
                            price = Double.parseDouble(stt.nextToken());
                            if (price < 0) {
                                System.out.println("ERROR price");
                                throw new Exception();
                            } else {
                                dataBrandsList.set(searchID(brandID), new Brands(brandID2, brandName, soundBrand, price));
                                cont = false;
                                //  System.out.println(new Brands(brandID2, brandName, soundBrand, price));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Input again\n");
                cont = true;
            }
            
        } while (cont);
        
    }
    
    public void saveToFile() throws IOException {
        File f = new File("C:\\Users\\nghia\\destop\\Desktop\\CHUYENNGANH2\\PPRO192\\CODE\\Assignment\\src\\DTO\\Brands.txt");
        FileWriter fw = new FileWriter(f); //
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < dataBrandsList.size(); i++) {
            if (dataBrandsList.get(i) != null) {
                String s = "";
                s += dataBrandsList.get(i) + "\n";
                pw.write(s);
            }
        }
        System.out.println("Data successfully ");
        fw.close();
        pw.close();
        
    }

//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        BrandsManager BM = new BrandsManager();
//        BM.inputFile();
//        BM.listAllBrands();
//        BM.addANewBrand();
//        BM.listAllBrands();
//        BM.updateBrand();
//        BM.listAllBrands();
//        BM.showBrand();
//        BM.saveToFile();
//
//    }
}
