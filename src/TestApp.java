import java.io.IOException;

public class TestApp {

	public static void main(String[] args) throws IOException {
		FileHandler fh = new FileHandler();
		fh.read("test.txt");
	}
}
