package com.example.error_tast1;

public class row_obj {

    private int image;
    private String title;
    private String des ;

    public row_obj(int image, String title, String des) {

        this.image = image;
        this.title = title;
        this.des = des;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
