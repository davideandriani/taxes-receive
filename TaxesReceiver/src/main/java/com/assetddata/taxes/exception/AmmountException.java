package com.assetddata.taxes.exception;

public class AmmountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 989176587625681496L;

	
	
	public AmmountException(String message) {
		super(message);
	}
	
	 public AmmountException (Throwable cause) {
	        super (cause);
	    }

    public AmmountException (String message, Throwable cause) {
        super (message, cause);
    }
}
