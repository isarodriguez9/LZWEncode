import java.io.*;
import java.util.*;

public class Tester {
	public static void main(String[] args) throws IOException {
		/*String path = "/Users/chasethumann/Documents/GitHub/LZWEncode/encoding1.txt";
		Encoder encoder = new Encoder();
		encoder.Encode(path);*/
		String path = "/Users/chasethumann/Documents/GitHub/LZWEncode/encoding1.lzw";
		Decoder decoder = new Decoder();
		decoder.decode(path);

	}
}
