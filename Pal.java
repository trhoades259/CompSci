class Pal
{
	public static void main (String [] args)
	{
		EasyReader in = new EasyReader();

		String text, pal = "", flip = "";
		char upText ;

		System.out.println("Type a phrase to see if its a palindrome: ");
		text = in.readLine();
		System.out.println("------------------------------------------");

		for ( int num = 0 ; num <= (text.length()-1); num++ )
		{
			if (!(text.charAt(num)==' '))
			{
				upText = Character.toUpperCase(text.charAt(num)) ;
				pal += upText ;
			}
		}
		int test = pal.length()/2 ;
		if (!((int) (pal.length()/2) == ((double) (pal.length()))/2))
		{
			test++;
		}
		for ( int rev = pal.length() ; rev > test ; rev-- )
		{
			flip += pal.charAt(rev-1);
		}
		System.out.println(pal.substring(0,pal.length()/2)+"\n"+flip);
		if ((pal.substring(0,pal.length()/2)).equals(flip))
		{
			System.out.println("Palindrome") ;
		}
		else
		{
			System.out.println("Not a Palindrome");
		}
	}
}