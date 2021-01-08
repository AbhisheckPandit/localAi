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


public class LocalPackageDetails {

	public String PackageDetails() {
		// TODO Auto-generated method stub
		//package type package_id - type of package (1=4hrs & 40kms, 2=8hrs & 80kms, 3=6hrs & 60kms, 4= 10hrs
				//& 100kms, 5=5hrs & 50kms, 6=3hrs & 30kms, 7=12hrs & 120kms)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DBConnectionManager.getConnection();
		
		try
		{
			String query="select package_id ,from_lat,to_lat,from_long,to_long from DayRideDeatails";
			con = getRemoteConnection();
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int packageId=rs.getInt("package_id");
				float from_lat=rs.getFloat("from_lat");
				float to_lat=rs.getFloat("to_lat");
				float from_long=rs.getFloat("from_lat");
				float to_long=rs.getFloat("to_lat");
				JsonObject packagedata=new JsonObject();
				JsonObject pckg =new JsonObject();
				JsonArray packageinfo=new JsonArray();
				ArrayList<Integer> listOflat = new ArrayList<>();
				ArrayList<Integer> listOflong=new ArrayList<>();
				while(packageId>=1 && packageId<=7)
				{
					
					pckg.addProperty("Package_id",packageId);
					pckg.addProproperty("From latitude",from_lat);
					pckg.addProperty("to longitude",to_long);
					pckg.addProperty("From longitude",from_long);
					pckg.addProperty("to_longitude",to_long);
					packageinfo.add(pckg);
					packagedata.add("AllPAckageinfo",packageinfo);
					
					
					
				}
			
		
		return packagedata.toString();
	}
		}catch(SQLException se){
	         se.printStackTrace();
  }finally {
	  con.close();
  }
	}
}
