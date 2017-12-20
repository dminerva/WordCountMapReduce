import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mapper {
	private ArrayList<KeyValuePair> mappedFile;
	private ArrayList<KeyValuePair> combineList;
	File fileToRead;
	private String line;
	
	public Mapper(File fileToRead) {
		mappedFile = new ArrayList<KeyValuePair>();
		combineList = new ArrayList<KeyValuePair>();
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
		line = line.replaceAll("," , " ");		
		line = line.replaceAll("\\'" , " ");
		line = line.replaceAll("\\." , " ");
		line = line.replaceAll("\n" , " ");
		line = line.toLowerCase();
		
		String[] words = line.split(" ");
		
		for(int i = 0; i < words.length; i++) {
			mappedFile.add(new KeyValuePair(words[i], 1));
		}
	}
	
	public ArrayList<KeyValuePair> getMap() {
		return mappedFile;
	}
	
	public void combine() {
		
	}
}
