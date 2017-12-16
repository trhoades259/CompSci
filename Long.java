import java.util.Random;
class Long {
	public static void main (String [] args) {
		EasyReader i = new EasyReader();
		System.out.println("Please enter a number: ");
		int t=i.readInt(),r,p;
		Random a = new Random();
		int e[] = new int[25];
		int g[] = new int[25];
		System.out.println("raw: ");
		p = a.nextInt(25);
		for (int d = 0; d < 25; d++) {
			e[d]=1;
			g[d]=1;
		}
		for (int n = 1; n < t; n++) {
			r = a.nextInt(25)+1;
			System.out.println(r);
			if (r==p) {
				for (int f = 1; f < 26; f++) {
					if (f==r) e[f-1]++;
				}
			}
			else {
				for (int j = 0; j < 25; j++) e[j]=0;
				p = r;
			}
			for (int d = 0; d < 25; d++) {
				if ( > m) m = c;
			}
		}
		for (int m = 0; m < 25; m++) if(g[m]==1) g[m]--;
		for (int y = 0; y < 25; y++) System.out.println((y+1)+": "+g[y]);
	}
}