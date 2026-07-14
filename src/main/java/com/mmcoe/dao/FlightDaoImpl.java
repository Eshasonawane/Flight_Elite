package com.mmcoe.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
	public void save(Flight obj) {
		EntityManager mgr=emf.createEntityManager();
		EntityTransaction txn=mgr.getTransaction();
		txn.begin();
		mgr.persist(obj);
		txn.commit();
	}
	
	@Override
	public Flight findByCode(int code) {
		EntityManager mgr=emf.createEntityManager();
		return mgr.find(Flight.class,code);
	
	}

	@Override
	public List<Flight> findByCarrier(String Carrier) {
		EntityManager mgr=emf.createEntityManager();
		return mgr.createQuery("FROM Flight f where f.carrier=:carrier").setParameter("carrier",Carrier).getResultList();
	}

	@Override
	public List<Flight> findByRoute(String source, String destination) {
		EntityManager mgr=emf.createEntityManager();
		return mgr.createQuery("From Flight f f.source =:source & f.destionation=:destination").setParameter("source",source).setParameter("destination",destination).getResultList();
	}
	
	@Override
	public List<Flight> listAll() {
		EntityManager mgr=emf.createEntityManager();
		return mgr.createQuery("FROM Flight").getResultList();
	}


	@Override
	public void delete(Flight obj) {
		EntityManager mgr=emf.createEntityManager();
		mgr.remove(obj);
		
		
	}




	
	
}
