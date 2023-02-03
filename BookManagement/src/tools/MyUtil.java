/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author nghia
 */
public class MyUtil {
    
    public boolean askToMain(){
        System.out.println("\nDo you wanna back to Main menu or quit?");
        System.out.println("Input Y/y to back to main menu and N/n to Quit");
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();
        return c.equalsIgnoreCase("y");
        
    }
}
