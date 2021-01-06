package com.example.review11_12;

public class item_obj {

    private int img ;
    private String title ;

    public item_obj() {
    }

    public item_obj(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
