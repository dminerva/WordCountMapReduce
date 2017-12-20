import java.io.File;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		Mapper m = new Mapper(new File("elephant.txt"));
		m.processFile();
		
		System.out.println("\n========== Map ==========\n");
		System.out.println(m.getMap());
		
		m.combine();
		
		System.out.println("\n========== Combine ==========\n");
		System.out.println(m.getCombined());
	}
}
