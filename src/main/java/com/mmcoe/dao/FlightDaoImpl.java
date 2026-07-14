package com.mmcoe.dao;

import java.util.List;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.mmcoe.entity.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

	private static EntityManagerFactory emf;

	static {
		emf=Persistence.createEntityManagerFactory("MyJPA");
	}
	@Override
	public void save() {
				
		
	}
	
	@Override
	public Flight findByCode(int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findByCarrier(String Carrier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> findByRoute(String source, String destination) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Flight> listAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}




	
	
}
