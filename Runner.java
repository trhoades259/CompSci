import java.util.Random;
class Runner {
	public static void main (String [] args) {
		EasyReader i = new EasyReader();
		System.out.println("Please enter a number: ");
		int c=0,p,m=0,r,t=i.readInt();
		Random a = new Random();
		p = a.nextInt(25);
		for (int n = 1; n < t; n++) {
			r = a.nextInt(25);
			if (r==p) c++;
			else p = r;
			if (c > m) m = c;
		}
		System.out.println(m);
	}
}