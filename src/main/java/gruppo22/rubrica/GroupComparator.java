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
public class GroupComparator implements Comparator<Group>{

    @Override
    public int compare(Group g1, Group g2) {
        return g1.getName().compareTo(g2.getName());
    }
    
}
