package com.example.finalprojtask2.models;


//what the info of object
public class DataModel {

    String name;
    String version;
    int id_;
    int image;

    public DataModel(String name, String version, int id_, int image) {
        this.name = name;
        this.version = version;
        this.id_ = id_;
        this.image=image;
    }


    public String getName() {
        return name;
    }


    public String getDesc() {
        return version;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id_;
    }


}