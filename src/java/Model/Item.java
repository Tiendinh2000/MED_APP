/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.Model;

/**
 *
 * @author nobody
 */
public class Item {
  private  String id;
  private  String name;
   private int price;
    private byte[] image;
    public Item(){
    }

    public Item(String id, String name, int price, byte[] image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image=image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
   
    
}
