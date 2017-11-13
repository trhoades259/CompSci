class Diamonds
{
	public static void main (String [] args)
	{
		EasyReader in = new EasyReader() ;

		System.out.println("Write a phrase you would like to turn into a diamond: ");
		String text =  in.readLine() ;
		System.out.println("------------------------------------------------------");
		for (int num = (text.length()/2) ; num >= 0 ; num--)
		{
			diamondln(num,text.substring(num,text.length()-num));
		}
		for (int num = 0 ; num <= (text.length()/2) ; num++)
		{
			diamondln(num,text.substring(num,text.length()-num));
		}
	}
	public static void diamondln (int a, String b)
	{
		for(int i = a ; i > 0 ; i--)
		{
			System.out.print(" ");
		}
		System.out.print(b);
		System.out.println();
	}
}