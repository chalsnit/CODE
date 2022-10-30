/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author nghia
 */
public class test {
    public static void main(String args[]) {
  String s1 = "welcome to    , split world";
  System.out.println("returning words:");
  for (String w : s1.split("\\s", 0)) {
   System.out.println(w);
  }
  System.out.println("returning words:");
  for (String w : s1.split(",")) {
   System.out.println(w);
  }
  System.out.println("returning words:");
  for (String w : s1.split("\\s", 2)) {
   System.out.println(w);
  }
 }
}
