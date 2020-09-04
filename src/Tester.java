import java.io.*;
import java.util.*;

public class Tester {
	public static void main(String[] args) throws IOException {
		Encoder encoder = new Encoder();
		encoder.Encode("encoding1", "encoded");
		BufferedReader br = new BufferedReader(new FileReader("encoded"));
		while (br.ready()) {
			System.out.print(br.read());
		}
	}
}