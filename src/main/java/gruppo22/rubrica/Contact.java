/**
*@file Contact.java
*@brief This file contains the implementation of the Contact feature
*
*More detailed information about the file and its role in the project.
*@author simon
*@date December 2, 2024
*/
package gruppo22.rubrica;


public class Contact {
    private String name;
    private String surname;
    private Email email;
    private PhoneNumber phoneNumber;
    private String description;
    
    /**
     * @brief Constructor
     * @pre 'name!="" && surname!=""' The input name and surname cannot both be blank
     *
     * @param[in] name A String that represents the contact name
     * @param[in] surname A String that represents the contact surname
     * @param[in] email An object that represents the list of email of the contact
     * @param[in] phoneNumber An object that represent the list of phonenumber of the contact
     * @param[in] description A String that represents the description of the contact
     */
    public Contact(String name, String surname, Email email, PhoneNumber phoneNumber, String description){
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.description=description;
    }
     /**
      * @brief Returns the contact name
      * @return A String that represents the contact name
      */
     public String getName(){
         return this.name;
     }
     /**
      * @brief Set the contact name
      * @param[in] name A String that represents the contact name
      */
     public void setName(String name){
         this.name=name;
     }
     /**
      * @brief Returns the contact surname
      * @return A String that represents the contact surname
      */
     public String getSurname(){
         return this.surname;
     }
     /**
      * @brief Set the contact surname
      * @param[in] surname A String that represents the contact surname
      */
     public void setSurname(String surname){
         this.surname=surname;
     }
     /**
      * @brief Return the contact email
      * @return An object that represents the list of email of the contact
      */
     public Email getEmail(){
         return this.email;
     }
     /**
      * @brief Return the contact phonenumber
      * @return An object that represent the list of phonenumber of the contact
      */
     public PhoneNumber getPhoneNumber(){
         return this.phoneNumber;
     }
     /**
      * @brief Return the description of the contact
      * @return A String that represent the description of the contact
      */
     public String getDescription(){
         return this.description;
     }
     /**
      * @brief Set the description of the contact
      * @param[in] description A String that represents the description of the contact
      */
     public void setDescription(String description){
         this.description=description;
     }
     
}
