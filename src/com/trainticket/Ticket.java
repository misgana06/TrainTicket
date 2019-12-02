package com.trainticket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
public class Ticket {
	
	private static int counter;
	private String pnr;
	private Date travelDate;
	private static Train train;
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
//      Add Date + running counter
      SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
      String strDate = format.format(travelDate);
      String[] split = strDate.split("/");
      String finalDate = "";
      for(int i = 0; i < split.length; i++) {
          finalDate += split[i];
      }
  String pnr = train.getSource().charAt(0) + train.getDestination().charAt(0) +"_"+ finalDate +"_"+ Integer.toString(counter++);
  return pnr;
	}
	
	public static double calcPassengerFare(Passenger p) {
        int age = p.getAge();
        char gender = Character.toLowerCase(p.getGender());
        double trainPrice = train.getTicketPrice();
        double amount = trainPrice;
//        Make sure to lowercase method is working!
        if(gender == 'f') {
            amount = amount - (trainPrice * 0.25);
        }
        if(age >= 60) {
            amount = amount - (trainPrice * 0.60);
        }
        if(age <= 12) {
            amount = amount - (trainPrice * 0.55);
        }
        return amount;
	}
	public void addPassenger(String name, int age, char gender) {
		
		 Passenger person = new Passenger(name,age,gender);
		 int fare = (int)calcPassengerFare(person);
		 passengers.put(person, fare);
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