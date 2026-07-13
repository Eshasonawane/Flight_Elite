package com.mmcoe.dao;

import java.util.List;

import com.mmcoe.entity.Flight;

public interface FlightDao {

	void save();
	Flight findByCode();
	List<Flight> listAll();
	List<Flight> findByCarrier();
	List<Flight> findByRoute();
	void delete();
}
