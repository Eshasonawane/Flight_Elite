package com.mmcoe.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="flights")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int code;
	@Column(length = 50)
	String carrier;
	@Column(length=30)
	String source;
	@Column(length = 30)
	String destination;
	@Override
	public String toString() {
		return "Flight [code=" + code + ", carrier=" + carrier + ", source=" + source + ", destination=" + destination
				+ "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Flight() {
	}
	public Flight(int code, String carrier, String source, String destination) {
		this.code = code;
		this.carrier = carrier;
		this.source = source;
		this.destination = destination;
	}
	
}
