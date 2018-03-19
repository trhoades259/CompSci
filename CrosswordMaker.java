import java.util.*;

class CrosswordMaker {
	public static String currentWord;
	public static char[][] puzzle;

	public static void main(String[] args) {
		System.out.println("Welcome to the Word Search Maker 3000! How many characters wide would you like your word search?");
		EasyReader in = new EasyReader();
		int width = in.readInt();
		System.out.println("How many characters long do you want your word search?");
		int length = in.readInt();

		ArrayList<String> words = new ArrayList<String>();
		String word;
		System.out.println("Would you like to import words from a list file or manually enter?");
		in = new EasyReader();
		if(Character.toLowerCase(in.readChar())!='i') {
			while(true) {
				in = new EasyReader();
				System.out.println("Please enter a word. Enter \'f\' when finished: ");
				word = in.readLine();
				if(word.equals("f")) break;
				words.add(word);
				System.out.println("Current words: "+Arrays.toString(words.toArray()));
			}
		}
		else {
			in = new EasyReader();
			System.out.println("List file name: ");
			EasyReader listFile = new EasyReader(in.readLine()+".txt");
			while(!listFile.eof()) words.add(listFile.readLine());
			while(words.get(words.size()-1)==null || !Character.isLetter(words.get(words.size()-1).charAt(0))) words.remove(words.size()-1);
			System.out.println("Words: "+Arrays.toString(words.toArray()));
		}

		puzzle = new char[width][length];
		int x,y,direct,xMod,yMod;
		Random rand = new Random();
		boolean found;
		for(int wordIndex = 0; wordIndex < words.size(); wordIndex++) {
			currentWord = words.get(wordIndex);
			found = false;
			while(!found) {
				direct = rand.nextInt(8);
				x = rand.nextInt(width);
				xMod = xMod(direct);
				y = rand.nextInt(length);
				yMod = yMod(direct);
				if(x+(currentWord.length()-1)*xMod < 0 || x+(currentWord.length()-1)*xMod >= width || y+(currentWord.length()-1)*yMod < 0 || y+(currentWord.length()-1)*yMod >= length) continue;
				for(int charIndex = 0; charIndex < currentWord.length(); charIndex++) {
					if(Character.isLetter(puzzle[x+charIndex*xMod][y+charIndex*yMod]) && puzzle[x+charIndex*xMod][y+charIndex*yMod]!=Character.toUpperCase(currentWord.charAt(charIndex))) break;
					if(charIndex==currentWord.length()-1) {
						for(int charAt = 0; charAt< currentWord.length(); charAt++) puzzle[x+charAt*xMod][y+charAt*yMod] = Character.toUpperCase(currentWord.charAt(charAt));
						found = true;
					}
				}
			}
		}

		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(x=0; x<width; x++) for(y=0; y<length; y++) if(!Character.isLetter(puzzle[x][y])) puzzle[x][y] = alpha.charAt(rand.nextInt(26));

		System.out.println("Name of your word search file (will be a .txt file): ");
		EasyWriter out = new EasyWriter(in.readLine()+".txt");
		for(x = 0; x < width; x++) {
			for(y = 0; y < length; y++) {
				out.print(puzzle[x][y]+"\t");
			}
			out.println();
		}
		out.close();
		System.out.println("Word search file created!");
	}
	private static int xMod(int d) {
		if(d==0 || d==6 || d==7) return -1;
		if(d==1 || d==5) return 0;
		return 1;
	}
	private static int yMod(int d) {
		if(d==0 || d==1 || d==2) return -1;
		if(d==3 || d==7) return 0;
		return 1;
	}
}