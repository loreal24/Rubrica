/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

import gruppo22.rubrica.Model.ContactList;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author loreal
 */
public class MainView extends VBox {
	HeaderView header;
	SearchBarView search;
	ContactListView contactListView;
        ContactList contactList;

	public MainView() {
		header = new HeaderView(contactList);
		search = new SearchBarView();
		contactListView = new ContactListView();

		setAlignment(Pos.CENTER);

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);

		VBox v = new VBox();
		v.getChildren().addAll(header, search, contactListView);

		box.getChildren().addAll(v);

		getChildren().add(box);

	}
        public void setContactList(ContactList contactList){
            this.contactList = contactList;
        }
}
