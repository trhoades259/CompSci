public class WordClass {

	private String currentWord, main;
	private static final String alphebet = "abcdefghijklmnopqrstuvwxyz";
	private String[] library;

	WordClass() {}
	WordClass(String dictFile) {
		library = new String[wordCount(dictFile)];
		int c = 0, wordStart = 0;
		boolean spaceTest = false;
		for(int n=0; n<dictFile.length(); n++) {
			if (!alphebet.contains(Character.toString(dictFile.charAt(n)))) {
				if(!spaceTest) {
					spaceTest = true;
					library[c] = dictFile.substring(wordStart,n);
					c++;
				}
			}
			else if(spaceTest || n==0) {
				spaceTest = false;
				wordStart=n;
			}
		}
	}

	public void setCurrentWord(String word) {
		currentWord=word;
	}
	public String[] alphaSort() {
		String[] returnArray = new String[currentWord.length()];
		int count=0;
		for(int n=0; n < alphebet.length(); n++) {
			for(int i=0; i < currentWord.length(); i++) {
				if(Character.toLowerCase(currentWord.charAt(i))==alphebet.charAt(n)) {
					returnArray[count]=Character.toString(alphebet.charAt(n));
					count++;
				}
			}
			if(count==currentWord.length()) break;
		}
		return returnArray;
	}
	public static String[] alphaSort(String str) {
			String[] returnArray = new String[str.length()];
			int count=0;
			for(int n=0; n < alphebet.length(); n++) {
				for(int i=0; i < str.length(); i++) {
					if(Character.toLowerCase(str.charAt(i))==alphebet.charAt(n)) {
						returnArray[count]=Character.toString(alphebet.charAt(n));
						count++;
					}
				}
				if(count==str.length()) break;
			}
			return returnArray;
	}
	public static String charToString(char ch) {
		return Character.toString(ch);
	}
	public static boolean contains(char p, String whole) {
		/*for(int n=0; n < whole.length(); n++) {
			if(whole.charAt(n)==p) return true;
		}
		return false;*/
		return whole.contains(Character.toString(p));
	}
	public boolean contains(String part) {
		return main.contains(part);
	}
	public static boolean contains(String part, String whole) {
		return whole.contains(part);
	}
	public static int wordCount(String in) {
		in+=" ";
		int wordCount=0, wordStart=0;
		boolean spaceTest = false;
		for(int n=0; n<in.length(); n++) {
			if (!alphebet.contains(Character.toString(in.charAt(n)))&&(in.charAt(n)!='\'')) {
				spaceTest = true;
			}
			else if (spaceTest==true || n==0) {
				wordCount++;
				spaceTest = false;
			}
		}
		return wordCount;
	}
	public String[] getLibrary() {
		return library;
	}

}