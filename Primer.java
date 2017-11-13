class Primer {
	private static int n = 1;
	public static void main (String[] args) {
		System.out.println("Which prime number would you like to view?: ");
		EasyReader in = new EasyReader();
		boolean h = false ;
		int i = in.readInt();
		for (int c =  0; c < i; c++) {
			h = false;
			while(!h) {
				for (int t = 2; true; t++) {
					if (n<=t || n%t==0) {
						if (n<=t) h = true;
						else if (n%t==0) n++;
						break;
					}
				}
			}
			if(!(c==(i-1))) n++;
		}
		System.out.println(n);
	}
}