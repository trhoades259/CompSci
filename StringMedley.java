 class StringMedley
{
	public static void main (String [] args)
	{
		EasyReader in = new EasyReader();

		String text, alphebet = "abcdefghijklmnopqrstuvwxyz";

		//boolean wordBegin = false;
		//boolean spaceTest = false ;

		//int capCount = 0, wordCount=0, wordStart=0, wordEnd;

		System.out.println("Type a sentence: ");
		text = in.readLine()+" ";
		System.out.println("-----------------");

		/*for (int num=0;num<text.length();num++)
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
		}*/
		int wordCount=0, wordStart=0;
		boolean spaceTest = false;
		for(int n=0; n<text.length(); n++) {
			if (!alphebet.contains(Character.toString(text.charAt(n)))&&(text.charAt(n)!='\'')) {
				spaceTest = true;
				System.out.print(n+"S ");
			}
			else if (spaceTest==true || n==0) {
				wordCount++;
				spaceTest = false;
				System.out.print(n+"W ");
			}
		}
		String[] library = new String[wordCount];
		int c = 0;
		for(int n=0; n<text.length(); n++) {
			if (!alphebet.contains(Character.toString(text.charAt(n)))) {
				if(!spaceTest) {
					spaceTest = true;
					library[c] = text.substring(wordStart,n);
					c++;
				}
			}
			else if(spaceTest || n==0) {
				spaceTest = false;
				wordStart=n;
			}
		}


		System.out.println();
		System.out.println("Number of words: "+wordCount);
		for(int n=0; n < library.length; n++) System.out.println(library[n]);
		//System.out.println("Number of letter capitalized: "+capCount);

	}
}