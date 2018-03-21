import java.util.*;

class WordsInWords {

	public static void main(String[] args) {

		System.out.println("Please enter a word: ");
		EasyReader in = new EasyReader();
		String word = in.readLine();

		String uppercase = "";
		for(int charIndex = 0; charIndex < word.length(); charIndex++) uppercase+=Character.toString(Character.toUpperCase(word.charAt(charIndex)));
		word = uppercase;

		EasyReader dictFile = new EasyReader("BigDict.txt");
		String currentWord;
		int wordCounter = 0;
		ArrayList<String> matches = new ArrayList<String>();
		while(!dictFile.eof()) {
			currentWord = dictFile.readLine();
			if(currentWord==null) break;
			for(int charIndex = 0; charIndex < word.length()-currentWord.length()+1; charIndex++) {
				for(int endIndex = charIndex+currentWord.length(); endIndex <= word.length(); endIndex++) {
					if(word.substring(charIndex,endIndex).equals(currentWord)) {
						matches.add(currentWord);
						wordCounter++;
					}
				}
			}
		}
		System.out.println("Words that can be made from given word: ");
		for(int matchIndex = 0; matchIndex < matches.size(); matchIndex++) System.out.println(matches.get(matchIndex));
		System.out.println("Number of words: "+wordCounter);
	}
}