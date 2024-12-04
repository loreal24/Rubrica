/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author loreal
 */
public class Groups {
	private List<Group> groups;

	public Groups() {
		groups = new LinkedList<>();
	}

	public void addGroup(Group g) {
		groups.add(g);	

		groups.sort(new GroupComparator());
	}

	public void removeGroup(Group g) {
		if(!groups.isEmpty()) {
			groups.remove(g);
		}
	}
}
