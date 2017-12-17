import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mapper {
	private ArrayList<HashMap<String,Integer>> mapped = new ArrayList<HashMap<String,Integer>>();
	private File fileToRead;
	private String line;
	
	Mapper(File fileToRead) {
		this.fileToRead = fileToRead;
	}
	
	public void readFile() {		
		try {
			FileInputStream fstream = new FileInputStream(fileToRead);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			
			while((line = br.readLine()) != null) {
				mapped.add(map(line));
			}
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
	public HashMap<String,Integer> map(String line) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		line = line.replaceAll(","," ");
		line = line.replaceAll("\\."," ");
		line = line.replaceAll("\n", " ");
		
		String[] words = line.split(" ");
		
		for(int i = 0; i < words.length; i++) {
			map.put(words[i], 1);			
		}
		
		return map;
	}
	
	public ArrayList<HashMap<String,Integer>> getMap() {
		return this.mapped;
				
	}

	@Override
	public String toString() {
		return "Mapper [mapped=" + mapped + "]";
	}
}
