/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sad_saple.Model;

/**
 *
 * @author nobody
 */
public class Order {
   private int id;
   private String product_id;
    private String address;
    private String Time;
    private int quantity;
    private String status;

    public Order(int id,String pro_id, String Address, String Time, int quantity, String status) {
        this.id = id;
        this.product_id=pro_id;
        this.address = Address;
        this.Time = Time;
        this.quantity = quantity;
        this.status = status;
    }

    public Order(String pro_id, String Address, String Time, int quantity, String status) {
        this.product_id=pro_id;
        this.address = Address;
        this.Time = Time;
        this.quantity = quantity;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
