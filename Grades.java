class Grades {
	public static void main (String[] args) {
		int[] a = new int[5];
		int s = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("Please enter grade "+(i+1)+": ");
			a[i] = getInt();
			s = s+a[i];
		}
		double avg = ((double) (s))/5;
		System.out.println("Class average: "+avg+" ("+letter(avg)+")\nOrdered grades: ");
		for(int l = 100; l > 1; l--) {
			for(int n = 0; n < 5; n++) {
				if (a[n]==l) System.out.print(a[n]+" ("+letter(a[n])+")\n");
			}
		}
	}
	public static int getInt () {
			EasyReader in = new EasyReader();
			int t = in.readInt();
			return t;
	}
	public static char letter (double g) {
		if (g >= 90) return 'A';
		if (g >= 80 && g < 90) return 'B';
		if (g >= 70 && g < 80) return 'C';
		if (g >= 60 && g < 70) return 'D';
		else return 'F';
	}
}