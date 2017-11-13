import java.util.*;
class Riech {
	public static void main(String [] args) {
		Random r = new Random();
		EasyWriter out = new EasyWriter("MeinKampf.txt");
		int n;
		for (int h=0; h < 500; h++) {
			n=r.nextInt(100)+1;
			out.print(n+"\t");
		}
		out.close();
	}
}