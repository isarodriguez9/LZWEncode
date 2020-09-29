public class Node {
private int number;
private String str;
	public Node(String string, int integer)
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
