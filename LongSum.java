import java.util.*;
class LongSum {
	public static void main(String[] args) {
		System.out.println("File name (with suffix): ");
		EasyReader l = new EasyReader(), in = new EasyReader(l.readLine());
		System.out.println("Span of Numbers?: ");
		int i=0,t=0,g=0,s=l.readInt();
		ArrayList<Integer> n = new ArrayList<Integer>(), a = new ArrayList<Integer>(), b = new ArrayList<Integer>();
		for (;!in.eof()&&i<500; i++) n.add(in.readInt());
		for (int o=s-1; o < 500; o++) {
			for (int y = 0; y < s; y++) t+=n.get(o-y);
			if(t>g) {
				g=t;
				a.clear();
				b.clear();
				for (int m = 0; m < s; m++) a.add(o-(s-2)+m);
				for (int v = 0; v < s; v++) b.add(n.get(o-(s-1)+v));
			}
			t=0;
		}
		System.out.println("Largest Sum Over Span "+s+": "+g);
		for(int u = 0; u < s; u++) System.out.println(a.get(u)+": "+b.get(u));
	}
}