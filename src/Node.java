public class Node {
private int number;
private String str;
	public Node(int integer, String string)
	{
		number = integer;
		str = string;
	}

	public int getValue()
	{
		return number;
	}
	public String getStr()
	{
		return str;
	}
	public void setValue(int num)
	{
		number = num;
	}
	public void setStr(String string)
	{
		str = string;
	}
}
