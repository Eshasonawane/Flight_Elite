package com.mmcoe.service;

import java.util.List;

import com.mmcoe.entity.Flight;
/**
 * @author Esha Sonawane
 * @version 1.0
 * @since 2026-07-10
 */
public interface FlightService {
	Flight save(Flight f);
	Flight findByCode(int code);
	List<Flight> listAll();
	List<Flight> findByCarrier(String Carrier);
	List<Flight> findByRoute(String source,String destination);
	boolean delete(int code);
}
