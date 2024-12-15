/**
 * @file PhoneChecker.java
 * @brief This file contains the implementation of the checker interface for
 * phone numbers
 * @author loreal
 */
package gruppo22.rubrica.Model;

public class PhoneChecker implements Checker {

	/**
	 *
	 * @param phoneNumber The phone number you want to check the validity of
	 * @return true if valid, false if not valid
	 */
	@Override
	public boolean isValid(String phoneNumber) {
		return phoneNumber.matches("^\\d+$");
	}

}
