import java.util.*;
import java.io.*;

public class Encoder {
	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap
	
	/**
	 * Fills the Hashmap with all 255 single chars.
	 */
	public Encoder() {
		encodingTable = new HashMap<String, Integer>();
		for (int i = 0; i <= 255; i++) {
			encodingTable.put((char)i + "", i);
		}
	}
	
	public void Encode(String fileName, String outputFileName){
		try { 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			File file = new File(outputFileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter (file);
			BufferedWriter writer = new BufferedWriter (fw);
			
			int c = 256;
			String next = (char)br.read() + "";
			while (br.ready()) {
				while (encodingTable.containsKey(next)) {
					next+=br.read();
				}
				encodingTable.put(next, c);
				c++;
				writer.write("" + encodingTable.get(next.substring(0, next.length()-1)));
				next = next.substring(next.length()-1);
			}
		} catch (Exception exe) {
			exe.printStackTrace();
		}
	}
}