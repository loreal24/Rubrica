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
    Button cancelButton, saveButton;

    @FXML
    TextField inputName, inputSurname, inputPhoneNumber_1, inputPhoneNumber_2, inputPhoneNumber_3, inputEmail_1, inputEmail_2, inputEmail_3, inputDescription;

    @FXML
    public void handlerCancelButtonAction() {
        cancelButton.setOnAction(e -> {
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

                this.contact.setName(name);
                this.contact.setSurname(surname);
                this.contact.setPhoneNumber(phoneNumber);
                this.contact.setEmail(email);
                this.contact.setDescription(description);

                rubrica.removeContact(contact);
                rubrica.addContact(contact);

                Stage stage = (Stage) saveButton.getScene().getWindow();
                stage.close();
            } catch (InvalidContactException ice) {
                ErrorModalView errorModal = new ErrorModalView();
                errorModal.showModal("Invalid Contact Exception", (Stage) saveButton.getScene().getWindow(), "Il nome e il cognome non possono essere entrambi vuoti!!");

            } catch (InvalidPhoneNumberException ipne) {
                ErrorModalView errorModal = new ErrorModalView();
                errorModal.showModal("Invalid PhoneNumber Exception", (Stage) saveButton.getScene().getWindow(), "Inserire un numero di telefono valido!!");
            } catch (InvalidEmailException iee) {
                ErrorModalView errorModal = new ErrorModalView();
                errorModal.showModal("Invalid Email Exception", (Stage) saveButton.getScene().getWindow(), "Inserire una email valida!!");
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

            email.addEmail(emailText); // Aggiungi solo se non è vuoto

        }

        return email;
    }

    @FXML
    public void initialize() {
        System.out.println(contact);

        emailInputFields = new ArrayList<>();
        emailInputFields.add(inputEmail_1); // Aggiungi i riferimenti ai campi email
        emailInputFields.add(inputEmail_2);
        emailInputFields.add(inputEmail_3);
        phoneNumberInputFields = new ArrayList<>();
        phoneNumberInputFields.add(inputPhoneNumber_1);
        phoneNumberInputFields.add(inputPhoneNumber_2);
        phoneNumberInputFields.add(inputPhoneNumber_3);

        this.inputName.setText(this.contact.getName());
        this.inputSurname.setText(this.contact.getSurname());
        setInputPhoneNumber();
        setInputEmail();
        this.inputDescription.setText(this.contact.getDescription());
    }

    private void setInputEmail() {
        Email email = this.contact.getEmail();
        List<String> emailList = email.getEmailList();

        for (int i = 0; i < emailInputFields.size(); i++) {
            if (i < emailList.size() && emailList.get(i) != null) {
                emailInputFields.get(i).setText(emailList.get(i));
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
                phoneNumberInputFields.get(i).setText(phoneNumberList.get(i));
            } else {
                phoneNumberInputFields.get(i).setText(""); // Svuota il campo se non ci sono email
            }
        }
    }
}
