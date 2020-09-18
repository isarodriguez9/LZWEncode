import java.util.*;
import java.io.*;

public class Decoder {

	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap

	public Decoder () { //copy-pasted setup from Encoder
		encodingTable = new HashMap<String, Integer>();
		for (int i = 0; i <= 255; i++) {
			encodingTable.put((char)i + "", i);
		}
	}

	public void Decode() {
		public void Encode(String fileName, String outputFileName){
		try { 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			File file = new File(filename.substring(0,length()-3) + "txt"); //Choose filename.txt, creates it if it doesnt exist
			if (!file.exists()) {
				file.createNewFile();
			}
			
			int nextEncoding = 256;//keeps track of the next set of chars' code number in the hashmap

			String next = (char)br.read() + "";//next set of characters
			String read = next; //stores immediate read output
			while (br.ready()) {
				while ((read = br.read) != (char)" ") { //Checks if br.read is a space, if not adds it to the total integer.
					next+=(char)br.read();
				}

				/*
				encodingTable.put(next, nextEncoding); //Adds new code to Hashmap
				nextEncoding++;//increments nextEncoding so the next code always gets the next number
				pw.print(encodingTable.get(next.substring(0, next.length()-1)) + " ");
				next = next.substring(next.length()-1); //resets next to its last character to prepare for the next code*/
			}
			br.close();
			pw.close();
		} catch (Exception exe) { //catches any exceptions
			exe.printStackTrace();
		}
	}
	}

	public void Write(){

	}
}
