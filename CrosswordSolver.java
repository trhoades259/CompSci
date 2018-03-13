import java.util.*;

class CrosswordSolver {
	public static void main(String[] args) {
		EasyReader in = new EasyReader();
		System.out.println("List file (w/ .txt): ");
		EasyReader listFile = new EasyReader(in.readLine());
		System.out.println("Puzzle file (w/ .txt): ");
		String puzzleName = in.readLine();
		EasyReader puzzleFile = new EasyReader(puzzleName);

		ArrayList<String> list = new ArrayList<String>();
		while(!listFile.eof()) list.add(listFile.readLine());
		for(int n=0; n<2; n++) list.remove(list.size()-1);
		for(int n=0; n<list.size(); n++) System.out.println(list.get(n));

		int width = -1;
		for(char check=puzzleFile.readChar(); check!='\n'; check=puzzleFile.readChar()) if(check!='\t') width++;
		int length = 1;
		while(puzzleFile.readLine()!=null) length++;
		System.out.println(width+" "+length);

		char[][] puzzle = new char[width][length];
		char check;
		puzzleFile = new EasyReader(puzzleName);
		for(int n=0; n<width; n++) {
			for(int i=0; i<length; i++) {
				while(true) {
					check = puzzleFile.readChar();
					if(!Character.isWhitespace(check)) break;
				}
				puzzle[n][i] = check;
			}
		}
		for(int n=0; n<width; n++) {
			for(int i=0; i<length; i++) {
				System.out.print(puzzle[n][i]+"\t");
			}
			System.out.println();
		}

		int posX, posY;
		for(int w=0; w<list.size(); w++) {
			for(int n=0; n<width; n++) {
				for(int i=0; i<length; i++) {
					if(list.get(w).getCharAt(0)==puzzle[n][i]) {
						posX=n;
						posY=i;
						for(int direct=0; direct<8; direct++) {
							for(int charAt=1; charAt<list.get(w).length(); charAt++) {
								checkDirection(direct,charAt,n,i);
							}
						}
					}
				}
			}
		}
	}

	public static void checkDirection(int d, int chr, int x, int y) {

	}
}