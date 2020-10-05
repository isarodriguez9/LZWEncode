import java.util.*;
import java.io.*;
public class Decoder {
	final static int MAXHASHSIZE = 50000;
	final int DICTINT = 128;
	private HashMap<Integer, Node> encodingTable; //Stores all encodings in a HashMap (could be a normal array but I'm lazy)
	private MyQueue queue = new MyQueue();

	public Decoder () { //copy-pasted setup from Encoder
		encodingTable = new HashMap<Integer,Node>();
		for (int i = 0; i < DICTINT; i++) {
			encodingTable.put(i, new Node((char)i + "",false));
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

			int nextEncoding = DICTINT; //keeps track of the next set of chars' code number in the hashmap
			String prevValue = "";
			Integer code = 0;

			while (br.ready()) {
				code = br.read();
				if (encodingTable.containsKey(code)) {
					write(encodingTable.get(code).getStr(), bw);
					Node toBeAdded = new Node(encodingTable.get(code).getStr(), true); //creates a node to be added the the queue 
					if(encodingTable.get(code).inQueue()) //remove the node from the queue if it is already in it before re-adding to the top 
					{
						queue.remove(toBeAdded);
					}
					queue.add(toBeAdded);

				} else {
					encodingTable.put(nextEncoding, new Node(prevValue + prevValue.substring(0,1), true)); //Adds edge case to HashMap (there is a way to make this not necessary and to only add to encoding table in one step always but i dont wanna rn)
					write(encodingTable.get(code).getStr(), bw);
					Node toBeAdded = new Node(encodingTable.get(code).getStr(), true);
					if(encodingTable.get(code).inQueue())
					{
						queue.remove(toBeAdded);
					}
					queue.add(toBeAdded);
					nextEncoding++;
				}
				String check = prevValue + encodingTable.get(code).getStr().substring(0,1); // stores previous iteration + first letter of new iteration
				if (!prevValue.equals("") && (!encodingTable.get(nextEncoding-1).equals(check))) {             // if it isnt already in the table...
					encodingTable.put(nextEncoding, new Node(check, false)); //Adds it to HashMap
					nextEncoding++;
				}
				prevValue = encodingTable.get(code).getStr();
			}
			br.close();
			bw.close();
		} catch (Exception exe) { //catches any exceptions
			exe.printStackTrace();
		}
	}
//essentially printwriter methods
	public void write(String value, PrintWriter writer){
		try {
			writer.print(value);

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
