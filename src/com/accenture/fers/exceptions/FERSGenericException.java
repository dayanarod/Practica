package com.accenture.fers.exceptions;


/**
 * Custom Exception class for overriding SQL and CLASSNOTFOUND exceptions
 */
@SuppressWarnings("serial")
public class FERSGenericException extends RuntimeException {

	public static final String ERM_000 = "Constructor empty";
	public static final String ERM_001 = "Please provide Firstname";
	public static final String ERM_002 = "Please provide Lastname";
	public static final String ERM_003 = "Please provide Username";
	public static final String ERM_004 = "Please provide password";
	public static final String ERM_005 = "Please provide email";
	public static final String ERM_006 = "Please provide confirm password";
	public static final String ERM_007 = "Please provide phone number";
	public static final String ERM_008 = "Please provide dni";
	public static final String ERM_009 = "Password and confirm password must be same!!";
	public static final String ERM_010 = "Invalid Phone number";
	public static final String ERM_011 = "Invalid Email ID";
	public static final String ERM_012 = "Invalid DNI";
	public static final String ERM_013 = "Invalid username";
	public static final String ERM_014 = "Invalid Password";
	public static final String ERM_015 = "Invalid FirstName";
	public static final String ERM_016 = "Invalid LastName";
	public static final String ERM_017 = "Invalid Addres";
	public static final String ERM_018 = "Invalid Event Name";
	public static final String ERM_019 = "Invalid Event Description";
	public static final String ERM_020 = "Invalid Event Place";
	public static final String ERM_021 = "Invalid Event Duration";
	public static final String ERM_022 = "Invalid Event Type";
	public static final String ERM_023 = "Invalid SeatsAvailable";
	public static final String ERM_024 = "Invalid username/password";
	public static final String ERM_025 = "USERNAME already exists. Please register again with different USERNAME";
	public static final String ERM_026 = "User Already Registered for the Event!!";
	public static final String ERM_027 = "Error in update.. Please Check fields and retry";

	public FERSGenericException(String message, Throwable object)
	{
		super(message,object);

	}

	public FERSGenericException(String message) {
		super(message);
	}

}
