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
public class Disease {
    private int id;
    private String name;
    private String AccountName;
    private String comment;

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public Disease(int id, String name,String AccountName, String comment) {
        this.id = id;
        this.name = name;
        this.AccountName=AccountName;
        this.comment = comment;
    }

    public Disease(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
}
