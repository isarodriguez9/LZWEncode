import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tester {
	public static void main(String[] args) throws IOException {
		Encoder encoder = new Encoder();
		encoder.Encode("encoding1", "encoded");
		BufferedReader br = new BufferedReader(new FileReader("encoded"));
		while (br.ready()) {
			System.out.print(br.read());
		}
		br.close();
	}
}