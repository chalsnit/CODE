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
public class Statue extends Item {

    private int weight;
    private String colour;

    public Statue() {

    }

    public Statue(int weight, String colour, int value, String creator) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void inputStatue() {
        super.input();
        boolean tmp = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("\nEnter the weight: ");
                weight = Integer.parseInt(sc.nextLine());

                if (weight > 0) {
                    setWeight(weight);
                    tmp = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error! Try again");
                tmp = true;
            }
        } while (tmp);

        tmp = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the colour: ");
                colour = sc.nextLine();

                if (colour.isEmpty()) {
                    throw new Exception();
                } else {

                    setColour(colour);
                    tmp = false;
                }

            } catch (Exception e) {
                System.out.println("Error! Try again");
                tmp = true;
            }
        } while (tmp);

    }

    public void output() {
        super.output();
        System.out.println("Weight is: " + this.weight);
        System.out.println("Colour is: " + this.colour);
        System.out.println("");

    }

}
