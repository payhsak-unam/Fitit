package com.example.fitit.Model;

public class Trainer {
    private String name,title;
    private int exp;
    private float rating;
    private String drawableResources;

    public Trainer() {
    }

    public Trainer(String drawableResources) {
        this.drawableResources = drawableResources;
    }


    public Trainer(String name, String title, int exp, float rating, String drawableResources) {
        this.name = name;
        this.title = title;
        this.exp = exp;
        this.rating = rating;
        this.drawableResources = drawableResources;
    }

    public String getName() {
        return name;
    }

    public void setName(String company) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDrawableResources() {
        return drawableResources;
    }

    public void setDrawableResources(String drawableResources) {
        this.drawableResources = drawableResources;
    }
}
