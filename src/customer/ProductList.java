/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;




public class ProductList {
    private String brand;
    private String model;
    private int price;
    private String description;
    private byte[] mimage;

    public ProductList(String brand, String model, int price,  String description, byte[] image) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.description = description;
        this.mimage = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getMimage() {
        //return new ImageIcon(new ImageIcon(mimage).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        return mimage;
    }

    public void setMimage(byte[] mimage) {
        this.mimage = mimage;
    }
    
    
    
}
