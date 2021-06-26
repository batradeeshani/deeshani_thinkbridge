package driverSettings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public abstract class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
	setProperties(loadProperties());
	applyProperties(getProperties());
    }

    protected abstract void applyProperties(Properties properties);

    protected void setProperties(Properties properties) {
	this.properties = properties;
    }

    public Properties getProperties() {
	return this.properties;
    }
    
    protected String getPropertiesFilePath() {
	String path="resources//config.properties";
	return path;
    }

    protected Properties loadProperties() {
	return loadDefaultAndCustomProps(getPropertiesFilePath());
    }
    
    public Properties loadDefaultAndCustomProps(String propertyFilePath){
	BufferedReader reader;
	try {
	    reader = new BufferedReader(new FileReader(propertyFilePath));
	    properties = new Properties();
	    try {
		properties.load(reader);
		reader.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	}
	properties.putAll(System.getProperties());
	return properties;		
    }

}
