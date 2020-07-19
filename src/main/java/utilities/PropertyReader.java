package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * This class is used for extracting the Xpath from properties file
 * @author anmol.chhabra
 *
 */
public class PropertyReader {  
	/** 
	 * Reads properties file from 'resources' and returns value from given input key
	 * @param input
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static String fileload(String input) throws IOException, URISyntaxException {
		File f = new File(PropertyReader.class.getClassLoader().getResource("xpath.properties").toURI()); 
		FileInputStream fi = new FileInputStream(f); 
		Properties pr = new Properties();
		pr.load(fi);
		String output = pr.getProperty(input);  
		return output;
	}


}
