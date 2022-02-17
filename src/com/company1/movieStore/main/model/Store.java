package com.company1.movieStore.main.model;

import java.util.ArrayList;


public class Store {
    private ArrayList<Movie> movies;

    public Store(ArrayList<Movie> movies) {
        this.movies = new ArrayList<Movie>();
        for (Movie movie : movies){
            this.movies.add(movie);
        }
    }

    public Store(){
        this.movies = new ArrayList<Movie>();
    }

    public void setMovie(int index, Movie movie){
        if (index < 0){
            throw new IllegalArgumentException("Index can not less than 0!");
        }else if (movie == null){
            throw new IllegalArgumentException("Movie can not be null!");
        }
        movies.set(index, movie);
    }

    public Movie getMovie(String name){
        if (name.isBlank() || name == null){
            throw new IllegalArgumentException("Name is empty!");
        }
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equalsIgnoreCase(name)){
                return new Movie(movies.get(i));
            }
        }
        System.out.println("Sorry we can not find match!");
        return null;
    }

    public Movie getMovie(int index){
        if (index < 0){
            throw new IllegalArgumentException("Movie Id can not be less than 0!");
        }
        return new Movie(movies.get(index));
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public boolean sellMovie(Movie movie){
        if (movie == null){
            throw new IllegalArgumentException("Please chose a movie!");
        }else {
            movies.remove(movie);
        }return true;
    }

    public void action(String name, String action) {
        if (movies.isEmpty()) {
            throw new IllegalStateException("Store not in a valid state to perform action");
        }
        if (!(action.equals("sell") || action.equals("rent") || action.equals("return"))) {
            throw new IllegalArgumentException("action must be sell, rent or return");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getName().equals(name)) {
                switch (action) {
                    case "sell":
                        if (!(movies.get(i).isAvailable())) {
                            throw new IllegalStateException("Cannot sell movie that was rented out");
                        }
                        this.movies.remove(i); break;
                    case "rent": this.movies.get(i).setAvailable(false); break;
                    case "return": this.movies.get(i).setAvailable(true); break;
                }
            }
        }
    }

    public void removeMovie(String name){
        if (name.isBlank() || name == null){
            throw new IllegalArgumentException("Invalid name!");
        }
        Movie match = movies.stream().filter((movie) -> movie.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
        if (match != null){
            movies.remove(match);
        }else {
            System.out.println("Sorry we can not find match!");
        }
    }


    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }


}
