package com.assetddata.taxes.exception;

public class ReceiveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 989176587625681496L;

	
	
	public ReceiveException(String message) {
		super(message);
	}
	
	 public ReceiveException (Throwable cause) {
	        super (cause);
	    }

    public ReceiveException (String message, Throwable cause) {
        super (message, cause);
    }
}
