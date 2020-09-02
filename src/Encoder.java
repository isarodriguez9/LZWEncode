import java.util.*;
import java.io.*;

public class Encoder {
	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap
	
	/**
	 * Fills the Hashmap with all 255 single chars.
	 */
	public Encoder() {
		encodingTable = new HashMap<String, Integer>();
		for (int i = 0; i < 255; i++) {
			encodingTable.put((char)i + "", i);
		}
	}
	
	public void Encode(String FileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(FileName));
		while (!br.ready()) {
			String next = br.read();

		}
		
		//br.read() = next character
	}
}