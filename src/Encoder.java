import java.util.*;
import java.io.*;

public class Encoder {
	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap
	private String output; //Final code
	
	/**
	 * Fills the Hashmap with all 255 single chars.
	 */
	public Encoder() {
		encodingTable = new HashMap<String, Integer>();
		for (int i = 0; i <= 255; i++) {
			encodingTable.put((char)i + "", i);
		}
	}
	
	public void Encode(String FileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FileName));
		int c = 256;
		while (br.ready()) {
			String next = (char)br.read() + "";
			while (encodingTable.containsKey(next)) {
				next+=br.read();
			}
			encodingTable.put (next, c);
			c++;
			output+= "" + encodingTable.get(next.substring(0, next.length()-1));
			next = next.substring(next.length()-1);
		}
	}
}