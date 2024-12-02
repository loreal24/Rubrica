/**
*@file Contact.java
*@brief This file contains the implementation of the Contact feature
*
*More deetailed information about the file and its role in the project.
*@author simon
*@date December 2, 2024
*/
package gruppo22.rubrica;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import java.awt.Image;


public class Contact {
    private String name;
    private String surname;
    private Email email;
    private PhoneNumber phoneNumber;
    private String description;
    
    /**
     * @brief Constructor
     * @pre 'name!="" && surname!=""' The input name or surname can't be empty
     *
     * @param[in] name
     * @param[in] surname
     * @param[in] email
     * @param[in] phoneNumber
     * @param[in] description 
     */
    public Contact(String name, String surname, Email email, PhoneNumber phoneNumber, String description)/*throws InvalidContactException*/{
        //if(name.equals("") && surname.equals(""))
            //throw new InvalidContactException("I campi nome e cognome non possono essere entrambi vuoti");
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.description=description;
    }
     /**
      * 
      * @return 
      */
     public String getName(){
         return this.name;
     }
     /**
      * 
      * @param name 
      */
     public void setName(String name){
         this.name=name;
     }
     /**
      * 
      * @return 
      */
     public String getSurname(){
         return this.surname;
     }
     /**
      * 
      * @param surname 
      */
     public void setSurname(String surname){
         this.surname=surname;
     }
     /**
      * 
      * @return 
      */
     public Email getEmail(){
         return this.email;
     }
     /**
      * 
      * @return 
      */
     public PhoneNumber getPhoneNumber(){
         return this.phoneNumber;
     }
     /**
      * 
      * @return 
      */
     public String getDescription(){
         return this.description;
     }
     /**
      * 
      * @param description 
      */
     public void setDescription(String description){
         this.description=description;
     }
     
}
