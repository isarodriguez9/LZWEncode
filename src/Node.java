public class Node {
private boolean boo;
private String str;
	public Node(String string, boolean bool)
	{
		boo = bool;
		str = string;
	}

	public boolean inQueue()
	{
		return boo;
	}
	public String getStr()
	{
		return str;
	}
	public void setBool(boolean bool)
	{
		boo = bool;
	}
	public void setStr(String string)
	{
		str = string;
	}
}
