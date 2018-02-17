import java.util.*;

class Quilt {
	public static int width,length,x,y;
	public static int[][] quilt;

	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<String>();
		EasyReader in = new EasyReader();

		System.out.println("Welcome to the Quilt Maker 3000! Please enter color names until done (must have at least 4). Once done, use the command \"create\"\nQuilt width: ");
		width = in.readInt();
		System.out.println("Quilt length: ");
		length = in.readInt();
		int tiles = width*length;

		in = new EasyReader();
		while(true) {
			System.out.println("Please enter a color: ");
			String color = in.readLine();
			if(color.equals("create")) {
				if(colors.size()<4) {
					System.out.println((4-colors.size())+" more colors required");
					continue;
				}
				else break;
			}
			colors.add(color);
			System.out.println("Current colors: "+Arrays.toString(colors.toArray()));
		}

		quilt = new int[width][length];
		Random rand = new Random();
		for(y=0; y<length; y++) {
			for(x=0; x<width; x++) {
				while(true) {
					quilt[x][y] = rand.nextInt(colors.size())+1;
					if(check()) break;
				}
				System.out.print(quilt[x][y]+"\t");
			}
			System.out.println();
		}
	}
	private static boolean check() {
		if(y>0 && x>0 && quilt[x-1][y-1]==quilt[x][y]) return false;
		if(y>0 && quilt[x][y-1]==quilt[x][y]) return false;
		if(y>0 && x<width-1 && quilt[x+1][y-1]==quilt[x][y]) {
			System.out.println(quilt[x][y]);
			return false;
		}
		if(x>0 && quilt[x-1][y]==quilt[x][y]) return false;
		return true;
	}
}