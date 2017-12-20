import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Application {

	public static void main(String[] args) {
		Mapper m = new Mapper(new File("elephant.txt"));
		m.processFile();
		
		System.out.println("\n==================== Map ====================\n");
		System.out.println(m.getMap());
		
		Mapper m2 = new Mapper(new File("elephant2.txt"));
		m2.processFile();
		
		System.out.println("\n==================== Map2 ====================\n");
		System.out.println(m2.getMap());
		
		m.combine();
		
		System.out.println("\n==================== Combine ====================\n");
		System.out.println(m.getCombined());
		
		m2.combine();
		
		System.out.println("\n==================== Combine2 ====================\n");
		System.out.println(m2.getCombined());
		
		Reducer r = new Reducer();
		r.shuffle(m);
		r.shuffle(m2);
		r.sort();
		
		System.out.println("\n==================== Sort & Shuffle ====================\n");
		System.out.println(r.getShuffled());
	}
}
