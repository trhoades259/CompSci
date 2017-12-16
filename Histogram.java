public class Histogram {

	public static void print(int[] in) {
		int[] e = extrema(in);
		int c;
		for(int n = e[0]; n <= e[1]; n++) {
			c=count(in,n);
			System.out.print("Number of "+n+"s ("+c+"):\t");
			printStar(c);
			System.out.println();
		}
	}
	public static void printStar(int n) {
		for(int i = 0; i < n; i++) System.out.print("*");
	}
	public static void printSpace(int max) {
		for(int i = 0; i < max; i++) System.out.print(" ");
	}
	public static void printSymbol(char c, int n) {
		for(int i = 0; i < n; i++) System.out.print(Character.toString(c));
	}
	public static int count(int[] a, int v) {
		int c = 0;
		for(int n = 0; n < a.length; n++) if(a[n]==v) c++;
		return c;
	}
	public static int[] extrema(int[] in) {
		int[] e = new int[2];
		e[0]=in[0];
		e[1]=in[0];
		for(int n = 1; n < in.length; n++) {
			if(in[n]<e[0]) e[0]=in[n];
			else if(in[n]>e[1]) e[1]=in[n];
		}
		return e;
	}
}