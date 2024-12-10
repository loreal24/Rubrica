/**
 * @file Group.java
 * @brief This file contains the implementation of the Group feature
 * 
 * More detailed information about the file and its role in the project.
 * @author simon
 * @date December 2, 2024
 */
package gruppo22.rubrica.Model;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Group extends ContactList {
    
    private String name;
    private String description;

	public Group() {
		super();
	}
    
    /**
     * @brief Constructor
     * @param[in] name represents the group name
     * @param[in] description represents the description of the name
     */
    public Group(String name, String description){
        super();
        this.name=name;
        this.description=description;
    }
    
    /**
      * @brief Returns the contact name
      * @return A String that represents the group name
      */
    public String getName(){
        return this.name;
    }
    
     /**
      * @brief Set the contact name
      * @param[in] name A String that represents the group name
      */
    public void setName(String name){
        this.name=name;
    }
    
    /**
      * @brief Return the description of the group
      * @return A String that represent the description of the group
      */
    public String getDescription(){
        return this.description;
    }
    
    /**
      * @brief Set the description of the group
      * @param[in] description A String that represents the description of the group
      */
    public void setDescription(String description){
        this.description=description;
    }


    /**
     * @brief Allows to save group information in a file
     * @param[in] filename
     * @throws IOException 
     */
	public void saveVCF(String filename) throws IOException {

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write("NOME: " + this.name);
			bw.newLine();
			bw.write("DESCRIZIONE: " + this.description);
			bw.newLine();
			for(Contact c: contacts) {
				bw.write("BEGIN:VCARD");
				bw.newLine();
				bw.write("VERSION:3.0");
				bw.newLine();

				if(c.getName() != null && c.getSurname() != null){
					bw.write("FN:"+ c.getSurname() + " " + c.getName());
					bw.newLine();
					bw.write("N:" + c.getSurname() + ";" + c.getName()+";;;");
					bw.newLine();
				}
					
				else if(c.getName() != null){
					bw.write("FN:" + c.getName());
					bw.newLine();
					bw.write("N:" + c.getName()+ ";;;");
					bw.newLine();
				}
				else if(c.getSurname() != null) {
					bw.write("FN:" + c.getSurname());
					bw.newLine();
					bw.write("N:" + c.getSurname());
					bw.newLine();
				}

				for(int i = 0; i < 3; i++){
					if (c.getEmail().getEmailList().toArray()[i] != null){
						bw.write("EMAIL:"+ c.getEmail().getEmailList().toArray()[i].toString());
						bw.newLine();
					}
				}

				for(int i = 0; i < 3; i++){
					if (c.getPhoneNumber().getPhoneNumbers().toArray()[i] != null){
						bw.write("TEL:+39" + c.getPhoneNumber().getPhoneNumbers().toArray()[i].toString());
						bw.newLine();
					}
				}

				if(c.getDescription() != null){
					bw.write("NOTE:" + c.getDescription());
					bw.newLine();

				}

				bw.write("END:VCARD");
				bw.newLine();
			}
		}
	}

	/**
	 * @brief Allows to read group information from a file
	 * @param[in] nomeFile
	 * @return A Group instance with the information from the specified 
	 * file
	 * @throws IOException
	 * @throws InvalidEmailException
	 * @throws InvalidPhoneNumberException
	 * @throws InvalidContactException
	 */
	public static Group readVCF(String nomeFile) throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException { 

			Group c = new Group();
		 try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
			String riga;
		while ((riga = br.readLine()) != null) {
			
			String nomeGruppo, descrizioneGruppo;
			if(riga.startsWith("NOME")) {
				c.setName(riga.substring(5));
			}
			if(riga.startsWith("DESCRIZIONE")) {
				c.setDescription(riga.substring(11));
			}


			// Stampa la riga letta
			String nome="", cognome="", descrizione="", fullname[];
			Email email = new Email();
			PhoneNumber phoneNumber = new PhoneNumber();
			if (riga.startsWith("BEGIN:VCARD")) {
				System.out.println("Inizio di un nuovo contatto:");
			} else if (riga.startsWith("FN:")) {
				fullname = riga.substring(3).split(" ");
				cognome = fullname[0];
				if(fullname.length > 1)
					nome = fullname[1];
			} else if (riga.startsWith("EMAIL:")) {
				email.addEmail(riga.substring(6));
			} else if (riga.startsWith("TEL:")) {
				phoneNumber.addPhoneNumber(riga.substring(4));
			} else if (riga.startsWith("NOTE:")) {
				descrizione = riga.substring(5);
			} else if (riga.startsWith("END:VCARD")) {
				System.out.println("Fine del contatto.\n");
			}

			c.addContact(new Contact(nome, cognome, email, phoneNumber, descrizione));
		}
        } catch (IOException e) {
            e.printStackTrace(); 
        }
		return c;
	}
    
    
}
