package com.example.model;

/**
 * Created by Mateusz on 2015-06-28.
 */
public class GenreChart {
    private String name;
    private Long count;

    public GenreChart(String name, Long count){
        this.name = name;
        this.count = count;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {

        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
