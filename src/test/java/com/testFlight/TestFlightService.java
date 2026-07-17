package com.testFlight;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mmcoe.entity.Flight;
import com.mmcoe.service.FlightNotFoundException;
import com.mmcoe.service.FlightService;
import com.mmcoe.service.InvalidFlightException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:Flight.xml")
public class TestFlightService {

	@Autowired
	private FlightService flightService;

	@Test
	public void testSaveFlight() {

		Flight flight = new Flight();
		flight.setCarrier("Air India");
		flight.setSource("Kolkata");
		flight.setDestination("Delhi");

		Flight saved = flightService.save(flight);

		assertNotNull(saved);
	}

	@Test
	public void testSaveNullFlight() {

		assertThrows(InvalidFlightException.class, () -> {
			flightService.save(null);
		});
	}

	@Test
	public void testSameSourceDestination() {

		Flight flight = new Flight();
		flight.setCarrier("Indigo");
		flight.setSource("Pune");
		flight.setDestination("Pune");

		assertThrows(InvalidFlightException.class, () -> {
			flightService.save(flight);
		});
	}

	@Test
	public void testFindByCode() {

		Flight flight = flightService.findByCode(5);

		assertNotNull(flight);
	}

	@Test
	public void testFlightNotFound() {

		assertThrows(FlightNotFoundException.class, () -> {
			flightService.findByCode(9);
		});
	}

	@Test
	public void testListAll() {

		List<Flight> flights = flightService.listAll();

		assertFalse(flights.isEmpty());
	}

	@Test
	public void testFindByCarrier() {

		List<Flight> flights = flightService.findByCarrier("Air India");

		assertFalse(flights.isEmpty());
	}

	@Test
	public void testFindByRoute() {

		List<Flight> flights = flightService.findByRoute("Pune", "Delhi");

		assertFalse(flights.isEmpty());
	}

	@Test
	public void testDelete() {

		boolean status = flightService.delete(4);

		assertTrue(status);
	}

	@Test
	public void testDeleteInvalidFlight() {

		assertThrows(FlightNotFoundException.class, () -> {
			flightService.delete(9);
		});
	}
	// Exception Tests

}