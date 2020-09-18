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

	}
}
