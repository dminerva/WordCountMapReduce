import java.io.File;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		
		Mapper m = new Mapper(new File("test.txt"));
		m.readFile();
		System.out.println(m.toString());
		
		
	}

}
