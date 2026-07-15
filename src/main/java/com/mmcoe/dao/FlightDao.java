package com.mmcoe.dao;

import java.util.List;

import com.mmcoe.entity.Flight;


public interface FlightDao {
	/**
	 * @author Esha Sonawane
	 * @version 1.0
	 * @since 2026-07-10
	 */
	Flight save(Flight obj);
	Flight findByCode(int code);
	List<Flight> listAll();
	List<Flight> findByCarrier(String Carrier);
	List<Flight> findByRoute(String source,String destination);
	boolean delete(int code);
}
