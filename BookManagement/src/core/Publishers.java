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
public class Publishers {
    private String publisherId;
    private String publisherName;
    private String phone;

    public Publishers() {
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String PublisherId) {
        this.publisherId = PublisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String PublisherName) {
        this.publisherName = PublisherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public Publishers(String PublisherId, String PublisherName, String Phone) {
        this.publisherId = PublisherId;
        this.publisherName = PublisherName;
        this.phone = Phone;
    }

    @Override
    public String toString() {
        return  publisherId + ", " + publisherName + ", " + phone ;
    }
    
    
}
