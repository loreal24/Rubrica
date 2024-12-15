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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author simon
 */
public class AddContactController {

    private ContactList contactList;//contiene la rubrica
    public static TextField contactSearch;

    @FXML
    Button cancelButton, saveButton;//pulsanti per gestire l'annullamento e il salvataggio

    @FXML
    TextField inputName, inputSurname, inputPhoneNumber_1, inputPhoneNumber_2, inputPhoneNumber_3, inputEmail_1, inputEmail_2, inputEmail_3, inputDescription;//campi di testo per gestire l'inserimento dei dati

    @FXML
    public void handlerCancelButtonAction() {
        cancelButton.setOnAction(e -> {
            Stage stage = (Stage) cancelButton.getScene().getWindow();//recupera la finestra dal pulsante stesso
            stage.close();//chiude la finestra
        });
    }

    @FXML
    public void handlerSaveButton() throws InvalidContactException {
        saveButton.setOnAction(e -> {
            try {
                String name = inputName.getText().trim();//recupera la stringa del nome dal campo di testo del nome
                String surname = inputSurname.getText().trim();//recupera la stringa del cognome dal campo di testo del cognome
                if (name.isEmpty() && surname.isEmpty()) {//se il nome e il cognome sono vuoti lancia l'eccezione
                    throw new InvalidContactException("Il nome e il cognome non possono essere entrambi vuoti!!");
                }

                PhoneNumber phoneNumber = getInputPhoneNumber();//recupera le stringhe dei numeri di telefono dai campi per i numeri di telefono
                Email email = getInputEmail();//recupera le stringhe delle email dai campi per le email
                String description = inputDescription.getText().trim();//recupera la stringa della descrizione dal campo di testo per la descrizione

                Contact contact = new Contact(name, surname, email, phoneNumber, description);//crea il nuovo contatto
                contactList.addContact(contact);//aggiunge il contatto alla rubrica
                contactSearch.setText("a");//forza l'aggiornamento della vista dei contatti filtrati
                contactSearch.setText("");

                Stage stage = (Stage) saveButton.getScene().getWindow();//recupera la finestra dal pulsante stesso
                stage.close();//chiude la finestra
            } catch (InvalidContactException ice) {//cattura l'eccezione se il nome e il cognome sono entrambi vuoti
                ErrorModalView errorModal = new ErrorModalView();//crea la vista del modale di errore
                errorModal.showModal("Invalid Contact Exception", (Stage) saveButton.getScene().getWindow(), "Il nome e il cognome non possono essere entrambi vuoti!!");//lancia la vista del modale di errore personalizzata
            } catch (InvalidPhoneNumberException ipne) {//cattura l'eccezione se i numeri di telefono non sono validi
                ErrorModalView errorModal = new ErrorModalView();//crea la vista del modale di errore
                errorModal.showModal("Invalid PhoneNumber Exception", (Stage) saveButton.getScene().getWindow(), "Inserire un numero di telefono valido!!");//lancia la vista del modale di errore personalizzata
            } catch (InvalidEmailException iee) {//cattura l'eccezione se le email non sono valide
                ErrorModalView errorModal = new ErrorModalView();//crea la vista del modale di errore
                errorModal.showModal("Invalid Email Exception", (Stage) saveButton.getScene().getWindow(), "Inserire una email valida!!");//lancia la vista del modale di errore personalizzata
            }
        });
    }
    /*
    recupera le stringhe dei numeri di telefono dai campi di testo per i numeri di telefono
    nel caso non siano validi lancia l'eccezione   
    */
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

    /*
    recupera le stringhe delle email dai campi di testo per le email
    nel caso non siano valide lancia l'eccezione   
    */
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
    /*
    recupera la lista di contatti della rubrica
    */
    public void setContactList(ContactList contactList){
        this.contactList = contactList;
    }
    
    @FXML
    public void initialize() throws InvalidContactException {
        handlerSaveButton();//inixializza il pulsante salva
        handlerCancelButtonAction();//inizializza il pulsante annulla
    }
}
