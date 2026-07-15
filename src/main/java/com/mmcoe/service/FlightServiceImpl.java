package com.mmcoe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmcoe.dao.FlightDao;
import com.mmcoe.entity.Flight;
/**
 * @author Esha Sonawane
 * @version 1.0
 * @since 2026-07-10
 */
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao dao;
	
	@Override
	public Flight save(Flight f) {
		if(f==null)
		{
			throw new InvalidFlightException("Flight object cannot be null");
		}
		if(f.getSource().equalsIgnoreCase(f.getDestination()))
		{
			throw new InvalidFlightException("Source and Destination annot be same");
		}
		return dao.save(f);
	}

	@Override
	public Flight findByCode(int code) {
		Flight f=dao.findByCode(code);
		if(f==null)
		{
			throw new FlightNotFoundException("Flight not found for code: "+f.getCode());
		}
		return f;
	}

	@Override
	public List<Flight> listAll() {
		List<Flight> flights=dao.listAll();
		if(flights.isEmpty())
		{
			throw new FlightNotFoundException("No Flights are available");
		}
		return flights;
	}

	@Override
	public List<Flight> findByCarrier(String carrier) {
		List<Flight> flights=dao.findByCarrier(carrier);
		if(flights.isEmpty())
		{
			throw new FlightNotFoundException("No flights find wit carrier: "+carrier);
		}
		return flights;
	}

	@Override
	public List<Flight> findByRoute(String source, String destination) {
		List<Flight> flights = dao.findByRoute(source, destination);

	    if (flights.isEmpty()) {
	        throw new FlightNotFoundException(
	                "No flights found between " + source + " and " + destination);
	    	}

	    return flights;
	}

	@Override
	public boolean delete(int code) {
		Flight flight=dao.findByCode(code);
		if(flight==null)
		{
			throw new FlightNotFoundException("Flight not found for code: "+flight.getCode());
		}
		return dao.delete(code);
	}

	
}
