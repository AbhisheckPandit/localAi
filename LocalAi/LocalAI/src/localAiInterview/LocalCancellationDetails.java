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


public class LocalCancellationDetails {

	public String CancellationData() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnectionManager.getConnection();
		try
		{
			
		
		//To get rider details who has cancelled the ride.
		String query="Select id ,from_area,to_area,from_lat,to_lat,from_long,to_long,Car_cancellation from DarRideDetails";
		con = getRemoteConnection();
		pstmt = con.prepareStatement(query);
		rs = pstmt.executeQuery();
		JsonArray CarArr=new JsonArray();
		while(rs.next()) {
			int id=rs.getInt("id");
			float fromLat=rs.getFloat("from_lat");
			float fromLong=rs.getFloat("from_long");
			float fromArea=rs.getFloat("from_area");
			float toArea=rs.getFloat("to_area");
			float tolat=rs.getFloat("to_long");
			float tolong=rs.getFloat("to_long");
			int cancellationid=rs.getInt("Car_Cancellation");
			
			if(cancellationid==1)
			{
				JsonObject carObj=new JsonObject();
				
				carObj.addProperty("Cancelled_id",id);
				carObj.addProperty("from_area",fromArea);
				carObj.addProperty("To_area",toArea);
				carObj.addPropert("From_lat",fromLat);
				carObj.addProperty("To_lat",tolat);
				carObj.addProperty("from_long",fromLong);
				carObj.addProperty("to_long",tolong);
				CarArr.add("Cancelled RideInfo",carObj);
				
				
				
				
		}
			
		}
		return CarArr.toString();
		}catch(SQLException se){
	         se.printStackTrace();
			
			
		}
		
		finally{
			con.close();
		}
	
	}

}
