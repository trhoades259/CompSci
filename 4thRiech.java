import java.util.*;
class Riech {
	public static void main(String [] args) {
		Random r = new Random();
		EasyWriter out = new EasyWriter("MeinKampf.txt");
		int n;
		for (int h=0; h < 25; h++) {
			n=r.nextInt(99);
			out.println(n);
		}
		out.close();
	}
}