/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppo22.rubrica.Exceptions;

/**
 *
 * @author loreal
 */
public class InvalidContactException extends Exception {

	/**
	 * Creates a new instance of <code>InvalidContactException</code> without
	 * detail message.
	 */
	public InvalidContactException() {
	}

	/**
	 * Constructs an instance of <code>InvalidContactException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public InvalidContactException(String msg) {
		super(msg);
	}
}
