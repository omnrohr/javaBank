package com.company1.movieStore.main.model;

import java.util.Objects;

public class Movie {
    private String name;
    public enum Format {DVD , BLUE_RAY};
    private Format format;
    private int rating;
    private float sellingPrice;
    private float rentalPrice;
    private boolean isAvailable;

    public Movie(String name, Format format, int rating, boolean isAvailable) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name value!");
        }else if(rating < 0){
            throw new IllegalArgumentException("Rating can not be negative value!");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = (format == Format.DVD) ? 2.25f:4.25f;
        this.rentalPrice = (format == Format.BLUE_RAY) ? 0.99f: 1.99f;
        this.isAvailable = isAvailable;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice;
        this.isAvailable = source.isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating < 0){
            throw new IllegalArgumentException("Invalid rating!");
        }
        this.rating = rating;
    }

    private float getSellingPrice() {
        return sellingPrice;
    }

    private void setSellingPrice(Format format) {
        this.sellingPrice = (format == Format.DVD) ? 2.25f : 4.25f;
    }

    public float getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Format format) {
        this.rentalPrice = (format == Format.DVD) ? .99f: 1.99f;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, format, rating, sellingPrice, rentalPrice, isAvailable);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (!(obj instanceof  Movie)) return false;
        Movie movie = (Movie) obj;
        return (this.name.equals(movie.name)
        && this.format.equals(movie.format)
        && this.rating == movie.rating
        && this.rentalPrice == movie.rentalPrice
        && this.sellingPrice == movie.sellingPrice
        && this.isAvailable == movie.isAvailable);
    }

    @Override
    public String toString(){
        return "\t Name: " + name + "\n" +
               "\t Format: " + format + "\n" +
               "\t Rating: " + rating + "\n" +
               "\t Selling Price: " + sellingPrice + "\n" +
               "\t Rental Price: " + rentalPrice + "\n" +
               "\t Availability: " + ((isAvailable) ? "in-stock" : "rented") + "\n";
    }


}
