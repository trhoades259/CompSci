import java.util.Random;
class Randy {
	public static void main (String[] args) {
		int[] r = new int[3];
		for (int a = 0; a < r.length; a++) {
			r[a]= random(15);
			System.out.print(r[a]+"\t");
		}
		for(int b = 0; b < 3; b++) System.out.println();
		for(int c = 1; c < 16; c++)
			for(int d = 0; d < 3; d++) {
				if (r[d]==c) System.out.print(r[d]+"\t");
			}
		 System.out.println();
	}
	public static int random (int l) {
		Random rand = new Random();
		int r = rand.nextInt(l) + 1;
		return r;
	}
}