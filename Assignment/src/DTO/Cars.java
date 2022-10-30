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
public class Cars {
    private String ID;
    private String brandID;
    private String color;
    private String frameID;
    private String engineID;
    private String brandName;
    

    public Cars() {
    }

    public Cars(String ID, String brandID, String color, String frameID, String engineID, String brandName) {
        this.ID = ID;
        this.brandID = brandID;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
        this.brandName = brandName;
    }

    public Cars(String ID, String brandID, String color, String frameID, String engineID) {
        this.ID = ID;
        this.brandID = brandID;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        return   ID + ", " + brandID + ", " + color + ",  "+ frameID + ", " + engineID ;
    }
    
    
    
    
    
    
}
