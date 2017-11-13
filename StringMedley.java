 class StringMedley
{
	public static void main (String [] args)
	{
		EasyReader in = new EasyReader();

		String text ;

		boolean wordBegin = false;
		boolean spaceTest = false ;

		int capCount = 0, wordCount=0, wordStart=0, wordEnd;

		System.out.println("Type a sentence: ");
		text = in.readLine();
		System.out.println("-----------------");

		for (int num=0;num<text.length();num++)
		{
			if (text.charAt(num)==' ')
			{
				System.out.print(" ");
				spaceTest = true;
			}
			else
			{
				if (spaceTest==true || num==0)
				{
					wordCount++;
					spaceTest = false;
					char textTest = text.charAt(num);
					textTest = Character.toUpperCase(textTest);
					if (text.charAt(num)==(textTest))
					{
						System.out.print(text.charAt(num));

					}
					else
					{
						System.out.print(textTest);
						capCount++;
					}
				}
				else if (spaceTest == false)
				{
					System.out.print(text.charAt(num));
				}
			}
		}
		System.out.println();
		System.out.println("Number of words: "+wordCount);
		System.out.println("Number of letter capitalized: "+capCount);

	}
}