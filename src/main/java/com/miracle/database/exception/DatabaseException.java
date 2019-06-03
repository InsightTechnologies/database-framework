package com.miracle.database.exception;

import java.io.IOException;
import java.net.ConnectException;

public class DatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorDescription;
	private String className;
	private String methodName;

	/**
	 * 
	 */
	public DatabaseException() {
	}

	/**
	 * @param message
	 */
	public DatabaseException(String errorText, String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
		this.errorCode = getException(errorDescription);
	}

	public DatabaseException(String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}

	/**
	 * @param cause
	 */
	public DatabaseException(Throwable cause) {
		super(cause);
	}

	public DatabaseException(Throwable cause, String erroCode, String errorDescription) {
		super(cause);
		this.errorCode = erroCode;
		this.errorDescription = errorDescription;
	}

	public DatabaseException(Throwable cause, String errorDescription) {
		super(cause);
		this.errorDescription = errorDescription;
		this.errorCode = getExceptionDetails(cause);
	}

	private String getException(String errorText) {
		String errorCode = "ISC.DBF.UNK.000";
		if (errorText.contains("MongoSocketOpenException")) {
			errorCode = "ISC.DBF.MSO.000";
		}
		return errorCode;

	}

	private String getExceptionDetails(Throwable cause) {
		String errorCode = null;
		if (cause instanceof IllegalArgumentException) {
			errorCode = "ISC.DBF.IAG.000";
		} else if (cause instanceof ConnectException) {
			errorCode = "ISC.DBF.CEX.000";
		} else if (cause instanceof NullPointerException) {
			errorCode = "ISC.DBF.NPE.000";
		} else if (cause instanceof InterruptedException) {
			errorCode = "ISC.DBF.INT.000";
		} else if (cause instanceof NumberFormatException) {
			errorCode = "ISC.DBF.NBF.000";
		} else if (cause instanceof ArrayIndexOutOfBoundsException) {
			errorCode = "ISC.DBF.AIN.000";
		} else if (cause instanceof ArithmeticException) {
			errorCode = "ISC.DBF.ART.000";
		} else if (cause instanceof IOException) {
			errorCode = "ISC.DBF.IOE.000";
		} else if (cause instanceof DatabaseException) {
			errorCode = getException(((DatabaseException) cause).getErrorDescription());
		}
		return errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
