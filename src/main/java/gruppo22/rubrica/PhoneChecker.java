/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica;

/**
 *
 * @author loreal
 */
public class PhoneChecker implements Checker {
	@Override
	public boolean isValid(String phoneNumber) {
		return phoneNumber.matches("^\\d+$");
	}
	
}