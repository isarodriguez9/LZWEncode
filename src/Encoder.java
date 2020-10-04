import java.util.*;
import java.io.*;

public class Encoder {
	final static int DICTINT= 128;
	final static int MAXHASHSIZE = 5000;
	private HashMap<Node, Integer> encodingTable; //Stores all encodings in a HashMap
	private MyQueue queue = new MyQueue(); 
	
	//Fills the Hashmap with all 127 single chars.
	public Encoder() {
		encodingTable = new HashMap<Node, Integer>();
		for (int i = 0; i < DICTINT; i++) {
			Node toBeAdded = new Node((char)i+"",false);
			encodingTable.put(toBeAdded,i);
		}
	}

	public void Encode(String fileName) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			File nFile = new File(fileName.substring(0,fileName.length()-3) + "lzw"); //Create New File (if it doesn't already exist)
			if (!nFile.exists()) {
				nFile.createNewFile();
			}
			PrintWriter pw = new PrintWriter(nFile);

			int nextEncoding = DICTINT;//keeps track of the next set of chars' code number in the hashmap
			String next = (char)br.read() + "";//next set of characters
			while (br.ready()) {
				while (encodingTable.containsKey(next) && br.ready()) { //Checks if next is in table, if it is, add next letter until it a new, previously unseen string is formed
					next+=(char)br.read();
				}

				if (br.ready())
				{
					Node currentNode = new Node(next,nextEncoding);
					encodingTable.put(currentNode,0); //Adds new code to Hashmap
					System.out.println("Next: " + next + " substring: " + next.substring(0, next.length()-1));
					pw.print((char)encodingTable.get(next.substring(0, next.length()-1)).intValue());
					Node addToQueue = new Node(next.substring(0, next.length()-1), nextEncoding);
					if(encodingTable.containsKey(addToQueue))
					{
						queue.remove(addToQueue);
					}
					queue.add(addToQueue);
					encodingTable.replace(addToQueue, 0, 1);
					System.out.println((int)'’');
					nextEncoding++;
				} else {
					Node addToQueue = new Node(next.substring(0, next.length()-1), nextEncoding);
					if (encodingTable.containsKey(addToQueue)) {
						pw.print((char)encodingTable.get(next).intValue());
						queue.remove(addToQueue);
						queue.add(addToQueue);
						encodingTable.replace(addToQueue, 0, 1);
					} else {
						encodingTable.put(new Node(next, nextEncoding), 0); //Adds new code to Hashmap
						pw.print((char)encodingTable.get(next.substring(next.length()-1)).intValue());
						nextEncoding++;
					}
				}
				if (encodingTable.size()==MAXHASHSIZE)
				{
					Node nodeToRemove = queue.removeFirst();
					encodingTable.remove(nodeToRemove);
				}
				//increments nextEncoding so the next code always gets the next number
				next = next.substring(next.length()-1); //resets next to its last character to prepare for the next code
			}
			br.close();
			pw.close();
		} catch (Exception exe) { //catches any exceptions
			exe.printStackTrace();
		}
	}
}
