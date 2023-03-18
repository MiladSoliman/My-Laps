package com.example.recycelerview;

public class Cakes {
    private  int image_thumbnail;
    private String name ;
    private  String descreiption;


    public Cakes(int image_thumbnail ,String name,String descreiption) {
        this.image_thumbnail = image_thumbnail;
        this.name=name;
        this.descreiption=descreiption;
    }

    public String getDescreiption() {
        return descreiption;
    }

    public void setDescreiption(String descreiption) {
        this.descreiption = descreiption;
    }

    public int getImage_thumbnail() {
        return image_thumbnail;
    }

    public void setImage_thumbnail(int image_thumbnail) {
        this.image_thumbnail = image_thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
