import java.util.*;

class WordsFromLetters {

	public static void main(String[] args) {

		System.out.println("Please enter several letter: ");
		EasyReader in = new EasyReader();
		String word = in.readLine();

		int[] wordCharCount = new int[26];
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		for(int charIndex = 0; charIndex < word.length(); charIndex++) {
			for(int alphaIndex = 0; alphaIndex < 26; alphaIndex++) {
				if(word.charAt(charIndex)==alpha.charAt(alphaIndex)) {
					wordCharCount[alphaIndex]++;
					break;
				}
			}
		}

		EasyReader dictFile = new EasyReader("BigDict.txt");
		String currentWord;
		int[] currentCharCount = new int[26];
		alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int wordCounter = 0;
		ArrayList<String> matches = new ArrayList<String>();
		while(!dictFile.eof()) {
			currentWord = dictFile.readLine();
			if(currentWord==null) break;
			for(int charIndex = 0; charIndex < currentWord.length(); charIndex++) {
				for(int alphaIndex = 0; alphaIndex < 26; alphaIndex++) {
					if(currentWord.charAt(charIndex)==alpha.charAt(alphaIndex)) {
						currentCharCount[alphaIndex]++;
						break;
					}
				}
			}
			for(int alphaIndex = 0; alphaIndex < 26; alphaIndex++) {
				if(wordCharCount[alphaIndex]<currentCharCount[alphaIndex]) break;
				if(alphaIndex==25) {
					matches.add(currentWord);
					wordCounter++;
				}
			}
			for(int countIndex=0; countIndex<currentCharCount.length; countIndex++) currentCharCount[countIndex]=0;
		}
		System.out.println("Words that can be made from given letters: ");
		for(int matchIndex = 0; matchIndex < matches.size(); matchIndex++) System.out.println(matches.get(matchIndex));
		System.out.println("Number of words: "+wordCounter);
	}
}