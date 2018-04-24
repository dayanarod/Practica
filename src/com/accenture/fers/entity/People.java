package com.accenture.fers.entity;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Validator;


/**
 * Accenture Technology Solutions
 * @author Diana Rodera Rojas
 * @version v1
 * @since 19/04/16
 * Clase Poeple
 */

public class People {
	//Declaraciones de las constantes de mínimo y máximo
	public static final int ADRRESS_MIN = 0;
	public static final int ADRRESS_MAX = 30;
	public static final int FIRST_NAME_MIN = 1;
	public static final int FIRST_NAME_MAX = 30;
	public static final int LAST_NAME_MIN = 1;
	public static final int LAST_NAME_MAX = 30;
	public static final int EMAIL_MIN = 3;
	public static final int EMAIL_MAX = 200;
	public static final int PHONE_NUMBER_MIN = 10;
	public static final int PHONE_NUMBER_MAX = 20;
	public static final int DNI_MIN = 12;
	public static final int DNI_MAX = 12;

	//Variables privadas de la clase People
	private String address;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String dni;
	/**
	 * Constructor por defecto
	 */
	public People() {

	}
	/**
	 * @param people tipo objeto
	 */
	public People(People people) {
		//Validamos que el objeto people no sea null
		if(people != null){
			this.address = people.address;
			this.firstName = people.firstName;
			this.lastName = people.lastName;
			this.email = people.email;
			this.phoneNumber = people.phoneNumber;
			this.dni = people.dni;
		}else{
			//Creamos la excepcion ERM_000 = "Constructor empty"
			throw new FERSGenericException(FERSGenericException.ERM_000);
		}
	}
	/**
	 * @return devuelve el valor de la variable instancia address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address asginamos a la varible instancia address
	 */
	public void setAddress(String address) {
		//Validamos si la longitud de los caracteres está entre el min y máx
		if(Validator.lengthValidation(address,ADRRESS_MIN, ADRRESS_MAX)){
			this.address = address;
		}else{
			//Creamos la excepcion ERM_017 = "Invalid Addres"
			throw new FERSGenericException(FERSGenericException.ERM_017);
		}
	}
	/**
	 * @return devuelve el valor de la variable instancia firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName asginamos a la varible instancia firstName
	 */
	public void setFirstName(String firstName) {
		//Validamos que no sea nulo
		//y que la longitud de los caracteres está entre el min y máx
		if(firstName!=null && Validator.lengthValidation(firstName,FIRST_NAME_MIN, FIRST_NAME_MAX)){
			this.firstName = firstName;
		}else{
			//Creamos la excepcion ERM_015 = "Invalid FirstName"
			throw new FERSGenericException(FERSGenericException.ERM_015);
		}
	}
	/**
	 * @return devuelve el valor de la variable instancia lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName asginamos a la varible instancia lastName
	 */
	public void setLastName(String lastName) {
		//Validamos que no sea nulo
		//y que la longitud de los caracteres está entre el min y máx
		if(lastName!=null && Validator.lengthValidation(lastName,LAST_NAME_MIN, LAST_NAME_MAX)){
			this.lastName = lastName;
		}else{
			//Creamos la excepcion ERM_016 = "Invalid LastName"
			throw new FERSGenericException(FERSGenericException.ERM_016);
		}
	}
	/**
	 * @return devuelve el valor de la variable instancia email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email asginamos a la varible instancia email
	 */
	public void setEmail(String email) {
		//Validamos que no sea nulo
		//Validamos que la longitud de los caracteres está entre el min y máx
		//Validamos que el email sea válido
		if(email!=null && Validator.lengthValidation(email,EMAIL_MIN, EMAIL_MAX)
				&& Validator.emailValidation(email, EMAIL_MAX, EMAIL_MIN)){
			this.email = email;
		}else{
			//Creamos la excepcion ERM_011 = "Invalid DNI"
			throw new FERSGenericException(FERSGenericException.ERM_011);
		}
	}
	/**
	 * @return devuelve el valor de la variable instancia phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber asginamos a la varible instancia phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		//Validamos que no sea nulo
		//Validamos que la longitud de los caracteres está entre el min y máx
		//Validamos que el tlf sea válido
		if(phoneNumber!=null && Validator.lengthValidation(phoneNumber,PHONE_NUMBER_MIN, PHONE_NUMBER_MAX)
				&& Validator.phoneValidation(phoneNumber, PHONE_NUMBER_MAX, PHONE_NUMBER_MIN)){
			this.phoneNumber = phoneNumber;
		}else{
			//Creamos la excepcion ERM_010 = "Invalid Email ID"
			throw new FERSGenericException(FERSGenericException.ERM_010);
		}
	}
	/**
	 * @return devuelve el valor de la variable instancia dni
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * @param dni asginamos a la varible instancia dni
	 */
	public void setDni(String dni) {
		//Validamos que no sea nulo
		//Validamos que la longitud de los caracteres está entre el min y máx
		//Validamos que el dni sea válido
		if(dni!=null && Validator.lengthValidation(dni,DNI_MIN, DNI_MAX) && Validator.dniValidation(dni, DNI_MAX, DNI_MIN)){
			this.dni = dni;
		}else{
			//Creamos la excepcion ERM_012 = "Invalid DNI"
			throw new FERSGenericException(FERSGenericException.ERM_012);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}



}
