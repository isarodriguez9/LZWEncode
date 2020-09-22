import java.util.*;
import java.io.*;

public class Decoder {

	private HashMap<Integer, String> encodingTable; //Stores all encodings in a HashMap (could be a normal array but I'm lazy)

	public Decoder () { //copy-pasted setup from Encoder but reversed to int,string
		encodingTable = new HashMap<Integer,String>();
		for (int i = 0; i <= 255; i++) {
			encodingTable.put(i, (char)i + "");
		}
		System.out.println(encodingTable.values());
	}

	public void decode(String fileName) {
		try {

			BufferedReader br = new BufferedReader(new FileReader(fileName)); // CHANGE FOR FILEPATH
			File nFile = new File(fileName.substring(0,fileName.length()-3) + "txt"); //Choose filename.txt, creates it if it doesnt exist
			if (!nFile.exists()) {
				nFile.createNewFile();
			}
			PrintWriter bw = new PrintWriter(nFile);

			int nextEncoding = 256;//keeps track of the next set of chars' code number in the hashmap

			String prevValue = "";
			Integer code = 0;
			
			/*char read = (char)br.read();//next set of characters
			String next = read + ""; //stores immediate read output*/

			while (br.ready()) {
				/*while ((read = (char)br.read()) != (char)' ') { //Checks if br.read is a space, if not adds it to the total integer.
					System.out.println(next + " || " + read);
					next += "" + read;
				}
				System.out.println(next);*/

				
				code = br.read();
				System.out.println("code: " + code);


				if (encodingTable.containsKey(code)) {
					System.out.println("WRITTEN: " + encodingTable.get(code));
					write(encodingTable.get(code), bw);

				} else {
					encodingTable.put(nextEncoding, prevValue + prevValue.substring(0,1)); //Adds edge case to HashMap (there is a way to make this not necessary and to only add to encoding table in one step always but i dont wanna rn)

					System.out.println("PUTTED1: " + encodingTable.get(nextEncoding));
					System.out.println(nextEncoding+", "+encodingTable.get(code));
					write(encodingTable.get(code), bw);
					System.out.println("WRITTEN: " + encodingTable.get(code));

					nextEncoding++;
					System.out.println ("Special Next Encoding: " + nextEncoding);
				}

				String check = prevValue + encodingTable.get(code).substring(0,1); // stores previous iteration + first letter of new iteration

				System.out.println("new: " + check + " latest: " + encodingTable.get(nextEncoding-1));
				if (!prevValue.equals("") && (!encodingTable.get(nextEncoding-1).equals(check))) {             // if it isnt already in the table...
					encodingTable.put(nextEncoding, check); //Adds it to HashMap
					System.out.println("PUTTED2: " + encodingTable.get(nextEncoding));
					nextEncoding++;
					System.out.println ("Next Encoding: " + nextEncoding);
				}
				prevValue = encodingTable.get(code);
			}
			br.close();
			bw.close();
		} catch (Exception exe) { //catches any exceptions
			exe.printStackTrace();
		}
	}

	public void write(String value, PrintWriter writer){
		try {
			System.out.println("ACTUAL WRITTEN: " + value);
			writer.print(value);

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
