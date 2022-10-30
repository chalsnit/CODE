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
public class Painting extends Item {

    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;

    public Painting() {

    }

    public Painting(int height, int width, boolean isWatercolour, boolean isFramed, int value, String creator) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    public void inputPainting() {
        boolean tmp = false;
        super.input();
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the height: ");
                int height = Integer.parseInt(sc.nextLine());
                if (height > 0) {
                    setHeight(height);
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
                System.out.print("Enter the width: ");
                int width = Integer.parseInt(sc.nextLine());
                if (width <= 0) {
                    throw new Exception();
                } else {
                    setWidth(width);
                    tmp = false;
                }
            } catch (Exception e) {
                System.out.println("Error! Try again");
                tmp = true;
            }
        } while (tmp);

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Is water colour? (true/false): ");
                String isWatercolor = sc.nextLine().toLowerCase();
                if (isWatercolor.equals("true")) {
                    setIsWatercolour(true);

                } else if (isWatercolor.equals("false")) {
                    setIsWatercolour(false);
                } else {
                    throw new Exception();
                }
                tmp = false;
            } catch (Exception e) {
                System.out.println("Error! Try again");
                tmp = true;
            }

        } while (tmp);

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Is Framed? (true/false): ");
                String isFramed = sc.nextLine().toLowerCase();
                if (isFramed.equals("true")) {
                    setIsFramed(true);
                } else if (isFramed.equals("false")) {
                    setIsFramed(false);
                } else {
                    throw new Exception();
                }
                tmp = false;
            } catch (Exception e) {
                System.out.println("Error! Try again");
                tmp = true;
            }

        } while (tmp);

    }

    public void output() {
        super.output();
        System.out.println("height is: " + this.height);
        System.out.println("width is: " + this.width);
        System.out.println("isWatercolour is: " + this.isWatercolour);
        System.out.println("isFramed is: " + this.isFramed);
        System.out.println("");
    }

}
