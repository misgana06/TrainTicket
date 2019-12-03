package com.trainticket;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 TrainDAO train = new TrainDAO();
	 Train obj = train.findTrain(1001);
	 Date d1 = new Date();
	 Ticket t1 = new Ticket(d1,obj);
     t1.addPassenger("Test",12,'F');
     t1.addPassenger("Moh", 24, 'M');
     t1.generatePNR();
     t1.writeTicket();
     

      
	}

}
