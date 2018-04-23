package com.accenture.fers.entity;

import java.util.Set;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Validator;

/**
 * Accenture Technology Solutions
 * @author Diana Rodera Rojas
 * @version v1
 * @since 19/04/18
 * Clase Visitor
 */

public class Visitor extends People {

	// Declaraciones de las constantes de mínimo y máximo
	public static final int CARACTERMIN = 6;
	public static final int USERMAX = 12;
	public static final int PASSWORDMAX = 15;

	//Declaraciones de las variables de Visitor
	private int visitorId;
	private String userName;
	private String password;
	private String confirmPassword;
	private Set<Event> registeredEvents;
	/**
	 * Constructor por defecto
	 */
	public Visitor() {
	}
	/**
	 *
	 * @param visitor objeto de la clase visitor
	 */
	public Visitor(Visitor visitor) {
		//Comprobamos que el constructor no sea nulo
		if(visitor != null){
			this.visitorId = visitor.visitorId;
			this.userName = visitor.userName;
			this.password = visitor.password;
			this.registeredEvents = visitor.registeredEvents;
		}else{
			//Creamos la excepción ERM_000 = "Constructor empty"
			throw new FERSGenericException(FERSGenericException.ERM_000);
		}

	}
	/**
	 * @return un int del atributo visitorId
	 */
	public int getVisitorId() {
		return visitorId;
	}
	/**
	 * @param visitorId asignamos un string a la variable de instancia visitorID
	 */
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
	/**
	 * @return nos devuelve la variable de instancia userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName asignamos un string a la variable de instancia visitorID
	 */
	public void setUserName(String userName) {
		//Validamos: no null, rango de caracteres permitidos
		if(userName!=null && Validator.lengthValidation(userName,CARACTERMIN, USERMAX)){
			this.userName = userName;
		}else{
			//Creamos la excepción ERM_013 = "Invalid username"
			throw new FERSGenericException(FERSGenericException.ERM_013);
		}
	}
	/**
	 * @return nos devuelve la variable de instancia password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password asignamos un string a la variable de instancia password
	 */
	public void setPassword(String password) {
		//Validamos: no null, rango de caracteres permitidos
		if(password!=null && Validator.lengthValidation(password,CARACTERMIN, PASSWORDMAX)){
			this.password = password;
		}else{
			//Creamos la excepción ERM_014 = "Invalid password"
			throw new FERSGenericException(FERSGenericException.ERM_014);
		}
	}
	/**
	 * @return nos devuelve la variable de instancia confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}
	/**
	 * @param confirmPassword string asignado a la variable de instancia confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		//Validamos: no null, rango de caracteres permitidos
		if(confirmPassword!=null && Validator.lengthValidation(confirmPassword,CARACTERMIN, PASSWORDMAX)){
			this.confirmPassword = confirmPassword;
		}else{
			//Creamos la excepción ERM_009 = "Password and confirm password must be same!!"
			throw new FERSGenericException(FERSGenericException.ERM_009);
		}
	}
	/**
	 * @return nos devuelve una coleccion set de registeredEvents
	 */
	public Set<Event> getRegisteredEvents() {
		return registeredEvents;
	}
	/**
	 * @param registeredEvents coleccion de tipo set
	 */
	public void setRegisteredEvents(Set<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


}
