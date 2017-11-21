import java.util.*;

public class WordClass {

	ArrayList<String> library;
	String currentWord;

	WordClass() {}
	WordClass(String dictFile) {
		EasyReader in = new EasyReader(dictFile);
		library = new ArrayList<String>();
		while(!in.eof()) library.add(in.readWord());
		cleanArray();
	}

	public String[] alphaSort() {
		return alphaSort(currentWord);
	}
	public static String[] alphaSort(String str) {
		String[] returnArray = new String[str.length()];
		for(int n=0; n<returnArray.length; n++) returnArray[n]=Character.toString(str.charAt(n));
		Arrays.sort(returnArray);
		return returnArray;
	}
	public String charToString(char ch) {
		return Character.toString(ch);
	}
	public static boolean contains(char p, String whole) {
		return whole.contains(Character.toString(p));
	}
	public boolean contains(String part) {
		return contains(part,currentWord);
	}
	public static boolean contains(String part, String whole) {
		return whole.contains(part);
	}
	public String[] differBy(String word, int quan) {
		ArrayList<String> returnArray = new ArrayList<String>();
		String[] ofLength = getWordsOfLength(word.length());
		for(int n=0; n<ofLength.length; n++) {
			int difference = 0;
			for(int i=0; i<ofLength[n].length(); i++) if(ofLength[n].charAt(i)!=word.charAt(i)) difference++;
			if(difference<=quan) returnArray.add(ofLength[n]);
		}
		return (returnArray.toArray(new String[returnArray.size()]));
	}
	public String getRandomWord() {
		Random rand = new Random();
		return library.get(rand.nextInt(library.size()));
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
	public int indexOfWord(String part) {
		return indexAt(0,part,currentWord);
	}
	public int indexOfWord(String part, int place) {
		return indexAt(place,part,currentWord);
	}
	public int indexOfWordInLibrary(String target) {
		for(int n=0; n<library.size(); n++) if(target.equals(library.get(n))) return n;
		return -1;
	}
	public boolean isAlpha(char ch) {
		return Character.isLetter(ch);
	}
	public boolean isAlpha(String str) {
		for(int n=0; n<str.length(); n++) if(!Character.isLetter(str.charAt(n))) return false;
		return true;
	}
	public static boolean isSubset(String part, String whole) {
		for(int n=0; n<(whole.length()-part.length()+1); n++) if((part).equals(whole.substring(n,part.length()))) return true;
		return false;
	}
	public String[] lengthLimit(int siz) {
		ArrayList<String> returnArray = new ArrayList<String>();
		for(int n=1; n<=siz; n++) {
			String[] hold = getWordsOfLength(n);
			for(int i=0; i<hold.length; i++) returnArray.add(hold[i]);
		}
		return returnArray.toArray(new String[returnArray.size()]);
	}
	public String lower() {
		return lower(currentWord);
	}
	public static String lower(char ch) {
		return Character.toString(Character.toLowerCase(ch));
	}
	public static String lower(String str) {
		String returnString="";
		for(int n=0; n<str.length(); n++) returnString+=(Character.toLowerCase(str.charAt(n)));
		return returnString;
	}
	public static String[] parseSentence(String str) {
		str+=" ";
		String[] returnArray = new String[wordCount(str)];
		int wordCount=0, wordStart=0, c=0;
		boolean spaceTest = true;
		for(int n=0; n<str.length(); n++) {
			if (!Character.isLetter(str.charAt(n))) {
				if(!spaceTest) {
					spaceTest = true;
					returnArray[c] = lower(str.substring(wordStart,n));
					c++;
				}
			}
			else if(spaceTest) {
				spaceTest = false;
				wordStart=n;
			}
		}
		return returnArray;
	}
	public static String[] returnAlphaFile(String fileName) {
		WordClass file = new WordClass(fileName);
		file.alphaLibrary();
		file.writeLibrary(fileName);
		return file.library.toArray(new String[file.library.size()]);
	}
	public String[] returnCurrentLibrary() {
		return library.toArray(new String[library.size()]);
	}
	public static String reverse(String str) {
		String returnString="";
		for(int n=str.length()-1; n>=0; n--) returnString+=str.charAt(n);
		return returnString;
	}
	public void setCurrentWord(String word) {
		currentWord=word;
	}
	public void setLibraryValue(String[] listName) {
		for(int n=0; n<listName.length; n++) library.add(listName[n]);
	}
	public void changeLibraryValue(String[] listName) {
		library.clear();
		for(int n=0; n<listName.length; n++) library.add(listName[n]);
	}
	public void setLibraryVaule(String fileName) {
		String[] lib = (new WordClass(fileName)).returnCurrentLibrary();
		library.clear();
		for(int n=0; n<lib.length; n++) library.add(lib[n]);
	}
	public void setRandomWord() {
		Random rand = new Random();
		currentWord = library.get(rand.nextInt(library.size())+1);
	}
	public String showCurrentWord() {
		return currentWord;
	}
	public String showWordAt(int pos) {
		return wordAt(pos);
	}
	public String upper() {
		return upper(currentWord);
	}
	public static char upper(char ch) {
		return Character.toUpperCase(ch);
	}
	public static String upper(String str) {
		String returnString="";
		for(int n=0; n<str.length(); n++) returnString+=upper(str.charAt(n));
		return returnString;
	}
	public String wordAt(int place) {
		return library.get(place);
	}
	public int wordCount() {
		return library.size();
	}
	public void cleanArray() {
		for(int n=0; n<library.size(); n++) {
			String hold="";
			for(int i=0; i<library.get(n).length(); i++) {
				if(Character.isLetter(library.get(n).charAt(i))||library.get(n).charAt(i)=='\'') hold+=lower(library.get(n).charAt(i));
			}
			library.set(n,hold);
		}
	}
	public String[] getWordsOfLength(int length) {
		ArrayList<String> returnArray = new ArrayList<String>();
		for(int n=0; n<library.size(); n++) if(library.get(n).length()==length) returnArray.add(library.get(n));
		return (returnArray.toArray(new String[returnArray.size()]));
	}
	public static int wordCount(String in) {
		in+=" ";
		int wordCount=0, wordStart=0;
		boolean spaceTest = false;
		for(int n=0; n<in.length(); n++) {
			if (!Character.isLetter(in.charAt(n))) {
					spaceTest = true;
			}
			else if (spaceTest==true || n==0) {
				wordCount++;
				spaceTest = false;
			}
		}
		return wordCount;
	}
	public void writeLibrary(String fileName) {
		EasyWriter out = new EasyWriter(fileName);
		for(int n=0; n<library.size(); n++) out.print(library.get(n)+"\n");
	}
	public void alphaLibrary() {
		String[] lib = library.toArray(new String[library.size()]);
		Arrays.sort(lib);
		library.clear();
		for(int n=0; n<lib.length; n++) library.add(lib[n]);
	}
}