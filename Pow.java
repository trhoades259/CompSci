class Pow
{
	public static void main (String [] args)
	{
		int add = 0;
		for (int num = 1; num<=10;num++)
		{
			add = add + (int) (Math.pow(num,2));
		}
		System.out.println(add);
	}
}