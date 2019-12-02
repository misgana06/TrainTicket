package com.trainticket;

public class TrainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      TrainDAO obj= new TrainDAO();
     Train obj2 =  obj.findTrain(1001);
      
  
      
 
     System.out.print(obj2.trainName);

      
	}

}
