class Hangman {
	public static void main(String[] args) {
		WordClass words = new WordClass("LowerDone.txt");
		String word = words.getRandomWord();

		char[] display = new char[word.length()];
		for(int n=0; n<word.length(); n++) display[n]='_';

		Alphabet guesses = new Alphabet("boolean");

		boolean win = false, match = false;
		EasyReader in = new EasyReader();
		for(int n=6; n>0; n--) {
			for(int i=0; i<word.length(); i++) {
				System.out.print(Character.toString(display[i]));
				if(i!=word.length()-1) System.out.print(" ");
			}
			System.out.println("\n("+n+") guesses left, please enter a guess:");



			char guess = (new String(in.readLine())).charAt(0);
			for(int i=0; i<guesses.alphaBln.size(); i++) if(guesses.charAt(i)==guess) guesses.setTrue(i);

			for(int i=0; i<word.length(); i++) {
				if(word.charAt(i)==guess) {
					display[i]=guess;
					match=true;
				}
			}

			if(match) n++;
			match=false;

			for(int i=0; i<display.length; i++) {
				if(display[i]=='_') break;
				else if(i==display.length-1 && display[i]!='_') win=true;
			}

			if(win) break;
		}

		if(win) System.out.println("You win!");
		else System.out.println("You lose...");
		System.out.println("The word was "+word);
	}
}