import java.util.*;
class Powerball {
	public static void main (String [] args) {
		Set<Integer> i = new HashSet<Integer>(), t = new HashSet<Integer>(), p = new HashSet<Integer>();
		int e,m,v,c=0,d=0,f=0;
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
			if (m==5 || m==4 || m==3) System.out.println(f+": "+p);
			if (m==5) break;
			else if (m==4) d++;
			else if (m==3) c++;
			p.clear();
		}
		System.out.println("Number of times played: "+f+"\nNumber of 4 matches: "+d+"\nNumber of 3 matches: "+c);
	}
}