package com.example.e_commerce.model;

public class AllCategory
{
    private String title;
    private int images;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String desc;

    private String price;

    public AllCategory(String title, int images,String desc,String price)
    {
        this.title = title;
        this.images = images;
        this.desc =desc;
        this.price=price;
    }

    public String getTitle()
    {
        return title;
    }

    public int getImages()
    {
        return images;
    }
}