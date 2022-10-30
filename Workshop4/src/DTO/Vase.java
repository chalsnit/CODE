/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author nghia
 */
public class Vase extends Item {

    private int height;
    private String material;

    public Vase() {

    }

    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void inputVase() {

        boolean cont = false;
        super.input();
        do {
            try {
                
                Scanner sc = new Scanner(System.in);
                int height;
                System.out.print("Enter the height: ");
                height = Integer.parseInt(sc.nextLine());
                setHeight(height);
                if (height <= 0) {
                    throw new Exception();
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                cont = true;
                System.out.println("Error! Try again");
            }
        } while (cont);
        cont = false;
        do {
            try {
                
                Scanner sc = new Scanner(System.in);
               
                String material;
                System.out.print("Enter the material: ");
                material = sc.nextLine();
                setMaterial(material);

                if ( material.equals("")) {
                    throw new Exception();
                } else {
                    cont = false;
                }
            } catch (Exception e) {
                cont = true;
                System.out.println("Error! Try again");
            }
        } while (cont);
        
    }

    public void output() {
        super.output();
        System.out.println("Height is:" + this.height);
        System.out.println("Height is:" + this.material);
        System.out.println("");
    }

}
