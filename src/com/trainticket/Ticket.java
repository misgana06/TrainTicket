package com.trainticket;

import java.util.Date;
import java.util.TreeMap;

public class Ticket {
	
	private static int counter;
	
	private String pnr;
	private Date travelDate;
	private Train train;
	private TreeMap<Passenger,Integer> passengers;
	
	
	
	public Ticket(Date travelDate, Train train) {
		this.travelDate = travelDate;
		this.train = train;
	}
	
	public static int getCounter() {
		return counter;
	}
	
	public static void setCounter(int counter) {
		Ticket.counter = counter;
	}
	
	public String getPnr() {
		return pnr;
	}
	
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	public Date getTravelDate() {
		return travelDate;
	}
	
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	
	public Train getTrain() {
		return train;
	}
	
	public void setTrain(Train train) {
		this.train = train;
	}
	
	public TreeMap<Passenger, Integer> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(TreeMap<Passenger, Integer> passengers) {
		this.passengers = passengers;
	}
	
	
	public String generatePNR() {
		return "";
	}
	
	public double calcPassengerFare(Passenger p) {
		return 0.00;
	}
	
	public void addPassenger(String name, int age, char gender) {
		
	}
	
	public double calculateTotalTicketPrice() {
		return 0.00;
	}
	
	public StringBuilder generateTicket() {
		return null;
	}
	
	public void writeTicket() {
		
	}
}
