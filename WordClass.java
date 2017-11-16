import java.util.*;

public class WordClass {

	private String currentWord;
	private static final String alphebet = "abcdefghijklmnopqrstuvwxyz";
	private String[] library;

	WordClass() {}
	WordClass(String dictFile) {
		dictFile+=" ";
		library = new String[wordCount(dictFile)];
		int wordCount=0, wordStart=0, c=0;
		boolean spaceTest = true;
		for(int n=0; n<dictFile.length(); n++) {
			if (!alphebet.contains(Character.toString(Character.toLowerCase(dictFile.charAt(n))))) {
				if(!spaceTest) {
					spaceTest = true;
					library[c] = WordClass.toLowercase(dictFile.substring(wordStart,n));
					c++;
				}
			}
			else if(spaceTest) {
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
		return whole.contains(Character.toString(p));
	}
	public boolean contains(String part) {
		for(int n=0; n<library.length; n++) if(library[n].contains(part)) return true;
		return false;
	}
	public static boolean contains(String part, String whole) {
		return whole.contains(part);
	}
	public static int wordCount(String in) {
		in+=" ";
		int wordCount=0, wordStart=0;
		boolean spaceTest = false;
		for(int n=0; n<in.length(); n++) {
			if (!alphebet.contains(Character.toString(Character.toLowerCase(in.charAt(n))))) {
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
	public String[] differsBy(String word, int quan) {
		Set<String> returnArray = new HashSet<String>();
		String[] ofLength = getWordsOfLength(word.length());
		for(int n=0; n<ofLength.length; n++) {
			int difference = 0;
			for(int i=0; i<ofLength[n].length(); i++) if(ofLength[n].charAt(i)!=word.charAt(i)) difference++;
			if(difference<=quan) returnArray.add(ofLength[n]);
		}
		return (returnArray.toArray(new String[returnArray.size()]));

	}
	public String[] getWordsOfLength(int length) {
		Set<String> returnArray = new HashSet<String>();
		for(int n=0; n<library.length; n++) if(library[n].length()==length) returnArray.add(library[n]);
		return (returnArray.toArray(new String[returnArray.size()]));
	}
	public static String toLowercase(String mod) {
		String returnString="";
		for(int n=0; n<mod.length(); n++) returnString+=(Character.toLowerCase(mod.charAt(n)));
		return returnString;
	}
	public String getRandomWord() {
		Random rand = new Random();
		return library[rand.nextInt(library.length)];
	}
	public static int howManyOf(char ch, String whole) {
		int counter=0;
		for(int n=0; n<whole.length(); n++) if(whole.charAt(n)==ch) counter++;
		return counter;
	}
	public static int howManyOf(String part, String whole) {
			int counter=0;
			for(int n=0; n<(whole.length()-part.length()+1); n++) if((part).equals(whole.substring(n,part.length()))) counter++;
			return counter;
	}
	public int indexAt(char ch) {
		return indexAt(0,ch,currentWord);
	}
	public int indexAt(char ch, int place) {
		return indexAt(place,ch,currentWord);
	}
	public static int indexAt(char ch, String str) {
		return indexAt(0,ch,str);
	}
	public static int indexAt(int num, char ch, String str) {
			for(int n=num; n<str.length(); n++) if(str.charAt(n)==ch) return n;
			return -1;
	}
	public static int indexAt(int num, String part, String whole) {
		for(int n=num; n<(whole.length()-part.length()+1); n++) if((part).equals(whole.substring(n,part.length()))) return n;
		return -1;
	}
	public static int indexAt(String part, String whole) {
		return indexAt(0,part,whole);
	}
}