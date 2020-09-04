import java.util.*;
import java.io.*;

public class Encoder {
	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap
	
	//Fills the Hashmap with all 255 single chars.
	public Encoder() {
		encodingTable = new HashMap<String, Integer>();
		for (int i = 0; i <= 255; i++) {
			encodingTable.put((char)i + "", i);
		}
	}
	
	public void Encode(String fileName, String outputFileName){
		try { 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			File file = new File(outputFileName); //Create New File (if it doesn't already exist)
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			
			int nextEncoding = 256;//keeps track of the next set of chars' code number in the hashmap
			String next = (char)br.read() + "";//next set of characters
			while (br.ready()) {
				while (encodingTable.containsKey(next)) { //Checks if next is in table, if it is, add next letter until it a new, previously unseen string is formed
					next+=(char)br.read();
				}
				encodingTable.put(next, nextEncoding); //Adds new code to Hashmap
				nextEncoding++;//increments nextEncoding so the next code always gets the next number
				pw.print(" " + encodingTable.get(next.substring(0, next.length()-1)));
				next = next.substring(next.length()-1); //resets next to its last character to prepare for the next code
			}
			br.close();
			pw.close();
		} catch (Exception exe) { //catches any exceptions
			exe.printStackTrace();
		}
	}
}