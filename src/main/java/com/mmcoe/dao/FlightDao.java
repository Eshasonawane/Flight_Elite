package com.mmcoe.dao;

import java.util.List;

import com.mmcoe.entity.Flight;


public interface FlightDao {

	void save(Flight obj);
	Flight findByCode(int code);
	List<Flight> listAll();
	List<Flight> findByCarrier(String Carrier);
	List<Flight> findByRoute(String source,String destination);
	void delete(Flight objk);
}
