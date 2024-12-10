/**
 * @file Checker.java
 * @brief This file contains an interface, generalizing a checker for phonenumbers
 * and emails
 * @author loreal
 */
package gruppo22.rubrica.Model;

public interface Checker {
	/**
	 * @brief Abstract method
	 * @param s The string to check the validity of
	 * @return true if string is valid, false if it's not valid
	 */

	public boolean isValid(String s);
	
}
