/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica;

import java.awt.Image;


/**
 *
 * @author simon
 */
public class Contact {
    private String name;
    private String surname;
    private Email email;
    private PhoneNumber phoneNumber;
    private String description;
    
     public Contact(String name, String surnme, Email email, PhoneNumber phoneNumber, String description){
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.description=description;
    }
     
     public String getName(){
         return this.name;
     }
     public void setName(String name){
         this.name=name;
     }
     
     public String getSurname(){
         return this.surname;
     }
     public void setSurname(String surname){
         this.surname=surname;
     }
     
     public Email getEmail(){
         return this.email;
     }
     
     public PhoneNumber getPhoneNumber(){
         return this.phoneNumber;
     }
     
     public String getDescription(){
         return this.description;
     }
     public void setDescription(String description){
         this.description=description;
     }
     
}
