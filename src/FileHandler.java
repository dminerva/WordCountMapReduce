import java.io.*;
import java.util.*;

public class FileHandler {
		
	FileHandler() {
		
	}
	
	public String read(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String everything = null;
		
		try {			
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
		    br.close();
		}		
		
		return everything;
	}
}
