import java.io.*;
import java.util.*;

public class Tester {
	public static void main(String[] args) throws IOException {
		//Encoder encoder = new Encoder();
		String path = "C:\\Users\\kellan\\Documents\\GitHub\\LZWEncode";
		//encoder.Encode("encoding1",path);
		Decoder decoder = new Decoder();
		decoder.decode("encoding1.lzw", path);

	}
}
