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
				Node containsKeyFalse = new Node(next, false); //creates a new node with the next set of chars and false if the sequence is not in the queue
				Node containsKeyTrue = new Node(next, true); //creates a new node with the next set of chars and true in case the sequence is already in the queue
				while(encodingTable.containsKey(containsKeyFalse)|| encodingTable.containsKey(containsKeyTrue)) { //Checks if next is in table, if it is, add next letter until it a new, previously unseen string is formed
					next+=(char)br.read();
					containsKeyFalse.setStr(next);
					containsKeyTrue.setStr(next);
				}

				if (encodingTable.size()<MAXHASHSIZE)
				{
					Node currentNode = new Node(next,false);
					Node toBeReplaced = new Node(next.substring(0, next.length()-1),false); //creates a node to store the outprint and what will be added to the queue
					encodingTable.put(currentNode,nextEncoding); //Adds new code to Hashmap
					System.out.println("Next: " + next + " substring: " + next.substring(0, next.length()-1));
					pw.print((char)encodingTable.get(toBeReplaced).intValue());
					Node addToQueue = new Node(next.substring(0, next.length()-1), true);

					if(encodingTable.containsKey(addToQueue)) //if the node is already in the queue, remove it before re-adding to the top 
					{
						queue.remove(addToQueue);
					}
					queue.add(addToQueue);
					//replaces the old node with a new node with the same string, but boolean true since it is now in the queue
					Integer replacedValue = encodingTable.get(toBeReplaced);
					encodingTable.put(addToQueue,replacedValue); 
					encodingTable.remove(toBeReplaced);
					System.out.println((int)'’');
					nextEncoding++;
				}

				else //if the hashmap has reached its max size, remove the top node from the queue and remove from the hashmap
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
