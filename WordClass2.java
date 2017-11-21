import java.util.*;

public class WordClass2 {

	private String currentWord;
	private static final String alphebet = "abcdefghijklmnopqrstuvwxyz";
	private String[] library;

	WordClass2() {}
	WordClass2(String dictFile) {
		/*EasyReader in = new EasyReader(dictFile);
		int wordCount=0;
		while(in.readWord()!=null) wordCount++;
		in = new EasyReader(dictFile);
		library = new String[wordCount];
		for(int n=0; n<library.length; n++) library[n]=in.readWord();*/
		dictFile+=" ";
		library = new String[wordCount(dictFile)];
		int wordCount=0, wordStart=0, c=0;
		boolean spaceTest = true;
		for(int n=0; n<dictFile.length(); n++) {
			if (!alphebet.contains(Character.toString(Character.toLowerCase(dictFile.charAt(n))))) {
				if(!spaceTest) {
					spaceTest = true;
					library[c] = lower(dictFile.substring(wordStart,n));
					c++;
				}
			}
			else if(spaceTest) {
				spaceTest = false;
				wordStart=n;
			}
		}
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
	public int indexOfWord(String part) {
		return indexAt(0,part,currentWord);
	}
	public int indexOfWord(String part, int place) {
		return indexAt(place,part,currentWord);
	}
	public int indexOfWordInLibrary(String target) {
		for(int n=0; n<library.length; n++) if(target.equals(library[n])) return n;
		return -1;
	}
	public boolean isAlpha(char ch) {
		return alphebet.contains(Character.toString(Character.toLowerCase(ch)));
	}
	public boolean isAlpha(String str) {
		for(int n=0; n<str.length(); n++) if(!alphebet.contains(Character.toString(Character.toLowerCase(str.charAt(n))))) return false;
		return true;
	}
	public static boolean isSubset(String part, String whole) {
		for(int n=0; n<(whole.length()-part.length()+1); n++) if((part).equals(whole.substring(n,part.length()))) return true;
		return false;
	}
	public String[] lengthLimit(int siz) {
		Set<String> returnArray = new HashSet<String>();
		for(int n=1; n<=siz; n++) {
			String[] hold = getWordsOfLength(n);
			for(int i=0; i<hold.length; i++) returnArray.add(hold[i]);
		}
		return (returnArray.toArray(new String[returnArray.size()]));
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
			if (!alphebet.contains(Character.toString(Character.toLowerCase(str.charAt(n))))) {
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
	public String[] returnAlphaFile(String fileName) {
		EasyReader in = new EasyReader(fileName);
		String wholeFile="";
		while(!in.eof()) wholeFile+=in.readLine();
		WordClass file = new WordClass(wholeFile);
		alphaLibrary();
		writeLibrary(fileName);
		return library;
	}
	public void writeLibrary(String fileName) {
		EasyWriter out = new EasyWriter(fileName);
		for(int n=0; n<library.length; n++) out.print(library[n]+"\n");
	}
	public void alphaLibrary() {
		Arrays.sort(library);
	}
	public String[] returnCurrentLibrary() {
		return library;
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
		library=listName;
	}
	public void setLibraryVaule(String fileName) {
		EasyReader in = new EasyReader(fileName);
		Set<String> returnArray = new HashSet<String>();
		while(!in.eof()) returnArray.add(in.readWord());
		library=returnArray.toArray(new String[returnArray.size()]);
	}
	public void setRandomWord() {
		Random rand = new Random();
		currentWord = library[rand.nextInt(library.length)+1];
	}
	public String showCurrentWord() {
		return currentWord;
	}
	public String showWordAt(int pos) {
		return library[pos];
	}
	public String upper() {
		return upper(currentWord);
	}
	public static char upper(char ch) {
		return Character.toUpperCase(ch);
	}
	public static String upper(String str) {
		String returnString="";
		for(int n=0; n<str.length(); n++) returnString+=(Character.toUpperCase(str.charAt(n)));
		return returnString;
	}
	public String wordAt(int place) {
		return library[place];
	}
	public int wordCount() {
		return library.length;
	}
	public void cleanFile(String fileName) {
		EasyReader in = new EasyReader(fileName);
		String wholeFile="";
		while(!in.eof()) wholeFile+=in.readLine();



		int charCount=0;
		while(in.readChar()!=null) charCount++;
		in = new EasyReader(fileName);
		char[] chars= new char[charCount];
		for(int n=0; n<charCount; n++) chars[n]=in.readChar();

		//for(int n=0; n<charCount; n++) if(!alphebet.contains(Character.toString(Character.toLowerCase(in.readInt))))
	}
}