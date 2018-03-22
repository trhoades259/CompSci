import java.util.*;

class WordLadder {
	public static void main(String[] args) {
		System.out.println("Please enter a word: ");
		EasyReader in = new EasyReader();
		String wordStart = in.readLine(), wordEnd;
		System.out.println("Please enter a second word of length "+wordStart.length()+": ");
		while(true) {
			wordEnd = in.readLine();
			if(wordEnd.length()==wordStart.length()) break;
			System.out.println("That word was not the same length a the first, please try again: ");
		}

		String uppercase = "";
		for(int charIndex = 0; charIndex < wordStart.length(); charIndex++) uppercase+=Character.toString(Character.toUpperCase(wordStart.charAt(charIndex)));
		wordStart = uppercase;
		uppercase = "";
		for(int charIndex = 0; charIndex < wordEnd.length(); charIndex++) uppercase+=Character.toString(Character.toUpperCase(wordEnd.charAt(charIndex)));
		wordEnd = uppercase;
		System.out.println("------------------");
		System.out.println(wordStart);

		EasyReader dictFile = new EasyReader("BigDict.txt");
		ArrayList<String> words = new ArrayList<String>();
		String check;
		while(!dictFile.eof()) {
			check = dictFile.readLine();
			if(check.length()==wordStart.length()) words.add(check);
			if(check.length()>wordStart.length()) break;
		}

		ArrayList<String> ladder = new ArrayList<String>();
		ladder.add(wordStart);
		boolean[] hits = new boolean[wordStart.length()];
		boolean end;
		Random rand = new Random();
		int index;
		char chr;
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int hitCounter = 0;
		while(!ladder.get(ladder.size()-1).equals(wordEnd)) {
			if(hitCounter > 1000) {
				ladder.clear();
				ladder.add(wordStart);
				hits = new boolean[wordStart.length()];
				hitCounter = 0;
			}
			end = false;
			for(int charIndex=0; charIndex<wordStart.length(); charIndex++) {
				if(hits[charIndex]) continue;
				check = replaceChar(ladder.get(ladder.size()-1),charIndex,wordEnd.charAt(charIndex));
				if(ladder.get(ladder.size()-1).equals(check)) {
					hits[charIndex] = true;
					break;
				}
				for(int wordIndex=0; wordIndex<words.size(); wordIndex++) {
					if(words.get(wordIndex).equals(check)) {
						ladder.add(check);
						System.out.println(check);
						hits[charIndex] = true;
						end = true;
						break;
					}
				}
				if(end) {
					hitCounter = 0;
					break;
				}
				hitCounter++;
				for(int charTest=wordStart.length()-1; charTest>=charIndex; charTest--) {
					if(!hits[charTest]) {
						if(charTest>charIndex) break;
						if(charTest==charIndex) {
							while(true) {

								index = rand.nextInt(wordStart.length());
								if(hits[index]) continue;
								chr = alpha.charAt(rand.nextInt(26));
								check = replaceChar(ladder.get(ladder.size()-1),index,chr);
								if(ladder.get(ladder.size()-1).equals(check)) continue;
								for(int wordIndex=0; wordIndex<words.size(); wordIndex++) {
									if(words.get(wordIndex).equals(check)) {
										ladder.add(check);
										System.out.println(check);
										end = true;
										break;
									}
								}
								if(end) break;
							}
						}
					}
				}
			}
			if(end) continue;
		}
	}

	public static String replaceChar(String origin, int index, char chr) {
				return (origin.substring(0,index)+chr+origin.substring(index+1,origin.length()));
	}
}