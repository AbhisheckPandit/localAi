package localAiInterview;

//basically we have to configure our project for driver related issue which is actually customised in office projects so such errors are coming
//This will depend upon the configuration of the individual controller/tree structure.
public class DBConnectionManager
{
	 public static Connection getConnection() throws SQLException
	  {
	    Connection conn;
	    //Log.debugLog("DBConnectionManager", "getConnection", "", "", "method called. query timeout - " +  querytimeout);
	    if(bds != null)
	    {
	      //Log.debugLogAlways("DBConnectionManager", "getConnection", "", "", "max active: " + bds.getMaxActive() + ", current active: " + bds.getNumActive());
	      conn = bds.getConnection();
	    }
	    else
	    {
	      parseConfigureDataSource();
	      configureDataSource();
	      conn =bds.getConnection();
	    }
	    PreparedStatement ps = conn.prepareStatement("set session statement_timeout to " + querytimeout);
	    ps.executeUpdate();   
	    return conn;

	  }
}
