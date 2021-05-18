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
public class Account {

    private int id;
    private String name;
    private String PW;
    private String role;

    public Account() {
    }

    public Account(String name, String PW, String role, int id) {
        this.id = id;
        this.name = name;
        this.PW = PW;
        this.role = role;
    }

    public Account(String name, String PW, String role) {

        this.name = name;
        this.PW = PW;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

}
