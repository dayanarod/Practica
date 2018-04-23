/**
 *
 */
package com.accenture.fers.test.entity;

import static org.junit.Assert.*;

import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.fers.entity.People;
import com.accenture.fers.entity.Visitor;
import com.accenture.fers.exceptions.FERSGenericException;

/**
 * @author Sonia Borreguero Niño
 *
 */
public class VisitorTest {

	/**
	 * @throws java.lang.Exception
	 */
	People people = new People();
	Visitor visitor = new Visitor();

	@Before
	public void setUp() throws Exception {
		visitor.setAddress("calle valdemoro");
		visitor.setFirstName("Sonia");
		visitor.setLastName("Borreguero");
		visitor.setEmail("xhelis@hotmail");
		visitor.setPhoneNumber("+34 555 555 555");
		visitor.setDni("53.426.182-b");
		visitor.setUserName("Pepita1");
		visitor.setPassword("1234567");
		visitor.setConfirmPassword("1234567");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Visitor#Visitor()}.
	 */
	@Test
	public void testVisitorPositivo() {
		Visitor visitor1 = visitor;
		assertEquals(visitor1, visitor);
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Visitor#Visitor(com.accenture.fers.entity.Visitor)}
	 * .
	 */
	@Test
	public void testVisitorVisitorNegativo() {
		Consumer<Visitor> consumer = dato -> new Visitor(dato);
		assertFail(consumer, null, FERSGenericException.ERM_000);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Visitor#getUserName()}.
	 */
	@Test
	public void testGetUserName() {
		assertEquals("Pepita1", visitor.getUserName());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Visitor#setUserName(java.lang.String)}.
	 */
	@Test
	public void testSetUserNamePositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setUserName(cadenaString("A", 6));
		assertEquals(cadenaString("A", 6), visitor.getUserName());

		// Valoremos que este en el máximo permitido
		visitor.setUserName(cadenaString("A", 12));
		assertEquals(cadenaString("A", 12), visitor.getUserName());
	}

	@Test
	public void testSetUserNameNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> visitor.setUserName(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_013);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_013);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 13), FERSGenericException.ERM_013);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Visitor#getPassword()}.
	 */
	@Test
	public void testGetPassword() {
		assertEquals("1234567", visitor.getPassword());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Visitor#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPasswordPositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setPassword(cadenaString("A", 6));
		assertEquals(cadenaString("A", 6), visitor.getPassword());

		// Valoremos que este en el máximo permitido
		visitor.setPassword(cadenaString("A", 15));
		assertEquals(cadenaString("A", 15), visitor.getPassword());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Visitor#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPasswordNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> visitor.setPassword(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_014);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_014);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 16), FERSGenericException.ERM_014);
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Visitor#getConfirmPassword()}.
	 */
	@Test
	public void testGetConfirmPassword() {
		assertEquals("1234567", visitor.getConfirmPassword());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Visitor#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetConfirmPasswordPositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setConfirmPassword(cadenaString("A", 6));
		assertEquals(cadenaString("A", 6), visitor.getConfirmPassword());

		// Valoremos que este en el máximo permitido
		visitor.setConfirmPassword(cadenaString("A", 15));
		assertEquals(cadenaString("A", 15), visitor.getConfirmPassword());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Visitor#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetConfirmPasswordNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> visitor.setConfirmPassword(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_009);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_009);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 16), FERSGenericException.ERM_009);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.People#People()}.
	 */
	@Test
	public void testPeople() {
		People people1 = people;
		assertEquals(people1, people);
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#People(com.accenture.fers.entity.People)}
	 * .
	 */
	@Test
	public void testPeoplePeople() {
		Consumer<People> consumer = dato -> new People(dato);
		assertFail(consumer, null, FERSGenericException.ERM_000);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.People#getAddress()}.
	 */
	@Test
	public void testGetAddress() {
		assertEquals("calle valdemoro", visitor.getAddress());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setAddress(java.lang.String)}.
	 */
	@Test
	public void testSetAddressPositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setAddress("");
		assertEquals("", visitor.getAddress());

		// Valoremos que este en el máximo permitido
		visitor.setAddress(cadenaString("A", 30));
		assertEquals(cadenaString("A", 30), visitor.getAddress());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setAddress(java.lang.String)}.
	 */
	@Test
	public void testSetAddressNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> visitor.setAddress(dato);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 31), FERSGenericException.ERM_017);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.People#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		assertEquals("Sonia", visitor.getFirstName());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstNamePositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		people.setFirstName("a");
		assertEquals("a", people.getFirstName());

		// Valoremos que este en el máximo permitido
		people.setFirstName(cadenaString("A", 30));
		assertEquals(cadenaString("A", 30), people.getFirstName());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstNameNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> people.setFirstName(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_015);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_015);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 31), FERSGenericException.ERM_015);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.People#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		assertEquals("Borreguero", visitor.getLastName());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setLastName(java.lang.String)}.
	 */
	@Test
	public void testSetLastNamePositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setLastName("a");
		assertEquals("a", visitor.getLastName());

		// Valoremos que este en el máximo permitido
		visitor.setLastName(cadenaString("A", 30));
		assertEquals(cadenaString("A", 30), visitor.getLastName());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setLastName(java.lang.String)}.
	 */
	@Test
	public void testSetLastNameNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> visitor.setLastName(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_016);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_016);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 31), FERSGenericException.ERM_016);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.People#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		assertEquals("xhelis@hotmail", visitor.getEmail());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetEmailPositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setEmail("a@3");
		assertEquals("a@3", visitor.getEmail());

		// Valoremos que este en el máximo permitido
		visitor.setEmail("a@" + cadenaString("A", 198));
		assertEquals("a@" + cadenaString("A", 198), visitor.getEmail());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetEmailNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> visitor.setEmail(dato);
		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_011);
		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_011);
		// Caso: El local termina con un punto
		assertFail(consumer, "sonia.@ss", FERSGenericException.ERM_011);
		// Caso: Contiene más de un @
		assertFail(consumer, "sonia@@s", FERSGenericException.ERM_011);
		// Caso: El dominio está vacio
		assertFail(consumer, "sonia@", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " ( "
		assertFail(consumer, "sonia@s(", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " ) "
		assertFail(consumer, "sonia@s)", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " [ "
		assertFail(consumer, "sonia@s[", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " ] "
		assertFail(consumer, "sonia@s]", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " ; "
		assertFail(consumer, "sonia@s;", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " : "
		assertFail(consumer, "sonia@s:", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " , "
		assertFail(consumer, "sonia@s,", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " < "
		assertFail(consumer, "sonia@s<", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " > "
		assertFail(consumer, "sonia@s>", FERSGenericException.ERM_011);
		// Caso: Contiene un caracter no permitido " - "
		assertFail(consumer, "sonia@s-", FERSGenericException.ERM_011);
		// Caso por encima del máximo
		assertFail(consumer, "a@" + cadenaString("A", 200), FERSGenericException.ERM_011);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.People#getPhoneNumber()} .
	 */
	@Test
	public void testGetPhoneNumber() {
		assertEquals("+34 555 555 555", visitor.getPhoneNumber());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setPhoneNumber(java.lang.String)} .
	 */
	@Test
	public void testSetPhoneNumberPositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setPhoneNumber("1234567890");
		assertEquals("1234567890", visitor.getPhoneNumber());

		// Valoremos que este en el máximo permitido
		visitor.setPhoneNumber(cadenaString("1", 20));
		assertEquals(cadenaString("1", 20), visitor.getPhoneNumber());

		// Valoremos que este en empiece por +
		visitor.setPhoneNumber("+" + cadenaString("1", 15));
		assertEquals("+" + cadenaString("1", 15), visitor.getPhoneNumber());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setPhoneNumber(java.lang.String)} .
	 */
	@Test
	public void testSetPhoneNumberNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> people.setPhoneNumber(dato);
		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_010);
		// Caso: contenga algun caracter alfabético
		assertFail(consumer, "123456789a", FERSGenericException.ERM_010);
		// Caso por encima del máximo
		assertFail(consumer, cadenaString("1", 21), FERSGenericException.ERM_010);
		// Caso por encima del minimo
		assertFail(consumer, cadenaString("1", 1), FERSGenericException.ERM_010);

	}

	/**
	 * Test method for {@link com.accenture.fers.entity.People#getDni()}.
	 */
	@Test
	public void testGetDniPositivo() {
		assertEquals("53.426.182-b", visitor.getDni());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setDni(java.lang.String)}.
	 */
	@Test
	public void testSetDniPositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		visitor.setDni("53.426.182-b");
		assertEquals("53.426.182-b", visitor.getDni());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.People#setDni(java.lang.String)}.
	 */
	@Test
	public void testSetDniNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> visitor.setDni(dato);
		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_012);
		// Sin letra
		assertFail(consumer, "53.426.182-", FERSGenericException.ERM_012);
		// Sin letra erronea
		assertFail(consumer, "53.426.182-A", FERSGenericException.ERM_012);
		// Sin puntos
		assertFail(consumer, "00052426182B", FERSGenericException.ERM_012);
		// Menos numeros
		assertFail(consumer, "2.426.182-B", FERSGenericException.ERM_012);
	}

	// metodo generar un string
	private String cadenaString(String letra, int veces) {
		String palabra = "";
		for (int i = 0; i < veces; i++) {
			palabra = palabra + letra;
		}
		return palabra;
	}

	private <T> void assertFail(Consumer<T> consumer, T dato, String mensaje) {
		try {
			consumer.accept(dato);
			fail("Deberia haber saltado la excepcion");
		} catch (Exception ex) {
			assertEquals(mensaje, ex.getMessage());
		}

	}

}
