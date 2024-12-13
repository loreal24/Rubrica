/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Email;
import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import gruppo22.rubrica.Model.PhoneNumber;
import gruppo22.rubrica.View.ErrorModalView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author simon
 */
public class AddContactController{
    
    private ContactList contactList;

	public static TextField contactSearch;

    
    @FXML
    Button cancelButton, saveButton;
    
    @FXML
    TextField inputName, inputSurname, inputPhoneNumber_1, inputPhoneNumber_2, inputPhoneNumber_3,  inputEmail_1, inputEmail_2, inputEmail_3, inputDescription;
    
    
    
    @FXML
    public void handlerCancelButtonAction(){
        cancelButton.setOnAction(e-> {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        });
    }
    
    @FXML
    public void handlerSaveButton() throws InvalidContactException {
        saveButton.setOnAction(e -> {
            try {

                String name = inputName.getText().trim();
                String surname = inputSurname.getText().trim();
                if (name.isEmpty() && surname.isEmpty()) {
                    throw new InvalidContactException("Il nome e il cognome non possono essere entrambi vuoti!!");
                }

                PhoneNumber phoneNumber = getInputPhoneNumber();
                Email email = getInputEmail();
                String description = inputDescription.getText().trim();
                
                Contact contact = new Contact(name,surname,email,phoneNumber,description);
                System.out.println(contactList);
                contactList.addContact(contact);
				contactSearch.setText("a");
				contactSearch.setText("");
                
                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();
            } catch (InvalidContactException ice) {
                ErrorModalView errorModal = new ErrorModalView();
                errorModal.showModal("Invalid Contact Exception",(Stage) saveButton.getScene().getWindow(), "Il nome e il cognome non possono essere entrambi vuoti!!");

            } catch (InvalidPhoneNumberException ipne){
                ErrorModalView errorModal = new ErrorModalView();
                errorModal.showModal("Invalid PhoneNumber Exception",(Stage) saveButton.getScene().getWindow(), "Inserire un numero di telefono valido!!");
            } catch (InvalidEmailException iee){
                ErrorModalView errorModal = new ErrorModalView();
                errorModal.showModal("Invalid Email Exception",(Stage) saveButton.getScene().getWindow(), "Inserire una email valida!!");
            }
        });
    }
    
    private PhoneNumber getInputPhoneNumber() throws InvalidPhoneNumberException {
        String phoneNumber_1 = inputPhoneNumber_1.getText().trim();
        String phoneNumber_2 = inputPhoneNumber_2.getText().trim();
        String phoneNumber_3 = inputPhoneNumber_3.getText().trim();
        PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.addPhoneNumber(phoneNumber_1);
        phoneNumber.addPhoneNumber(phoneNumber_2);
        phoneNumber.addPhoneNumber(phoneNumber_3);

        return phoneNumber;
    }

    private Email getInputEmail() throws InvalidEmailException {
        String email_1 = inputEmail_1.getText().trim();
        String email_2 = inputEmail_2.getText().trim();
        String email_3 = inputEmail_3.getText().trim();
        Email email = new Email();

        email.addEmail(email_1);
        email.addEmail(email_2);
        email.addEmail(email_3);

        return email;
    }
    
    
    public void setContactList(ContactList contactList){
        this.contactList = contactList;
    }
    
    
    @FXML
    public void initialize() throws InvalidContactException{
        handlerSaveButton();
        handlerCancelButtonAction();
    }
}
