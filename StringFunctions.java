class StringFunctions
{
	public static void main (String [] args) {
		String words = "This is a bunch of words." ;
		/* String smallString;
		int count ;
		int first, last ;
		char d;
		System.out.println(words.length());
		System.out.println(words.substring(20,22));
		smallString=words.substring(20,22);
		System.out.println(smallString);
		System.out.println(words.toUpperCase());
		System.out.println(words.toLowerCase());
		System.out.println(words.charAt(12));
		d=words.charAt(12);*/
		for(int counter=words.length()-1; counter>=0;counter--) {
			System.out.println(words.substring(0,counter+1));

		}
	}
}