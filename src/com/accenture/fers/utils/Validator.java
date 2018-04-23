package com.accenture.fers.utils;

/**
 * @author Sonia Borreguero Niño
 * @since 17/04/18
 * @version v1 This class validates data introduced by the user
 */

public class Validator {
	/**
	 * Método para saber si está en el rango de la longitud máxima y mínima
	 * @param input: la cadena de caracteres que escribe el usuario
	 * @param max constante definida como maximo de caracteres permitido
	 * @param min constante definida como mínimo de caracteres permitido
	 * @return isValid (false/true): devuelve positivo si cumple la condición o negativo si
	 *         no la cumple
	 */
	public static boolean lengthValidation(String input, int min, int max) {
		boolean isValid = false;
		// variable int para saber la cantidad de letras del input
		int longitud = input.length();
		// Condicion: para determinar si está en el rango de min y max
		if (longitud <= max && longitud >= min) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Método para comprobar si un email es válido
	 * @param email:la cadena de caracteres que escribe el usuario
	 * @param max: constante definida como maximo de caracteres permitido
	 * @param min: constante definida como min de caracteres permitido
	 * @return isValid (false/true): devuelve positivo si cumple la condición o negativo si no
	 *         la cumple
	 */
	public static boolean emailValidation(String email, int max, int min) {
		boolean isValid = false;
		// variables int
		int posicionArroba;
		// variables string
		String parteLocal, parteDominio;
		char[] charArray = email.toCharArray();
		int numArrobas = 0;
		// Se define el array tipo char
		char[] forbiddenChars = { '(', ')', '[', ']', '\\', ',', ';', ':', '<', '>', '-' };

		// Validacion de la longitud que sea true
		if (lengthValidation(email, min, max) == true) {
			if (email.contains("@")) {
				// Contamos cuantas @ contiene
				for (Character c : charArray) {
					if (c.equals('@')) {
						numArrobas++;
					}
				}

				if (numArrobas == 1) {
					posicionArroba = email.indexOf('@');
					boolean containsForbiddenChar = false;
					// Comprobamos que no tenga chars no permitidos
					for (Character c : charArray) {
						for (Character forbiddenChar : forbiddenChars) {
							if (c.equals(forbiddenChar)) {
								containsForbiddenChar = true;
							}
						}
					}

					if (!containsForbiddenChar) {
						// Definimos los dos conjuntos(variables) para diferenciarlos:
						// primera parte , segunda parte
						parteLocal = email.substring(0, posicionArroba);
						parteDominio = email.substring(posicionArroba + 1, email.length());
						// Condición que ninguna de las 2 partes este vacia
						if (!parteLocal.isEmpty() && !parteDominio.isEmpty()) {
							if (!parteLocal.endsWith(".")) {
								isValid = true;
							}
						}
					}
				}
			}
		}
		return isValid;
	}

	/**
	 * Método para comprobar si el número de teléfono es válido
	 * @param numero: la cadena de caracteres que escribe el usuario
	 * @param max: constante definida como maximo de caracteres permitido
	 * @param min: constante definida como min de caracteres permitido
	 * @return isValid (false/true): devuelve positivo si cumple la condición o negativo si no
	 *         la cumple
	 */
	public static boolean phoneValidation(String numero, int max, int min) {
		// variable booleana
		boolean isValid = false;
		char[] charArray = numero.trim().toCharArray();

		// Validación de la longitud que sea true
		if (lengthValidation(numero, min, max)) {
			// Validamos que el primer caracter sea + o dígito
			if (numero.startsWith("+") || numero.startsWith("1") || numero.startsWith("2") || numero.startsWith("3")
					|| numero.startsWith("4") || numero.startsWith("5") || numero.startsWith("6")
					|| numero.startsWith("7") || numero.startsWith("8") || numero.startsWith("9")
					|| numero.startsWith("0")) {
				// Validamos que los restantes caracteres son dígitos
				for (int i = 1; i < charArray.length; i++) {
					Character c = charArray[i];
					if (Character.isDigit(c) || c.equals(' ')) {
						isValid = true;
					} else {
						isValid = false;
						break;
					}
				}
			} else {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * Método para comprobar si el DNI es válido
	 * @param dni: la cadena de caracteres que escribe el usuario
	 * @param max: constante definida como maximo de caracteres permitido
	 * @param min: constante definida como min de caracteres permitido
	 * @return isValid (false/true): devuelve positivo si cumple la condición o negativo si no
	 *         la cumple
	 */
	public static boolean dniValidation(String dni, int max, int min) {
		boolean isValid = false;
		if(lengthValidation(dni, min, max)) {
			if (dni.startsWith("1") || dni.startsWith("2") || dni.startsWith("3") || dni.startsWith("4")
					|| dni.startsWith("5") || dni.startsWith("6") || dni.startsWith("7") || dni.startsWith("8")
					|| dni.startsWith("9") || dni.startsWith("0")) {

				char[] caracterDNI = dni.toCharArray();

				// Comprobamos que tenga el formato xx.xxx.xxx-x
				if (caracterDNI[2] == '.' && caracterDNI[6] == '.' && caracterDNI[10] == '-') {

					// Cogemos la letra del DNI
					char letra = dni.charAt(dni.length() - 1);

					// Cogemos los numeros del dni y lo parseamos a Int
					String dniformateado = dni.substring(0, dni.length() - 2).replace(".", "");
					int numerosDni = Integer.parseInt(dniformateado);

					// Tabla de conversion letra DNI: para saber que letra debería tener
					char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
							'V', 'H', 'L', 'C', 'K', 'E' };
					int operacion = numerosDni % 23;
					char letraCorrecta = letras[operacion];

					// Comprobamos que la letra del DNI es correcta
					if (Character.toUpperCase(letra) == letraCorrecta) {
						isValid = true;
					}
				}
			}
		}

		return isValid;
	}

}
