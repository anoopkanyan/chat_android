package com.recodecommerce.chatandbuy.models;

/**
 * temporary model for holding the product information
 */
public class Product {

    String name;
    String photo;

    String seller_token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSeller_token() {
        return seller_token;
    }

    public void setSeller_token(String seller_token) {
        this.seller_token = seller_token;
    }

}
