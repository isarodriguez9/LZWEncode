import java.util.*;
public class MyQueue {
	LinkedList<Node> queue = new LinkedList<Node>();
	public MyQueue()
	{
		queue = new LinkedList<Node>();
	}
	public void add(Node node1)
	{
		queue.addLast(node1);
	}
	public void remove(Node node2)
	{
		queue.remove(node2);
	}
	public Node removeFirst()
	{
		return queue.remove(0);
	}
}
