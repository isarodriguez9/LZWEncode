import java.util.*;
import java.io.*;

public class Encoder {
	private ArrayList<String> encodingTable;
	
	public Encoder() {
		encodingTable = new ArrayList<String>();
		for (int i = 0; i < 255; i++) {
			encodingTable.add((char)i + "");
		}
	}
	
	public void Encode(String FileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(FileName));
	}
}