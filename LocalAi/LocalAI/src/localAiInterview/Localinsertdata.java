package localAiInterview;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;
import com.google.gson.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Localinsertdata {

	public boolean INSERTDATA(int id, int userid, float from_area_id, int Car_Cancellation,
			float from_city_id, int vehicle_model_id, int package_id, int travel_type_id,
			float to_area_id, float to_city_id, String from_date, String to_date, int online_booking,
			int mobile_site_booking,String Booking_created, float from_lat, float from_long, float to_lat, float to_long) {
		// TODO Auto-generated method stub
		/**id - booking ID
		● user_id - the ID of the customer (based on mobile number)
		● vehicle_model_id - vehicle model type.
		● package_id - type of package (1=4hrs & 40kms, 2=8hrs & 80kms, 3=6hrs & 60kms, 4= 10hrs
		& 100kms, 5=5hrs & 50kms, 6=3hrs & 30kms, 7=12hrs & 120kms)
		● travel_type_id - type of travel (1=long distance, 2= point to point, 3= hourly rental).
		● from_area_id - unique identifier of area. Applicable only for point-to-point travel and
		packages
		● to_area_id - unique identifier of area. Applicable only for point-to-point travel
		● from_city_id - unique identifier of city
		● to_city_id - unique identifier of city (only for intercity)
		● from_date - time stamp of requested trip start
		● to_date - time stamp of trip end
		● online_booking - if booking was done on desktop website
		● mobile_site_booking - if booking was done on mobile website
		● booking_created - time stamp of booking
		● from_lat - latitude of from area
		● from_long - longitude of from area
		to_lat - latitude of to area
		● to_long - longitude of to area
		● Car_Cancellation - whether the booking was cancelled (1) or not (0)
*/
		
		//the jar related to drivers need to be added for jdbc does not comes with ide
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnectionManager.getConnection();
		try
		{ 
		String sql = "CREATE TABLE DayRideDetails"+"(id INTEGER not null,userid not null,vehicle_model_id not null,travel_type_id not null,from_area_id not null,"
		 		+ "to_area_id not null,from_city_id not null,to_city_id not null,from_date varchar(255),to_date varchar(255),online_booking not null,mobile_site_booking"
		 		+ "not null,booking_created varchar(255),from_lat not null,from_long not null,,to_lat not null,to_long not null,Car_Cancellation not null)";
	      
		
		
		String query = "insert into DayRideDetails"  + " (id,userid,vehicle_model_id,package_id,travel_type_id,from_area_id,to_area_id,from_city_id,to_city_id"
				+ "from_date,to_date,online_booking,mobile_site_booking,booking_created,from_lat,from_long,to_lat,to_long,Car_Cancellation) "
				+ "values ('" + id + "','" + userid+"','"+ vehicle_model_id+"','"+ package_id+"','"+ travel_type_id+"','"+ from_area_id+"','"
				+ to_area_id+"','"+ from_city_id+"','"+to_city_id+"','"
				+ from_date+"','"+ to_date+"','"+"','"+ mobile_site_booking+"','"+ Booking_created+"','"+ from_lat+"','"+ from_long+"','"
				+ "'," + to_lat+"','"+ to_long+"','"+Car_Cancellation + ")";
		
		//segragating rides based on their travel type
		
		
		pstmt.executeUpdate(sql);
		pstmt = con.prepareStatement(query);
		pstmt.executeUpdate();
		rs = pstmt.getGeneratedKeys();
		
	
	//finally block used to close resources
	
		}finally {
	      try{
	         if(pstmt!=null)
	            pstmt.close();
	     
	         if(con!=null)
	            con.close();
	      
	   }catch(SQLException se){
		         se.printStackTrace();
	   }
	}
	      return true;
	}

	
	
}


	
		
		
		
		
		
		
		
		
		
