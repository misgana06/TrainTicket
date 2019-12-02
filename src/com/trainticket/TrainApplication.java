package com.trainticket;

import java.sql.Date;

public class TrainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 TrainDAO train = new TrainDAO();
	 Train obj = train.findTrain(1001);
	 
	 Date d1 = new Date(0,0,0);
	 Ticket t1 = new Ticket(d1,obj);
     Passenger p = new Passenger("Test", 12,'F');
     System.out.println(t1.generatePNR());
     

      
	}

}
