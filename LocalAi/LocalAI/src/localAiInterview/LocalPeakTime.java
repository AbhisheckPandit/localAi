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

public class LocalPeakTime {

	public String PeaktimeRides() {
		// TODO Auto-generated method stub
		//travel_type_id - type of travel (1=long distance, 2= point to point, 3= hourly rental)
		//package type package_id - type of package (1=4hrs & 40kms, 2=8hrs & 80kms, 3=6hrs & 60kms, 4= 10hrs
		//& 100kms, 5=5hrs & 50kms, 6=3hrs & 30kms, 7=12hrs & 120kms)
		//booking time format timestamp:2015-11-13       this is my input format for time :13:50:21.007
		// Peak time:6 to 10 AM and 15 to 20
		
		
		//segragating on the basis of peak times rides
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnectionManager.getConnection();
		JsonObject peakrideDetails=new JsonObject();
		try
		{
			String query="Select booking_created,userid ,travel_type_id,from_area,to_area,from_lat,to_lat,from_long,to_long from DayRideDetails";
			con = getRemoteConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int userID=rs.getInt("userid");
				int traveltype=rs.getInt("travel_type_id");
				String bookingTimestamp=rs.getString("booking_created");
				String BookingTime[]=bookingTimestamp.split(":");
				float origin=rs.getFloat("from_area");
				float destination=rs.getFloat("to_area");
				float from_lat=rs.getFloat("from_lat");
				float from_long=rs.getFloat("to_lat");
				float to_lat=rs.getFloat("from_long");
				float to_long=rs.getFloat("to_long");
				//Peak hours in a day is time
				//travel_type_id - type of travel (1=long distance, 2= point to point, 3= hourly rental)
				JsonObject rideObj= new JsonObject();
				JsonArray PeakrideList1=new JsonArray();
				JsonArray PeakrideList2=new JsonArray();
				JsonArray PeakrideList3=new JsonArray();
				
				
				int time=Integer.parseInt(BookingTime[1]);
				if((time>=6 && time<=10)||(time>=15 && time<=20))
				{
					if(traveltype==1)
					{
					rideObj.addProperty("UserId",userID);
					rideObj.addProperty("fromlatitude",from_lat);
					rideObj.addProperty("tolatitude",to_lat);
					rideObj.addProperty("fromlongitude",from_long);
					rideObj.addProperty("toLatitude",to_long);
					PeakrideList1.add(rideObj);// long distance rides details
					}
					else if(traveltype==2)
					{
						rideObj.addProperty("UserId",userID);
						rideObj.addProperty("from",origin);
						rideObj.addProperty("to",destination);
						rideObj.addProperty("tolatitude",to_lat);
						rideObj.addProperty("fromlongitude",from_long);
						rideObj.addProperty("toLatitude",to_long);
						PeakrideList2.add(rideObj);//point to point ride details
					}
					else {
						rideObj.addProperty("userID",userID);
						rideObj.addProperty("tolatitude",to_lat);
						rideObj.addProperty("fromlongitude",from_long);
						rideObj.addProperty("toLatitude",to_long);
						PeakrideList3.add(rideObj);//hourly rental rides details
					}
					
					//ALL ride details during peak hours
					peakrideDetails.add("long distance",PeakrideList1);
					peakrideDetails.add("Point to point",PeakrideList2);
					peakrideDetails.add("hourly rental",PeakrideList3);
					
				}
			}
		}catch(SQLException se){
	         se.printStackTrace();
  }
		}
		finally{
			con.close();
		}
		
		
		
		return peakrideDetails.toString();
	}
	
}
