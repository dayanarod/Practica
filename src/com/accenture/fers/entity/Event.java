package com.accenture.fers.entity;

import com.accenture.fers.exceptions.FERSGenericException;
import com.accenture.fers.utils.Validator;

/**
 * Accenture Technology Solutions
 * @author Diana Rodera Rojas
 * @version v1
 * @since 19/04/18
 * Clase Event
 */

public class Event {


	//Declaración de variables constantes para los caracteres mín y max
	public static final int CARACTERMIN = 1;
	public static final int CARACTERMAX = 45;


	//Declaracion de variables de la clase Event
	private int eventId;
	private String name;
	private String description;
	private String place;
	private String duration;
	private String eventType;
	private int seatsAvailable;

	/**
	 * Default constructor
	 */
	public Event() {}
	/**
	 * @param event: Pasamos al constructor un objeto Event
	 */
	public Event(Event event) {
		//Comprobamos que el constructor no sea nulo
		if(event !=null){
			this.eventId = event.eventId;
			this.name = event.name;
			this.description = event.description;
			this.place = event.place;
			this.duration = event.duration;
			this.eventType = event.eventType;
			this.seatsAvailable = event.seatsAvailable;

		}else{
			throw new FERSGenericException(FERSGenericException.ERM_000);
		}

	}
	/**
	 * @return nos devuelve la variable de instancia eventId
	 */
	public int getEventId() {
		return eventId;
	}
	/**
	 *
	 * @param eventId asignamos un string a la variable de instancia eventId
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	/**
	 *
	 * @return nos devuelve la variable de instancia name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name asignamos un string a la variable de instancia name
	 */
	public void setName(String name) {
		//Comprobamos que no sea nulo y que esté en el rango de min y max de caracteres
		if(name!=null && Validator.lengthValidation(name,CARACTERMIN, CARACTERMAX)){
			this.name = name;
		}else{
			//Creamos excepción ERM_018 = "Invalid Event Name"
			throw new FERSGenericException(FERSGenericException.ERM_018);
		}
	}
	/**
	 * @return nos devuelve la variable de instancia description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description asignamos un string a la variable de instancia description
	 */
	public void setDescription(String description) {
		//Validamos que no sea nulo y que esté en el rango de min y max de caracteres
		if(description!=null && Validator.lengthValidation(description,CARACTERMIN, CARACTERMAX)){
			this.description = description;
		}else{
			//Creamos excepción ERM_019 = "Invalid Event Description"
			throw new FERSGenericException(FERSGenericException.ERM_019);
		}
	}
	/**
	 * @return nos devuelve la variable de instancia place
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * @param place asignamos un string a la variable de instancia place
	 */
	public void setPlace(String place) {
		//Validamos que no sea nulo y que esté en el rango de min y max de caracteres
		if(place!=null && Validator.lengthValidation(place,CARACTERMIN, CARACTERMAX)){
			this.place = place;
		}else{
			//Creamos excepción ERM_020 = "Invalid Event Place"
			throw new FERSGenericException(FERSGenericException.ERM_020);
		}
	}
	/**
	 * @return nos devuelve la variable de instancia duration
	 */
	public String getDuration() {
		return duration;
	}
	/**
	 * @param duration asignamos un string a la variable de instancia duration
	 */
	public void setDuration(String duration) {
		//Validamos que no sea nulo y que esté en el rango de min y max de caracteres
		if(duration!=null && Validator.lengthValidation(duration,CARACTERMIN, CARACTERMAX)){
			this.duration = duration;
		}else{
			//Creamos excepción ERM_021 = "Invalid Event Duration"
			throw new FERSGenericException(FERSGenericException.ERM_021);
		}
	}
	/**
	 * @return nos devuelve la variable de instancia eventType
	 */
	public String getEventType() {
		return eventType;
	}
	/**
	 * @param eventType asignamos un string a la variable de instancia eventType
	 */
	public void setEventType(String eventType) {
		//Validamos que no sea nulo y que esté en el rango de min y max de caracteres
		if(eventType!=null && Validator.lengthValidation(eventType,CARACTERMIN, CARACTERMAX)){
			this.eventType = eventType;
		}else{
			//Creamos excepción ERM_022 = "Invalid Event Type"
			throw new FERSGenericException(FERSGenericException.ERM_022);
		}
	}
	/**
	 * @return nos devuelve la variable de instancia seatsAvailable
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	/**
	 * @param seatsAvailable asignamos un string a la variable de instancia seatsAvailable
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		//Validamos que seatsAvailable sea mayor o igual que 0
		if(seatsAvailable >=0){
			this.seatsAvailable = seatsAvailable;
		}else{
			//Creamos excepción ERM_023 = "Invalid SeatsAvailable"
			throw new FERSGenericException(FERSGenericException.ERM_023);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result
				+ ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + seatsAvailable;
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
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (seatsAvailable != other.seatsAvailable)
			return false;
		return true;
	}


}
