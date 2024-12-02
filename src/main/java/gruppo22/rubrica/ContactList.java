/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica;

import gruppo22.rubrica.Exceptions.InvalidContactException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author loreal
 */
public class ContactList {
	private final List<Contact> contacts; 

	public ContactList() {
		contacts = new LinkedList<>();	
	}

	public void addContact(Contact c) throws InvalidContactException {
		if(c != null)
			contacts.add(c);
		else 
			throw new InvalidContactException("Contatto non valido oppure null");
	}

	public void removeContact(Contact c) throws InvalidContactException {
		if(c != null)
			contacts.remove(c);
		else
			throw new InvalidContactException("Contatto non valido oppure null");
	}

	public Contact getContact(Contact c) {
		return (Contact) contacts.toArray()[contacts.indexOf(c)];
	}

	public void salvaDOS(String filename) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		DataOutputStream dos = new DataOutputStream(fos);

		for(Contact c: contacts) {
			if(c.getName() != null)
				dos.writeUTF(c.getName());
			else
				dos.writeUTF("");
			if(c.getSurname() != null)
				dos.writeUTF(c.getSurname());
			else
				dos.writeUTF("");

			for(int i = 0; i < 3; i++)
				if (c.getEmail().toArray()[i] != null)
					dos.writeUTF(c.getEmail().toArray()[i]);
				else
					dos.writeUTF("");

			for(int i = 0; i < 3; i++)
				if (c.getPhoneNumber().toArray()[i] != null)
					dos.writeUTF(c.getPhoneNumber().toArray()[i]);
				else
					dos.writeUTF("");

			if(c.getDescription() != null)
				dos.writeUTF(c.getDescription());
			else
				dos.writeUTF("");

		dos.close();
		}
	}

	public static ContactList leggiDIS(String nomeFile) throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(nomeFile);
		DataInputStream dis = new DataInputStream(fis);

		ContactList c = new ContactList();

		try {
			while(true) {
				String name = dis.readUTF();
				String surname = dis.readUTF();

				Email email = new Email();
				email.add(dis.writeUTF());
				email.add(dis.writeUTF());
				email.add(dis.writeUTF());

				PhoneNumber phoneNumber = new PhoneNumber();
				phoneNumber.add(dis.writeUTF());
				phoneNumber.add(dis.writeUTF());
				phoneNumber.add(dis.writeUTF());

				String description = dis.readUTF();

				c.addContact(new Contact(name, surname, email, phoneNumber, description));
			}
		} catch (EOFException ex) {
			System.out.println("Lettura completata");
		}

		dis.close();
		return c;
	}
}
