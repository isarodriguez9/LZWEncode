import java.util.*;
public class Node {
	private int frequency;
	private String word;
	public Node(int frequency, String word)
	{
		this.frequency = frequency;
		this.word = word;
	}
	public int getFreq()
	{
		return frequency;
	}
	public String getWord()
	{
		return word;
	}
	public void setFreq(int freq)
	{
		frequency = freq;
	}
	public void setWord(String wrd)
	{
		word=wrd;
	}
}
