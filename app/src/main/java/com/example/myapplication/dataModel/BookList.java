package com.example.myapplication.dataModel;

public class BookList {
    private String id,name,author,category,description,published_year,status;

    public BookList(){

    }

    public BookList(String id, String name, String author, String category, String description, String published_year, String status) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
        this.description = description;
        this.published_year = published_year;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished_year() {
        return published_year;
    }

    public void setPublished_year(String published_year) {
        this.published_year = published_year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
