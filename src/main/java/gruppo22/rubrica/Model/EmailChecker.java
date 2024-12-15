/**
 * @file EmailChecker.java
 * @brief This file contains the implementation of the checker interface for
 * emails.
 * @author loreal
 */
package gruppo22.rubrica.Model;

public class EmailChecker implements Checker {

	/**
	 * @param email The email you want to check the validity of
	 * @return true if valid, false if not valid
	 */
	@Override
	public boolean isValid(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
}
