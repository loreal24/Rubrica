/**
 * @file Email.java
 * @brief This file contains the implementation of the Email features
 * More detailed information about the file and its role in the project
 * @author lpane
 * @date December 6, 2024
 */
package gruppo22.rubrica.Model;

import gruppo22.rubrica.Exceptions.InvalidEmailException;
import java.util.LinkedList;
import java.util.List;


public class Email {
    
    private final List<String> emailList;
    private final int maxSize;
    private final Checker checker;
    
    /**
     * @brief Implements the default constructor.
     */
    public Email(){
        this.emailList = new LinkedList<>();
        this.maxSize = 3;
        this.checker = new EmailChecker();
    }
    
    /**
     * @brief Implements the constructor
     * @param[in] emailList A List that contains a list of string that represent the email of the contact.
     */
    public Email(List<String> emailList){
        this.emailList = emailList;
        this.maxSize = 3;
        this.checker = new EmailChecker();
    }

    /**
     * @brief Returns the list of email of the contact
     * @return A List of String that represent a list of email of the contact.
     */
    public List<String> getEmailList() {
		return this.emailList;
    }
    
    /**
    * @brief Allows to add a String that represents an email in a List.
    * @param[in] email A String that represents the email of the contact.
    * @throws InvalidEmailException 
    */
    public void addEmail(String email) throws InvalidEmailException{
        if(email == null)
            throw new InvalidEmailException("E-mail non esistente! ");
        
        if(checker.isValid(email)){
            if(emailList.size() < maxSize){
                emailList.add(email);
            }else{
              System.out.println("Non puoi aggiungere più di " + maxSize + " e-mail per lo stesso contatto");
            }
        }else{
            throw new InvalidEmailException("E-mail non valida! ");
        }
    }
    
    /**
     * @brief Allows to remove a String that represent the email of the contact from the list of email.
     * @param[in] email A String that represents the email of the contact.
     * @return A String that represents the email of the contact we have removed.
     * @throws InvalidEmailException 
     */
    public String removeEmail(String email) throws InvalidEmailException{
        
        if(emailList.remove(email)){
            System.out.println("L'e-mail " + email + " è stata rimossa correttamente." );
            return email;
        }
        else
            throw new InvalidEmailException("L'e-mail è inesistente!");
    }
    
    /**
     * @brief Allows to modify the email of the contact.
     * @param[in] oldEmail A String that represents the email of the contact we want modify.
     * @param[in] newEmail A String that represents the email of the contact we want set.
     * @throws InvalidEmailException 
     */
    public void modifyEmail(String oldEmail , String newEmail) throws InvalidEmailException{
        int index = emailList.indexOf(oldEmail);
        
        if(index >= 0){
            emailList.set(index , newEmail);
            System.out.println("L'e-mail è stata modificata correttamente. ");
        }else{
            throw new InvalidEmailException("L'e-mail non è esistente!!");
        }
    }
    
}
