class UpperAndLower
{
	public static void main (String [] args)
	{
		EasyReader in = new EasyReader();

		String text ;

		System.out.println("Type a phrase: ");
		text = in.readLine();
		System.out.println("---------------");

		for (int i = 0; i<text.length();i++)
		{
			char textTest = text.charAt(i);
			textTest = Character.toUpperCase(textTest);
			if (text.charAt(i)==(textTest))
			{
				textTest = Character.toLowerCase(textTest);
				System.out.print(textTest);
			}
			else
			{
				System.out.print(textTest);
			}
		}
		System.out.println();
	}
}