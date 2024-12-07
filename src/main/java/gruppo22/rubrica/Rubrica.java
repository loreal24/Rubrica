/**
 * @file Rubrica.java
 * @brief The file extends ContactList with the method to save and read files.
 * @author loreal
 */
package gruppo22.rubrica;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import gruppo22.rubrica.Exceptions.InvalidEmailException;
import gruppo22.rubrica.Exceptions.InvalidPhoneNumberException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rubrica extends ContactList{
	/**
	 * @brief Default Constructor
	 */
	public Rubrica() {
		super();
	}

	/**
	 * @brief Allows to save to file the information in the ContactList
	 * @param[in] filename
	 * @throws IOException 
	 */
	public void saveVCF(String filename) throws IOException {

		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
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
	 * @brief Allows to read contacts information from a file
	 * @param[in] nomeFile
	 * @return A ContactList instance with the information from the specified 
	 * file
	 * @throws IOException
	 * @throws InvalidEmailException
	 * @throws InvalidPhoneNumberException
	 * @throws InvalidContactException
	 */
	public static ContactList readVCF(String nomeFile) throws IOException, InvalidEmailException, InvalidPhoneNumberException, InvalidContactException { 
		ContactList c = new Rubrica();
		 try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
		String riga;
		while ((riga = br.readLine()) != null) {
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
        
        /**
         * @brief Allows to filter a list of contacts using a substring of the first or last name
         * @param query A String that represents a substring of the first or last name
         * @param contacts The List of contact we want filter
         * @return the List of contact filtered from a query
         */
        public List<Contact> contactFilter(String query, List<Contact> contacts) {
        List<Contact> contattiFiltrati = new ArrayList<>();
        if (query == null || query.isEmpty()) {
            contattiFiltrati.addAll(contacts);
        } else {
            for (Contact contatto : contacts) {
                if (contatto.getName().toLowerCase().contains(query.toLowerCase()) ||
                    contatto.getSurname().toLowerCase().contains(query.toLowerCase())) {
                    contattiFiltrati.add(contatto);
                }
            }
        }
        return contattiFiltrati;
    }
}
