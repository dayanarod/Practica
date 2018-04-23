/**
 *
 */
package com.accenture.fers.test.entity;

import static org.junit.Assert.*;

import java.util.function.Consumer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.accenture.fers.entity.Event;
import com.accenture.fers.exceptions.FERSGenericException;

/**
 * @author Sonia Borreguero Niño
 * @since 17/04/2018
 * @version v1 Clase de prueba Event Test
 */
public class EventTest {

	/**
	 * @throws java.lang.Exception
	 */

	Event evento = new Event();

	@Before
	public void setUp() throws Exception {
		evento.setEventId(1);
		evento.setName("Marathon");
		evento.setDescription("Run");
		evento.setPlace("Segovia");
		evento.setDuration("4 horas");
		evento.setEventType("Sport");
		evento.setSeatsAvailable(20);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#Event(com.accenture.fers.entity.Event)}
	 * .
	 */
	@Test
	public void testEventEvent() {
		Event evento1 = evento;
		assertEquals(evento1, evento);
	}

	@Test
	public void testEventEventNegative() {
		Consumer<Event> consumer = dato -> new Event(dato);
		assertFail(consumer, null, FERSGenericException.ERM_000);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Event#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("Marathon", evento.getName());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setName(java.lang.String)}.
	 */
	@Test
	// Método para probar caso positivo
	public void testSetNamePositive() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		evento.setName("a");
		assertEquals("a", evento.getName());

		// Valoremos que este en el máximo permitido
		evento.setName(cadenaString("A", 45));
		assertEquals(cadenaString("A", 45), evento.getName());
	}

	// Primera version(version larga)
	/*
	 * @Test public void testSetNameNegativeNull() { try{ evento.setName(null);
	 * fail("Not yet implemented"); }catch(Exception ex){
	 * assertEquals(FERSGenericException.ERM_018, ex.getMessage()); } }
	 *
	 * @Test public void testSetNameNegativeMin() {
	 *
	 * try{ evento.setName(""); fail("Not yet implemented"); }catch(Exception
	 * ex){ assertEquals(FERSGenericException.ERM_018, ex.getMessage()); } }
	 *
	 * @Test public void testSetNameNegativeMax() {
	 *
	 * try{ evento.setName(cadenaString("A",46)); fail("Not yet implemented");
	 * }catch(Exception ex){ assertEquals(FERSGenericException.ERM_018,
	 * ex.getMessage()); } }
	 */
	// Version 2.(Método corto)
	@Test
	public void testSetNameNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> evento.setName(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_018);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_018);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 46),
				FERSGenericException.ERM_018);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Event#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		assertEquals("Run", evento.getDescription());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescriptionPositive() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		evento.setDescription("a");
		assertEquals("a", evento.getDescription());

		// Valoremos que este en el máximo permitido
		evento.setDescription(cadenaString("A", 45));
		assertEquals(cadenaString("A", 45), evento.getDescription());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescriptionNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> evento.setDescription(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_019);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_019);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 46),
				FERSGenericException.ERM_019);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Event#getPlace()}.
	 */
	@Test
	public void testGetPlace() {
		assertEquals("Segovia", evento.getPlace());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setPlace(java.lang.String)}.
	 */
	@Test
	public void testSetPlacePositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		evento.setPlace("a");
		assertEquals("a", evento.getPlace());

		// Valoremos que este en el máximo permitido
		evento.setPlace(cadenaString("A", 45));
		assertEquals(cadenaString("A", 45), evento.getPlace());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setPlace(java.lang.String)}.
	 */
	@Test
	public void testSetPlaceNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> evento.setPlace(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_020);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_020);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 46),
				FERSGenericException.ERM_020);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Event#getDuration()}.
	 */
	@Test
	public void testGetDuration() {
		assertEquals("4 horas", evento.getDuration());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setDuration(java.lang.String)}.
	 */
	@Test
	public void testSetDurationPositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		evento.setDuration("a");
		assertEquals("a", evento.getDuration());

		// Valoremos que este en el máximo permitido
		evento.setDuration(cadenaString("A", 45));
		assertEquals(cadenaString("A", 45), evento.getDuration());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setDuration(java.lang.String)}.
	 */
	@Test
	public void testSetDurationNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> evento.setDuration(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_021);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_021);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 46),
				FERSGenericException.ERM_021);
	}

	/**
	 * Test method for {@link com.accenture.fers.entity.Event#getEventType()}.
	 */
	@Test
	public void testGetEventType() {
		assertEquals("Sport", evento.getEventType());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setEventType(java.lang.String)}.
	 */
	@Test
	public void testSetEventTypePositivo() {
		// Primero valoramos que esté en el mínimo permitido
		// Damos un valor a nuestro objeto
		evento.setEventType("a");
		assertEquals("a", evento.getEventType());

		// Valoremos que este en el máximo permitido
		evento.setEventType(cadenaString("A", 45));
		assertEquals(cadenaString("A", 45), evento.getEventType());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setEventType(java.lang.String)}.
	 */
	@Test
	public void testSetEventTypeNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<String> consumer = dato -> evento.setEventType(dato);

		// Caso null
		assertFail(consumer, null, FERSGenericException.ERM_022);

		// Caso por debajo del mínimo
		assertFail(consumer, "", FERSGenericException.ERM_022);

		// Caso por encima del máximo
		assertFail(consumer, cadenaString("A", 46),
				FERSGenericException.ERM_022);
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#getSeatsAvailable()}.
	 */
	@Test
	public void testGetSeatsAvailable() {
		assertEquals(20, evento.getSeatsAvailable());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setSeatsAvailable(int)}.
	 */
	@Test
	public void testSetSeatsAvailablePositivo() {
		// Damos un valor a nuestro objeto
		// Probamos con un 0
		evento.setSeatsAvailable(0);
		assertEquals(0, evento.getSeatsAvailable());
	}

	/**
	 * Test method for
	 * {@link com.accenture.fers.entity.Event#setSeatsAvailable(int)}.
	 */
	@Test
	public void testSetSeatsAvailableNegativo() {
		// Creamos nuestra expresion lambda de tipo Consumer
		Consumer<Integer> consumer = dato -> evento.setSeatsAvailable(dato);

		// Caso menos de 0
		assertFail(consumer, -1, FERSGenericException.ERM_023);


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
