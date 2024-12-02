/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica;

import java.util.Comparator;

/**
 *
 * @author simon
 */
public class ContactComparator implements Comparator<Contact>{

    @Override
    public int compare(Contact c1, Contact c2) {
        if(!c1.getName().equals(c2.getName()))
            return c1.getName().compareTo(c2.getName());
        return c1.getSurname().compareTo(c2.getSurname());
    }
    
    
}
