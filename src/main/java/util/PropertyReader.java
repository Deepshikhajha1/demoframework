package util;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyReader {
	
	private final Properties configProp= new Properties();
	
	private PropertyReader() {
		InputStream in;
		try {
			in= this.getClass().getClassLoader().getResourceAsStream("config.properties");
			configProp.load(in);	
		}catch (Exception e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Unable to load property file", e);
		}
	}
	
	private static class PropertyHolder{
		private static final PropertyReader INSTANCE =new PropertyReader();
	}
	
	public static PropertyReader getInstance() {
		return PropertyHolder.INSTANCE;
	}
	
	public String getProperty(String key) {
		return configProp.getProperty(key);
		
	}
	
		
}
