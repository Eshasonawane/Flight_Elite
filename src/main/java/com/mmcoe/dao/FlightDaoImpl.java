package com.mmcoe.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mmcoe.entity.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

	private static EntityManagerFactory emf;

	static {
		emf=Persistence.createEntityManagerFactory("MyJPA");
	}
	
	@Override
	public Flight save(Flight f) {
		EntityManager mgr=emf.createEntityManager();
		EntityTransaction txn=mgr.getTransaction();
		try {
		txn.begin();
		mgr.persist(f);
		txn.commit();
		return f;
		}catch(Exception e)
		{
			e.printStackTrace();
			txn.rollback();
			return null;
		}finally {
			mgr.close();
		}
	}
	
	@Override
	public Flight findByCode(int code) {
		EntityManager mgr=emf.createEntityManager();
		try {
		return mgr.find(Flight.class,code);
		}finally {
			mgr.close();
		}
	
	}

	@Override
	public List<Flight> findByCarrier(String carrier) {
		String hql="FROM Flight WHERE carrier=:carrier";
		EntityManager mgr=emf.createEntityManager();
		try {
		Query query=mgr.createQuery(hql);
		query.setParameter("carrier",carrier);
		return query.getResultList();
		}finally {
			mgr.close();
		}
	
	}

	@Override
	public List<Flight> findByRoute(String source, String destination) {
		String hql="FROM Flight WHERE source=:source AND destination=:destination";
		EntityManager mgr=emf.createEntityManager();
		try{Query query=mgr.createQuery(hql);
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		return query.getResultList();
		}
		finally {
			mgr.close();
		}
	}
	
	public List<Flight> listAll() {
		EntityManager mgr=emf.createEntityManager();
		try{
		return mgr.createQuery("FROM Flight").getResultList();
		}finally {
			mgr.close();
		}
	}


	@Override
	public boolean delete(int code) {
		EntityManager mgr=emf.createEntityManager();
		EntityTransaction txn=mgr.getTransaction();
		try {
		txn.begin();
		Flight f = mgr.find(Flight.class,code );
		mgr.remove(f);
		txn.commit();
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			txn.rollback();
			return false;
		}
		finally {
			mgr.close();
		}
	}
}
