package localAiInterview;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.*;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import java.io.*;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("/webapi")
@Produces(MediaType.APPLICATION_JSON)
@Compress
public class LocalRestServices {
	Localinsertdata datastore=new Localinsertdata();
	LocalPeakTime datainfo=new LocalPeakTime();
	LocalPackageDetails packagedetails=new LocalPackageDetails();
	LocalCancellationDetails cancellationinfo=new LocalCancellationDetails();
//saving the datasets into the psql database
@POST
@Path("/savedetails")
public boolean savedetails(@BeanParam LocalResourceBean filterbean, String data )
{
	return datastore.INSERTDATA(filterbean.getid(),filterbean.getuserid(),filterbean.getfrom_area_id(),
			filterbean.getCar_Cancellation(),filterbean.getfrom_city_id(),filterbean.getvehicle_model_id(),
			filterbean.getpackage_id(),filterbean.gettravel_type_id(),filterbean.getto_area_id(),
			filterbean.getto_city_id(),filterbean.getfrom_date(),filterbean.getto_date(),
	        filterbean.getonline_booking() ,filterbean.getmobile_site_booking(),filterbean.getBooking_created(), filterbean.getfrom_lat() ,
	        filterbean.getfrom_long(),filterbean.getto_lat(),filterbean.getto_long());
}
@GET
@Path("/getPeaktimeRideDetails")
public String getPeaktimeRideDetails(@BeanParam LocalResourceBean filterbean)
{
	return datainfo.PeaktimeRides();
}

@GET
@Path("/PackageDetails")
public String getPackageDetails(@BeanParam LocalResourceBean filterbean) {
	return packagedetails.PackageDetails();
	
	
}
@GET
@Path("RideCancellationDetails")
public String getRideCancellationDetails(@BeanParam LocalResourceBean filterbean) {
	return cancellationinfo.CancellationData();
}
}

