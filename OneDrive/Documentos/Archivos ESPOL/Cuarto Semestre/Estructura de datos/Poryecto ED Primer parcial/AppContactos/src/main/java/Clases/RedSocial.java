/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Carlos
 */
public class RedSocial {
    
    private String redSocial, username;

    public RedSocial(String redSocial, String username) {
        this.redSocial = redSocial;
        this.username = username;
    }
    
    @Override
    public String toString(){
        return redSocial + ":" + username;
    }

    public String getRedSocial() {
        return redSocial;
    }

    public String getUsername() {
        return username;
    }

    public void setRedSocial(String redSocial) {
        this.redSocial = redSocial;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
