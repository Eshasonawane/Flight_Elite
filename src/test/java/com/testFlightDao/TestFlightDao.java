package com.testFlightDao;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mmcoe.dao.FlightDao;
import com.mmcoe.entity.Flight;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Abhinav
 * @version 1.0
 * @since 2026-07-15
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:Flight.xml")
public class TestFlightDao {
	@Autowired
	private FlightDao flightDao;

	@Test
	public void saveFlight() {
		Flight flight = new Flight();
		flight.setCode(101);
		flight.setCarrier("Air-India");
		flight.setSource("Pune");
		flight.setDestination("Delhi");
		Flight saved = flightDao.save(flight);
		assertNotNull(saved);
	}

	@Test
	public void findByCode() {
		Flight flight = flightDao.findByCode(101);
		assertNotNull(flight);
	}

	@Test
	public void listAll() {
		List<Flight> list = flightDao.listAll();
		assertFalse(list.isEmpty());
	}

	@Test
	public void findByCarrier() {
		List<Flight> list = flightDao.findByCarrier("Air-India");
		assertFalse(list.isEmpty());
	}

	@Test
	public void findByRoute() {
		List<Flight> list = flightDao.findByRoute("Pune", "Delhi");
		assertFalse(list.isEmpty());
	}

	@Test
	public void delete() {
		boolean status = flightDao.delete(101);
		assertTrue(status);

	}

}
