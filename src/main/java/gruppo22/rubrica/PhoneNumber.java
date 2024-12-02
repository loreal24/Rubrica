/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica;

import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import java.util.LinkedList;

/**
 *
 * @author lpane
 */
public class PhoneNumber {
    
    private LinkedList<String> phoneNumbers;
    private int maxSize;
    
    public PhoneNumber(){
        this.phoneNumbers = new LinkedList<>();
        this.maxSize= 3; 
    }
    
    public PhoneNumber(LinkedList<String> phoneNumbers){
        this.phoneNumbers = new LinkedList<>();
        this.maxSize = 3;
    }
    
    public void addPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        if(phoneNumber == null)
            throw new InvalidPhoneNumberException("Numero di telefono non valido! ");
        
        if(phoneNumbers.size() < maxSize){
            phoneNumbers.add(phoneNumber);
        }else{
            System.out.println("Non puoi aggiungere più di " + maxSize + " numeri di telefono per lo stesso contatto");
        }
    }
    
    public String removePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        String removed = phoneNumber;
        if(phoneNumbers.remove(phoneNumber)){
            return "Il numero " + removed + " è stato rimosso con successo";
        }
        else
            throw new InvalidPhoneNumberException("Numero di telefono nullo!");
    }
    
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
