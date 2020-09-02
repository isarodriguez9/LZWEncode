import java.util.*;
import java.io.*;

public class Encoder {
	public Encoder() {}
	
	public void Encode(String FileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(FileName));
		while (!br.ready()) {
			String next = br.read();
		}
		
		//br.read() = next character
	}
}