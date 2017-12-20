import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Reducer {
	ArrayList<KeyValuePair> shuffle;
	HashMap<String, Integer> reducedList;
	
	public Reducer() {
		shuffle = new ArrayList<KeyValuePair>();
		reducedList = new HashMap<String, Integer>();
	}
	
	public void shuffle(Mapper mapper) {
		for(Map.Entry<String, Integer> entry : mapper.getCombined().entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			shuffle.add(new KeyValuePair(key, value));
		}
	}
	
	public void sort() {
		Collections.sort(shuffle, Comparator.comparing(KeyValuePair::getKey));
	}
	
	public ArrayList<KeyValuePair> getShuffled() {
		return shuffle;
	}
	
	public void reduce() {
		
	}
}


