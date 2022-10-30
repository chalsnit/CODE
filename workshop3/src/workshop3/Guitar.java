package workshop3;

import java.util.Scanner;

/**
 *
 * @author nghia
 */
public class Guitar {

    private String serialNumber;
    private Integer price;
    private String builder;
    private String model;
    private String backWood;
    private String topWood;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        if (!"".equals(serialNumber)) {
            this.serialNumber = serialNumber;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBackWood() {
        return backWood;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

    public Guitar() {
        this.serialNumber = null;
        this.backWood = null;
        this.builder = null;
        this.model = null;
        this.topWood = null;
        this.price = null;
    }

    public Guitar(String serialNumber, int price, String builder, String model, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.backWood = backWood;
        this.builder = builder;
        this.model = model;
        this.topWood = topWood;
        this.price = price;
    }

    public void createSound() {
        System.out.println("");
        System.out.println("serialNumber is " + this.serialNumber);
        System.out.println("backWood is " + this.backWood);
        System.out.println("builder is " + this.builder);
        System.out.println("model is " + this.model);
        System.out.println("topWood is " + this.topWood);
        System.out.println("price is " + this.price);
        System.out.println("");
    }
}
