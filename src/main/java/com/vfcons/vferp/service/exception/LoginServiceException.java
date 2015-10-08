package com.vfcons.vferp.service.exception;

/**
 * 
 * @author jsegovia
 * @version 1.0
 *
 */
public class LoginServiceException extends Exception {

	private static final long serialVersionUID = 2385691307540232528L;

	private int errorCode;

	public LoginServiceException(int errorCode, String msj) {
		super(msj);
		this.errorCode = errorCode;
	}

	public LoginServiceException(int errorCode, String msj, Throwable cause) {
		super(msj, cause);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
