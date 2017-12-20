import java.io.File;

public class Application {

	public static void main(String[] args) {
		Mapper m = new Mapper(new File("elephant.txt"));
		m.processFile();
		
		System.out.println("========== Map output ==========\n");
		System.out.println(m.getMap());
		System.out.println("\n================================");
		
		
	}
}
