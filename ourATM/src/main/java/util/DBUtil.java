package util;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static BasicDataSource ds;
	
	static{
		try {
			Properties prop=new Properties();
			prop.load(DBUtil.class.getClassLoader()
					.getResourceAsStream("config.properties"));
			String driverName=prop.getProperty("drivername");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			int maxActive=Integer.parseInt(prop.getProperty("maxactive"));
			int maxWait=Integer.parseInt(prop.getProperty("maxwait"));
			
			ds=new BasicDataSource();
			//Class.forName()
			ds.setDriverClassName(driverName);
			//DriverManager.getConnection()
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMaxActive(maxActive);
			ds.setMaxWait(maxWait);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
		try {
			return ds.getConnection();
		} catch (Exception e) {
			throw e;
		}
	}
}
