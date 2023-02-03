package core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nghia
 */
public class Books {
    private String bookID;
    private String bookName;
    private double bookPrice;
    private int quantity;
    private String publisherID;
    private String status;

    public Books() {
    }

    public Books(String bookID, String bookName, double bookPrice, int quantity, String publisherID, String Status) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
        this.publisherID = publisherID;
        this.status = Status;
    }

    public Books(String bookID, String bookName, double bookPrice, int quantity, String publisherID) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.quantity = quantity;
        this.publisherID = publisherID;
        status= quantity>0?"Available" : "Not Available";
    }

    
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }

    @Override
    public String toString() {
        return this.bookID + ", " + this.bookName + ", " + this.bookPrice + ", " + this.quantity + ", " + this.publisherID + ", " + this.status ;
    }
    
    
    
}
