import java.util.*;
import java.io.*;

public class Decoder {

	private HashMap<String, Integer> encodingTable; //Stores all encodings in a HashMap (could be a normal array but I'm lazy)

	public Decoder () { //copy-pasted setup from Encoder but reversed to int,string
		encodingTable = new HashMap<Integer,String>();
		for (int i = 0; i <= 255; i++) {
			encodingTable.put(i, (char)i + "");
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

			Integer prevValue = "";
			Integer code = 0;
			String next = (char)br.read() + "";//next set of characters
			String read = next; //stores immediate read output

			while (br.ready()) {
				while ((read = br.read) != (char)" ") { //Checks if br.read is a space, if not adds it to the total integer.
					next+=(char)br.read();
				}

				code = Integer.ValueOf(next);

				if (encodingTable.containsKey(code)) {
					write(encodingTable.get(code));
				} else {
					encodingTable.put(nextEncoding, prevValue + prevValue.substring(0,1)); //Adds edge case to HashMap (there is a way to make this not necessary and to only add to encoding table in one step always but i dont wanna rn)
					write(encodingTable.get(code));
					nextEncoding++; 
				}
				
				String check = prevValue + encodingTable.get(code).substring(0,1); // stores previous iteration + first letter of new iteration 
				if (encodingTable.get(nextEncoding-1).equals(check)) {             // if it isnt already in the table...
					encodingTable.put(nextEncoding, check); //Adds it to HashMap
					nextEncoding++;
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

	public void Write(String value){

	}
}
