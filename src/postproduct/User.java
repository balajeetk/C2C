/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postproduct;

import com.mysql.jdbc.Blob;

/**
 *
 * @author ELCOT
 */
class User {

    private String productname, description, brand;
    private int cost;
    private Blob Productimg;

    public User(String productname, String description, String brand, int cost, Blob Productimg ) {
        this.productname = productname;
        this.description = description;
        this.brand = brand;
        this.cost = cost;
        this.Productimg = Productimg;

    }
public User(String productname, String description, String brand, int cost ) {
        this.productname = productname;
        this.description = description;
        this.brand = brand;
        this.cost = cost;

    }

    public int getcost() {
        return cost;
    }

    public String getproductname() {
        return productname;
    }

    public String getdescription() {
        return description;
    }

    public String getbrand() {
        return brand;
    }
    
    public Blob getproductimg() {
        return Productimg;
    }

}
