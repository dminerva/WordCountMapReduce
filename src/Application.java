import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Application {

	public static void main(String[] args) {
		Mapper m = new Mapper(new File("countofmontecristo1.txt"));
		m.processFile();
		
		System.out.println("\n==================== Map1 ====================\n");
		System.out.println(m.getMap());
		
		Mapper m2 = new Mapper(new File("countofmontecristo2.txt"));
		m2.processFile();
		
		System.out.println("\n==================== Map2 ====================\n");
		System.out.println(m2.getMap());
		
		Mapper m3 = new Mapper(new File("countofmontecristo3.txt"));
		m3.processFile();
		
		System.out.println("\n==================== Map3 ====================\n");
		System.out.println(m3.getMap());
		
		Mapper m4 = new Mapper(new File("countofmontecristo4.txt"));
		m4.processFile();
		
		System.out.println("\n==================== Map4 ====================\n");
		System.out.println(m4.getMap());
		
		m.combine();
		
		System.out.println("\n==================== Combine1 ====================\n");
		System.out.println(m.getCombined());
		
		m2.combine();
		
		System.out.println("\n==================== Combine2 ====================\n");
		System.out.println(m2.getCombined());
		
		m3.combine();
		
		System.out.println("\n==================== Combine3 ====================\n");
		System.out.println(m3.getCombined());
		
		m4.combine();
		
		System.out.println("\n==================== Combine4 ====================\n");
		System.out.println(m4.getCombined());
		
		Reducer r = new Reducer();
		r.shuffle(m);
		r.shuffle(m2);
		r.shuffle(m3);
		r.shuffle(m4);
		
		System.out.println("\n==================== Shuffle ====================\n");
		System.out.println(r.getShuffled());
		
		r.reduce();
		
		System.out.println("\n==================== Reduce ====================\n");
		System.out.println(r.getReduced());
	}
}
