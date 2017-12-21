import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Mapper {
	private ArrayList<KeyValuePair> mappedFile;
	private HashMap<String, Integer> combinedFile;
	File fileToRead;
	private String line;
	
	public Mapper(File fileToRead) {
		mappedFile = new ArrayList<KeyValuePair>();
		combinedFile = new HashMap<String, Integer>();
		this.fileToRead = fileToRead;
	}
	
	public void processFile() {
		try {
			FileReader fReader = new FileReader(fileToRead);
            BufferedReader bReader = new BufferedReader(fReader);
            
            while((line = bReader.readLine()) != null) {
            	map(line);
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void map(String line) {
		/*line = line.replace("," , " ");	
		line = line.replace(";" , " ");
		line = line.replace(":" , " ");
		line = line.replace("\\'" , " ");
		line = line.replace("\\." , " ");
		line = line.replace("\\?" , " ");
		line = line.replace("\\!" , " ");
		line = line.replace("\n" , " ");
		line = line.toLowerCase();
		
		String[] words = line.split(" ");*/
		
		String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		
		for(int i = 0; i < words.length; i++) {
			mappedFile.add(new KeyValuePair(words[i], 1));
		}
	}
	
	public ArrayList<KeyValuePair> getMap() {
		return mappedFile;
	}
	
	public void combine() {		
		for(int i = 0; i < mappedFile.size(); i++) {
			if(!combinedFile.containsKey(mappedFile.get(i).getKey())) {
				combinedFile.put(mappedFile.get(i).getKey(), mappedFile.get(i).getValue());
			} else {
				int oldValue = mappedFile.get(i).getValue();
				
				combinedFile.put(mappedFile.get(i).getKey(), oldValue + 1);
			}
		}
	}
	
	public HashMap<String, Integer> getCombined() {
		return combinedFile;
	}
}