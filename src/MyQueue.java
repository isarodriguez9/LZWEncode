import java.util.*;
public class MyQueue {
	LinkedList<String> queue = new LinkedList<String>();
	public MyQueue()
	{
		queue = new LinkedList<String>();
	}
	public void add(String word)
	{
		queue.addLast(word);
	}
	public void remove(String word)
	{
		queue.remove(word);
	}
}
