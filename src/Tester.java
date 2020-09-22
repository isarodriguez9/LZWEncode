import java.io.*;
import java.util.*;

public class Tester {
	public static void main(String[] args) throws IOException {
		//Encoder encoder = new Encoder();
		String path = "/Users/chasethumann/Documents/GitHub/LZWEncode/encoding1.lzw";
		//encoder.Encode(path);
		Decoder decoder = new Decoder();
		decoder.decode(path);

	}
}
