import java.util.*;
class PowerballData {
	public static void main (String [] args) {
		Set<Integer> i = new HashSet<Integer>(), t = new HashSet<Integer>(), p = new HashSet<Integer>(), z = new HashSet<Integer>(), y = new HashSet<Integer>(), x = new HashSet<Integer>();
		int e,m,v,c=0,d=0,f=0,u=0,h=0,o=0;
		Random b = new Random();
		EasyReader in = new EasyReader();
		for (int s = 0; s < 5; s++) {
			System.out.println("Powerball #"+(s+1)+" (Number that has not yet been chosen between 1 and 54): ");
			e = in.readInt();
			if (e<1 || e>54 || i.contains(e)) {
				s--;
				System.out.println("\nInvalid Input! Please Try Again.\n");
			}
			else i.add(e);
		}
		System.out.println("How many trials would you like to collect data for?: ");
		int n = in.readInt();
		for (int l = 0; l < n; l++) {
			while (true) {
				m = 0;
				f++;
				for (int a = 0; a < 5; a++) {
					v = b.nextInt(54)+1;
					if (i.contains(v) && !t.contains(v)) {
						m++;
						t.add(v);
					}
					p.add(v);
				}
				t.clear();
				if (m==5) break;
				else if (m==4) d++;
				else if (m==3) c++;
				p.clear();
			}
			z.add(f);
			y.add(d);
			x.add(c);
		}
		System.out.println("Number of times played: "+z+"\nNumber of 4 matches: "+y+"\nNumber of 3 matches: "+x);
		z.toArray();
		y.toArray();
		x.toArray();
		for (int j = 0; j < n; j++) {
			u+=z[j];
			h+=y[0];
			o+=x[0];
		}
		System.out.println("Number of times played (avg): "+z+"\nNumber of 4 matches (avg): "+y+"\nNumber of 3 matches (avg): "+x);
	}
}