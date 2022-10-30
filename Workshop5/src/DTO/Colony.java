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
public class Colony extends Organization {
    private String place;

    public Colony() {
    }

    public Colony(String place) {
        this.place = place;
    }

    public Colony(String place, int size) {
        super(size);
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    public void grow()
    {
        System.out.println("an annual cycle of growth that begins in spring");
    }
    
    public void reproduce()
    {
        System.out.println("Colony can reproduce itself through a process");
    }
    
    
    public String toString() {
        return ("The colony size is "+ super.getSize() +" the colony's place is "+place);
    }
  
    
    
    
    
    
    

    void communicateByTool() {
      System.out.println("the colony communicate by sound");
    }
    
    
}
