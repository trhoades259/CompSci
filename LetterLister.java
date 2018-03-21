import java.util.*;

class LetterLister {

	public static void main(String[] args) {

		EasyReader dictFile = new EasyReader("LowerDone.txt");
		ArrayList<String> dict = new ArrayList<String>();
		while(!dictFile.eof()) dict.add(dictFile.readLine());
		dict.remove(dict.size()-1);

		ArrayList<Character> letters = new ArrayList<Character>();
		ArrayList<String> words;
		EasyReader in;
		while(true) {
			words = new ArrayList<String>();
			in = new EasyReader();
			System.out.println("Please enter a letter (enter 0 when done): ");
			letters.add(in.readChar());
			if(!Character.isLetter(letters.get(letters.size()-1))) break;

			System.out.println("Words containing \'"+letters.get(letters.size()-1)+"\': ");
			for(int wordIndex=0; wordIndex<dict.size(); wordIndex++) {
				for(int charIndex=0; charIndex<dict.get(wordIndex).length(); charIndex++) {
					if(dict.get(wordIndex).charAt(charIndex)==letters.get(letters.size()-1)) {
						System.out.println(dict.get(wordIndex));
						words.add(dict.get(wordIndex));
						break;
					}
				}
			}
			System.out.println("Chosen letters: "+Arrays.toString(letters.toArray()));
			System.out.println("Number of words: "+words.size());
			dict = words;
		}
	}
}