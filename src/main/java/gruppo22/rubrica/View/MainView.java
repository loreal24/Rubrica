/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.View;

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
	ContactCardView card;

	public MainView() {
		header = new HeaderView();
		search = new SearchBarView();
		card = new ContactCardView();

		setAlignment(Pos.CENTER);

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);

		VBox v = new VBox();
		v.getChildren().addAll(header, search, card);

		box.getChildren().addAll(v);

		getChildren().add(box);

	}
}
