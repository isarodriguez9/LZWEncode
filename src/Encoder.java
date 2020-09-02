import java.util.*;
import java.io.*;

public class Encoder {
	public Encoder() {}
	
	public void Encode(String FileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(FileName));
		ArrayList<String> encodingTable = new ArrayList<String>();
		for (int i = 0; i < 255; i++) {
			encodingTable.add((char)i + "");
		}
	}
}