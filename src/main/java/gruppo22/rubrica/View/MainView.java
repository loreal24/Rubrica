/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;


import gruppo22.rubrica.Controller.HeaderController;
import gruppo22.rubrica.Model.ContactList;
import gruppo22.rubrica.Model.Groups;
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
	GroupListView groupListView;
	ContactList contactList;
	Groups groups;


	public MainView(ContactList rubrica, Groups groups, boolean groupView) {
            
           
		header = new HeaderView();
                
		search = new SearchBarView();
		contactListView = new ContactListView(rubrica, groups);
		groupListView = new GroupListView(rubrica, groups);

		HeaderController.contactListView = contactListView;
		HeaderController.groupListView = groupListView;

		setAlignment(Pos.CENTER);

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);

		VBox v = new VBox();
		
		v.getChildren().addAll(header, search, contactListView);
		box.getChildren().addAll(v);
		getChildren().add(box);

		HeaderController.v = v;



	}
        public void setContactList(ContactList contactList){
            this.contactList = contactList;
        }

        public void setGroups(Groups groups){
            this.groups = groups;
        }
}
