class DiamondText
{
	public static void main (String [] args)
	{
		String text ;

		EasyReader in = new EasyReader();
		System.out.println("Type a sentence: ");
		text = in.readLine();
		System.out.println("-----------------");

		if ((int) (text.length()/2) == ((double) (text.length()))/2)
		{
			System.out.println("even");
			int test = (int) (text.length()/2) - 1;
			for
		}
		else
		{
			System.out.println("odd");
		}
	}
}