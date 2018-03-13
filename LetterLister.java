import java.util.*;

class LetterLister {

	public static void main(String[] args) {

		System.out.println("Please enter a letter: ");

		EasyReader in = new EasyReader();

		char letter = in.readChar();

		System.out.println("Maximun number of words(enter \"-1\" for no limit): ");

		int limit = in.readInt();

		System.out.println("Words containing \'"+letter+"\': ");

		EasyReader dictFile = new EasyReader("LowerDone.txt");

		ArrayList<String> dict = new ArrayList<String>();

		while(!dictFile.eof()) dict.add(dictFile.readLine());
		dict.remove(dict.size()-1);

		int wordCounter = 0;

		for(int wordIndex=0; wordIndex<dict.size() && limit-wordCounter!=0; wordIndex++) {
			for(int charIndex=0; charIndex<dict.get(wordIndex).length(); charIndex++) {
				if(dict.get(wordIndex).charAt(charIndex)==letter) {
					System.out.println(dict.get(wordIndex));
					wordCounter++;
					break;
				}
			}
		}

		System.out.println("Chosen letter: "+letter);
		System.out.println("Number of words: "+wordCounter);
	}
}