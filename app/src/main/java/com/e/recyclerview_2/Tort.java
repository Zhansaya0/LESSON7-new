package com.e.recyclerview_2;

public class Tort {
    int photo;
    String title;
    int weight;
    int  price;
    String taste_rating;

    public Tort(int photo, String title, String taste_rating, int price, int weight){
        this.photo = photo;
        this.title = title;
        this.weight = weight;
        this.price = price;
        this.taste_rating=taste_rating;
    }
    public int getPhoto(){
        return photo;
    }
    public String getTitle(){
        return title;
    }
    public String getTaste_rating(){
        return taste_rating;
    }
    public int getPrice(){
        return price;
    }
    public int getWeight(){ return price; }
}
