/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author nghia
 */
import java.util.Scanner;

public class Code {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       int n=7;
        Integer intObj=new Integer (5);
        System.out.println(intObj);
        System.out.println(intObj.toString());
        intObj=n;
        System.out.println(intObj);
        int y=intObj*2;
        int z=intObj.intValue();
        System.out.println("y="+", z= "+z);
        n=Integer.parseInt("1234");
        System.out.println("n= "+n);
        n=Integer.parseInt("A",16);
        System.out.println("n= "+n);

    }

}
