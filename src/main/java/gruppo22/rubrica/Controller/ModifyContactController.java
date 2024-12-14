/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Controller;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import gruppo22.rubrica.Model.Contact;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Email;
import gruppo22.rubrica.Model.PhoneNumber;
import gruppo22.rubrica.View.ErrorModalView;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author loreal
 */
public class ModifyContactController {

    public static Contact contact;
    public static ContactList rubrica;
    List<TextField> emailInputFields, phoneNumberInputFields;

    @FXML
    Button cancelButton, saveButton;//pulsanti per gestire l'annullamento e il salvataggio

    @FXML
    TextField inputName, inputSurname, inputPhoneNumber_1, inputPhoneNumber_2, inputPhoneNumber_3, inputEmail_1, inputEmail_2, inputEmail_3, inputDescription;//campi di testo per gestire le modifiche

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

                this.contact.setName(name);//imposta il nuovo nome del contatto
                this.contact.setSurname(surname);//imposta il nuovo cognome del contatto
                this.contact.setPhoneNumber(phoneNumber);//imposta i nuovi numeri di telefono del contatto
                this.contact.setEmail(email);//imposta le nuove email del contatto
                this.contact.setDescription(description);//imposta la nuova descrizione del contatto

                rubrica.removeContact(contact);//forza l'aggiornamento della vista rimuovendo e reinserendo il contatto
                rubrica.addContact(contact);

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

    private PhoneNumber getInputPhoneNumber() throws InvalidPhoneNumberException {

        PhoneNumber phoneNumber = new PhoneNumber();
        for (TextField phoneNumberField : phoneNumberInputFields) {
            String phoneNumberText = phoneNumberField.getText().trim();
            phoneNumber.addPhoneNumber(phoneNumberText);
        }

        return phoneNumber;
    }

    private Email getInputEmail() throws InvalidEmailException {
        Email email = new Email();

        for (TextField emailField : emailInputFields) {
            String emailText = emailField.getText().trim();
            email.addEmail(emailText);
        }
        return email;
    }

    @FXML
    public void initialize() {
        emailInputFields = new ArrayList<>();
        emailInputFields.add(inputEmail_1);//aggiunge alla lista i campi di testo per le email per gestirle meglio
        emailInputFields.add(inputEmail_2);
        emailInputFields.add(inputEmail_3);
        phoneNumberInputFields = new ArrayList<>();
        phoneNumberInputFields.add(inputPhoneNumber_1);//aggiunge alla lista i campi di testo per i numeri di telefono per gestirli meglio
        phoneNumberInputFields.add(inputPhoneNumber_2);
        phoneNumberInputFields.add(inputPhoneNumber_3);

        this.inputName.setText(this.contact.getName());// Inserisce il nome nel campo di testo per il nome
        this.inputSurname.setText(this.contact.getSurname());// Inserisce il cognome nel campo di testo per il cognome
        setInputPhoneNumber();//Inserisce le email nei campi di testo per le email
        setInputEmail();//Inserisce i numeri di telefono nei campi di testo per i numeri di telefono
        this.inputDescription.setText(this.contact.getDescription());// Inserisce la descrizione nel campo di testo per la descrizione
    }

    private void setInputEmail() {
        Email email = this.contact.getEmail();
        List<String> emailList = email.getEmailList();

        for (int i = 0; i < emailInputFields.size(); i++) {
            if (i < emailList.size() && emailList.get(i) != null) {
                emailInputFields.get(i).setText(emailList.get(i));// Inserisce la email nel campo di testo per le email
            } else {
                emailInputFields.get(i).setText(""); // Svuota il campo se non ci sono email
            }
        }
    }

    private void setInputPhoneNumber() {
        PhoneNumber phoneNumber = this.contact.getPhoneNumber();
        List<String> phoneNumberList = phoneNumber.getPhoneNumbers();

        for (int i = 0; i < phoneNumberInputFields.size(); i++) {
            if (i < phoneNumberList.size() && phoneNumberList.get(i) != null) {
                phoneNumberInputFields.get(i).setText(phoneNumberList.get(i));// Inserisce il numero di telefono nel campo di testo per i numeri di telefono
            } else {
                phoneNumberInputFields.get(i).setText(""); // Svuota il campo se non ci sono numeri di telefono
            }
        }
    }
}
