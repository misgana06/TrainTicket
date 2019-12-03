package com.trainticket;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Ticket {
	//	Test
	private static int counter = 100;
	private String pnr;
	private Date travelDate;
	private Train train;
	private TreeMap<Passenger,Double> passengers;

	
	public Ticket(Date travelDate, Train train) {
		this.travelDate = travelDate;
		this.train = train;
		passengers = new TreeMap<Passenger,Double>(new Comparator<Passenger>() {

			@Override
			public int compare(Passenger arg0, Passenger arg1) {
				// TODO Auto-generated method stub
				return arg0.getName().compareTo(arg1.getName());
			}
			
		});
	}
	
	//default
	public Ticket() {

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
	
	public TreeMap<Passenger, Double> getPassengers() {
		return passengers;
	}
	
	public void setPassengers(TreeMap<Passenger, Double> passengers) {
		this.passengers = passengers;
	}
	
	/*
	 * This method generates PNR Number by adding first character of source station,
	 *  first character of destination station, travel date and 
	 *  a running counter starting from 100.
	 */
	public String generatePNR() {
		//  Add Date + running counter
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = format.format(travelDate);
		String[] split = strDate.split("/");
		String finalDate = split[0]+split[1]+split[2];
		pnr = String.valueOf(train.getSource().charAt(0))+String.valueOf(train.getDestination().charAt(0)) +"_"+ finalDate +"_"+ Integer.toString(counter);
		return pnr;
	}
	
	/*
	 * This method calculates the passengers fare. If a passenger is within a certain 
	 * age threshold, they will receive a discount
	 */
	public double calcPassengerFare(Passenger p) {
		int age = p.getAge();
		char gender = Character.toLowerCase(p.getGender());
		double trainPrice = train.getTicketPrice();
		double amount = trainPrice;
		//    Make sure to lowercase method is working!
		if(gender == 'f') {
			amount = amount - (trainPrice * 0.25);
		} 
		if(age >= 60) {
			amount = trainPrice * 0.60;
		}
		if(age <= 12) {
			amount = trainPrice * 0.55;
		}
		return amount;
	}
	
	/*
	 * This method adds a passenger in tree map form, which allows us to organize
	 * the passengers and their respective fares.
	 */
	public void addPassenger(String name, int age, char gender) {

		Passenger person = new Passenger(name,age,gender);
		Double fare = calcPassengerFare(person);
		passengers.put(person, fare);
	}
	
	
	/**
	 * @return total price of the ticket by adding all the passengers ticket fares
	 */
	public double calculateTotalTicketPrice() {
		double totalprice=0;
		
		for(Entry<Passenger, Double> entry : passengers.entrySet()) { 
			totalprice+=entry.getValue();
			}
		return totalprice;
	}
	
	
	/**
	 * This method generates Ticket in the required format
	 * @return StringBuilder in certain format
	 */
	public StringBuilder generateTicket() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder ticket = new StringBuilder();
		ticket.append(String.format("%-15s%-2s%s\n","PNR",":",pnr))
		.append(String.format("%-15s%-2s%s\n","Train no",":",train.getTrainNo()))
		.append(String.format("%-15s%-2s%s\n","Train Name",":",train.getTrainName()))
		.append(String.format("%-15s%-2s%s\n","From",":",train.getSource()))
		.append(String.format("%-15s%-2s%s\n","To",":",train.getDestination()))
		.append(String.format("%-15s%-2s%s\n","Travel Date",":",df.format(travelDate)))
		.append("\n")
		.append("Passengers :\n")
		.append(String.format("%-20s%-10s%-10s%s\n", "Name","Age","Gender","Fare"));
		
		for(Entry<Passenger, Double> entry : passengers.entrySet()) { 
			Passenger p = entry.getKey();
			ticket.append(String.format("%-20s%-10s%-10s%.2f\n", p.getName(),p.getAge(),p.getGender(),entry.getValue()));
		}
		ticket.append(String.format("%s%.2f","Total Price : ", calculateTotalTicketPrice()));
		
		return ticket;
	}
	
	/**
	 * This method calls generateTicket() to generate ticket and 
	 * creates new file and writes the output of generateTicket() into it. 
	 */
	public void writeTicket() {
		File file;
		file = new File(pnr+".txt");
		if(file.exists()) {
			counter++;
			generatePNR();
			file = new File(pnr+".txt");
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		    writer.write(generateTicket().toString());
		    System.out.println("Ticket should be written to the file with filename "+pnr+".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


	