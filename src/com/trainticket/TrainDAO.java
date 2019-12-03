
package com.trainticket;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainDAO {
	
	String driver_name="oracle.jdbc.driver.OracleDriver";
	String DB_URL="jdbc:oracle:thin:@localhost:1523:system";
	String username="hr";
	String password="admin";
	Train trn;
	
	/*
	 * connects to trains db
	 * returns ticket info based on ticket number
	 * 
	 */
	public Train findTrain(int trainNo) {
		
		try {
            Class.forName(driver_name);
            java.sql.Connection con= DriverManager.getConnection(DB_URL,username,password);
            PreparedStatement stmt = con.prepareStatement("Select * from trains where train_no= ?");
            stmt.setInt(1, trainNo);
            ResultSet rs = stmt.executeQuery(); 
            while(rs.next())
            	trn = new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
          
            if(trn!=null) {
            	return trn;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
	}

}

