package localAiInterview;
import javax.ws.rs.QueryParam;
public class LocalResourceBean {
	private @QueryParam("user_id ") int user_id;
	private @QueryParam("id") int id;
	private @QueryParam("vehicle_model_id") int vehicle_model_id;
	private @QueryParam("package_id") float package_id;
	private @QueryParam("travel_type_id") int travel_type_id;
	private @QueryParam("from_area_id") float from_area_id;
	private @QueryParam(" to_area_id  ") float to_area_id;
	private @QueryParam("from_city_id  ") float from_city_id  ;
	private @QueryParam(" to_city_id") float  to_city_id;
	private @QueryParam("from_date") String from_date;
	private @QueryParam("to_date") String to_date;
	private @QueryParam("online_booking") int online_booking;
	private @QueryParam("mobile_site_booking") int mobile_site_booking;
	private @QueryParam("booking_created") String booking_created;
	private @QueryParam("from_lat") float from_lat;
	private @QueryParam("from_long") float from_long;
	private @QueryParam("to_lat") float to_lat;
	private @QueryParam("to_long") float to_long;
	private @QueryParam("Car_Cancellation") int Car_Cancellation;
	
	
	public int getuserid() {
		return user_id;
	}

	public void setuserid(int user_id) {
		this.user_id= user_id;

	}
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id= id;

	}
	public int getvehicle_model_id() {
		return vehicle_model_id;
	}

	public void setvehicle_model_id(int vehicle_model_id) {
		this.vehicle_model_id= vehicle_model_id;

	}
	public int getpackage_id() {
		return package_id;
	}

	public void setpackage_id(int package_id) {
		this.package_id= package_id;

	}
	public int gettravel_type_id() {
		return travel_type_id;
	}

	public void settravel_type_id(int travel_type_id) {
		this.travel_type_id= travel_type_id;

	}
	public float getfrom_area_id() {
		return from_area_id;
	}

	public void setfrom_area_id(float from_area_id) {
		this.from_area_id= from_area_id;

	}
	public float getto_area_id() {
		return to_area_id;
	}

	public void setto_area_id(float to_area_id) {
		this.to_area_id= to_area_id;

	}
	public float getfrom_city_id() {
		return from_city_id;
	}

	public void setfrom_city_id(float from_city_id) {
		this.from_city_id= from_city_id;

	}
	public float getto_city_id() {
		return to_city_id;
	}

	public void setto_city_id(float to_city_id) {
		this.to_city_id= to_city_id;

	}
	public String getfrom_date() {
		return from_date;
	}

	public void setfrom_date(String from_date) {
		this.from_date= from_date;

	}
	public String getto_date() {
		return to_date;
	}

	public void setto_date(String to_date) {
		this.to_date= to_date;

	}
	public int getonline_booking() {
		return online_booking;
	}

	public void setonline_booking(int online_booking) {
		this.from_city_id= from_city_id;

	}
	public int getmobile_site_booking() {
		return getmobile_site_booking;
	}

	public void setmobile_site_booking(int mobile_site_booking) {
		this.mobile_site_booking= mobile_site_booking;

	}
	public float getfrom_lat() {
		return from_lat;
	}

	public void setfrom_lat(float from_lat) {
		this.from_lat= from_lat;

	}
	public float getfrom_long() {
		return from_long;
	}

	public void from_long(float from_long) {
		this.from_long= from_long;

	}
	
	public float getto_lat() {
		return to_lat;
	}

	public void setto_lat(float to_lat) {
		this.to_lat= to_lat;

	}
	public float getto_long() {
		return to_long;
	}

	public void getsetto_long(float to_long) {
		this.to_long= to_long;

	}
	public int getCar_Cancellation() {
		return Car_Cancellation;
	}

	public void setCar_Cancellation(int Car_Cancellation) {
		this.Car_Cancellation= Car_Cancellation;

	
}

	public String getBooking_created() {
		return booking_created;
		
	}
	public void setBooking_created(String booking_created) {
		this.booking_created= booking_created;

}
}
