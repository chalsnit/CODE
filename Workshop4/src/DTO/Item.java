package DTO;

import java.util.Scanner;
import GUI.AntiqueShop;
/**
 *
 * @author nghia
 */

public class Item  {

    private int value;
    private String creator;

    public  Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void input() {
         boolean cont = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter the value: ");
            int value = Integer.parseInt(sc.nextLine());
            try {
                if (value > 0) {
                    System.out.print("Enter the creator: ");
                    String creator = sc.nextLine();
                    if (creator.isEmpty()) throw new Exception();
                    else {
                        setValue(value);
                        setCreator(creator);
                        cont = false;
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Error! Try again");
                cont = true;
            }
        } while (cont);
    }

    public void output() {
       
        System.out.println();
        System.out.println("Value: " + this.value);
        System.out.println("Creator: " + this.creator);

    }

}
