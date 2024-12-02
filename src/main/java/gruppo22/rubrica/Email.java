/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica;

import gruppo22.rubrica.Exceptions.InvalidEmailException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lpane
 */
public class Email {
    
    private final List<String> emailList;
    private final int maxSize;
    private final Checker checker;
    
    public Email(){
        this.emailList = new LinkedList<>();
        this.maxSize = 3;
        this.checker = new EmailChecker();
    }
    
    public Email(List<String> emailList){
        this.emailList = emailList;
        this.maxSize = 3;
        this.checker = new EmailChecker();
    }
    
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
    
    public String removeEmail(String email) throws InvalidEmailException{
        String removedEmail = email;
        if(emailList.remove(email)){
            System.out.println("L'e-mail " + removedEmail + " è stata rimossa correttamente." );
            return removedEmail;
        }
        else
            throw new InvalidEmailException("L'e-mail è inesistente!");
    }
    
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
