/**
 * @file PhoneNumber.java
 * @brief This file contains the implementation of the PhoneNumber features
 * More detailed information about the file and its role in the project
 * @author lpane
 * @date December 6, 2024
 */
package gruppo22.rubrica.Model;

import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import java.util.LinkedList;
import java.util.List;


public class PhoneNumber {
    
    private final List<String> phoneNumbers;
    private final int maxSize;
    private final Checker checker;
    
    /**
     * @brief Implements the default constructor
     */
    public PhoneNumber(){
        this.phoneNumbers = new LinkedList<>();
        this.maxSize= 3;
        this.checker = new PhoneChecker();
    }
    
    /**
     * @brief Implements the constructor
     * @param[in] phoneNumbers A List that represent a list of string that represent the phonenumber of the contact.
     */
    public PhoneNumber(List<String> phoneNumbers){
        this.phoneNumbers = new LinkedList<>();
        this.maxSize = 3;
        this.checker = new PhoneChecker();
    }
    
    /**
     * @brief Allows to get the list of phonenumber of the contact
     * @return A List of String that represent the list of phonenumber of the contact
     */
    public List<String> getPhoneNumbers() {
		return this.phoneNumbers;
    }

    /**
     * @brief Allows to add a String that represents the phonenumber of the contact
     * @param[in] phoneNumber A String that represent the phonenumber of the contact
     * @throws InvalidPhoneNumberException 
     */
    public void addPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        if(phoneNumber == null)
            throw new InvalidPhoneNumberException("Numero di telefono non esistente! ");
        
        if(checker.isValid(phoneNumber)){
            if(phoneNumbers.size() < maxSize){
                phoneNumbers.add(phoneNumber);
            }else{
              System.out.println("Non puoi aggiungere più di " + maxSize + " numeri di telefono per lo stesso contatto");
            }
        }else{
            throw new InvalidPhoneNumberException("Numero di telefono non valido! ");
        }
    }
    
    /**
     * @brief Allows to remove a phonenumber from the list of phonenumber of the contact
     * @param[in] phoneNumber A String that represent the phonenumber of the contact
     * @return A String that represent the phonenumber of the contact
     * @throws InvalidPhoneNumberException 
     */
    public String removePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        if(phoneNumbers.remove(phoneNumber)){
            System.out.println("Il numero di telefono " + phoneNumber + " è stato rimosso correttamente." );
            return phoneNumber;
        }
        else
            throw new InvalidPhoneNumberException("Numero di telefono nullo!");
    }
    
    /**
     * @brief Allows to modify the phonenumber of the contact
     * @pre The oldPhoneNumber must correspond to an existing phonenumber
     * @param[in] oldPhoneNumber A String that represents the phonenumber we want modify
     * @param[in] newPhoneNumber A String that represent the phonenumber we want set
     * @throws InvalidPhoneNumberException 
     */
    public void modifyPhoneNumber(String oldPhoneNumber , String newPhoneNumber) throws InvalidPhoneNumberException{
        int index = phoneNumbers.indexOf(oldPhoneNumber);
        
        if(index >= 0){
            phoneNumbers.set(index , newPhoneNumber);
            System.out.println("Il numero di telefono è stato modificato correttamente. ");
        }else{
            throw new InvalidPhoneNumberException("Il numero selezionato non è esistente!!");
        }
    }
}
