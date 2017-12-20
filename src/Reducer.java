import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Reducer {
	ArrayList<KeyValuePair> sortShuffle;
	HashMap<String, Integer> reducedMap;
	ArrayList<KeyValuePair> reducedSort;
	
	public Reducer() {
		sortShuffle = new ArrayList<KeyValuePair>();
		reducedMap = new HashMap<String, Integer>();
		reducedSort = new ArrayList<KeyValuePair>();
	}
	
	public void shuffle(Mapper mapper) {
		for(Map.Entry<String, Integer> entry : mapper.getCombined().entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			sortShuffle.add(new KeyValuePair(key, value));
		}
		
		Collections.sort(sortShuffle, Comparator.comparing(KeyValuePair::getKey));
	}
	
	public ArrayList<KeyValuePair> getShuffled() {
		return sortShuffle;
	}
	
	public void reduce() {
		for(int i = 0; i < sortShuffle.size(); i++) {
			String key = sortShuffle.get(i).getKey();
			Integer value = sortShuffle.get(i).getValue();
			
			if(!reducedMap.containsKey(key)) {
				reducedMap.put(key, value);
			} else {
				Integer oldValue = reducedMap.get(key);
				reducedMap.put(key, oldValue + value);
			}
		}
		
		for(Map.Entry<String, Integer> entry : reducedMap.entrySet() ) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			reducedSort.add(new KeyValuePair(key, value));
		}
		
		Collections.sort(reducedSort, Comparator.comparing(KeyValuePair::getKey));
	}
	
	public ArrayList<KeyValuePair> getReduced() {
		return reducedSort;
	}
}


