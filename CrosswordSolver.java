import java.util.*;

class CrosswordSolver {
	public static int xMod,yMod;

	public static void main(String[] args) {
		System.out.println("List file name: ");
		EasyReader in = new EasyReader();
		EasyReader listFile = new EasyReader(in.readLine()+".txt");
		System.out.println("Puzzle file name: ");
		String puzzleName = in.readLine()+".txt";
		EasyReader puzzleFile = new EasyReader(puzzleName);

		ArrayList<String> list = new ArrayList<String>();
		while(!listFile.eof()) list.add(listFile.readLine());
		while(list.get(list.size()-1)==null || !Character.isLetter(list.get(list.size()-1).charAt(0)))list.remove(list.size()-1);

		int width = -1, length = 1;
		for(char check=puzzleFile.readChar(); check!='\n'; check=puzzleFile.readChar()) if(check!='\t') width++;
		while(puzzleFile.readLine()!=null) length++;

		char [][] puzzle = new char[width][length];
		boolean[][] mod = new boolean[width][length];
		char check;
		puzzleFile = new EasyReader(puzzleName);
		for(int y=0; y<length; y++) {
			for(int x=0; x<width; x++) {
				while(true) {
					check = puzzleFile.readChar();
					if(!Character.isWhitespace(check)) break;
				}
				puzzle[x][y] = Character.toLowerCase(check);
			}
		}

		String currentWord;
		for(int wordIndex = 0; wordIndex < list.size(); wordIndex++) {
			currentWord = list.get(wordIndex);
			for(int y = 0; y < length; y++) {
				for(int x = 0; x < width; x++) {
					if(currentWord.charAt(0)==puzzle[x][y]) {
						for(int direct = 0; direct < 8; direct++) {
							for(int charIndex = 1; charIndex < currentWord.length(); charIndex++) {
								xMod = xMod(direct);
								yMod = yMod(direct);
								if(x+charIndex*xMod < 0 || x+charIndex*xMod >= width || y+charIndex*yMod < 0 || y+charIndex*yMod >= length) break;
								if(puzzle[x+charIndex*xMod][y+charIndex*yMod]!=currentWord.charAt(charIndex)) break;
								if(charIndex==currentWord.length()-1) for(int charAt = 0; charAt< currentWord.length(); charAt++) mod[x+charAt*xMod][y+charAt*yMod] = true;
							}
						}
					}
				}
			}
		}

		System.out.println("Name of your .html file: ");
		EasyWriter HTML = new EasyWriter(in.readLine()+".html");
		HTML.print("<html><head></head><body><table>");
		for(int y=0; y<length; y++) {
			HTML.print("<tr>");
			for(int x=0; x<width; x++) {
				HTML.print("<td>");
				if(mod[x][y]) HTML.print("<font color=\"red\">"+Character.toUpperCase(puzzle[x][y])+"</font>");
				else HTML.print(puzzle[x][y]);
			}
			HTML.print("</tr>");
		}
		HTML.print("</table></body></html>");
		HTML.close();
		System.out.println("HTML file created!");
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