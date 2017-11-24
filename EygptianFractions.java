class EygptianFractions {
	public static void main(String[] args) {
		System.out.println("Gimmme a Fraction (n/d format): ");
		EasyReader in = new EasyReader();
		Fraction frac = new Fraction(in.readLine());
		int n=1;
		System.out.print(frac.showFrac()+" = ");
		while(frac.showNum()!=0) {
			n++;
			Fraction compare = new Fraction("1/"+n);
			if(compare.isGreaterThanFrac(frac)) continue;
			frac = frac.subtractFrac(compare);
			if(n>2) System.out.print(" + ");
			System.out.print(compare.showFrac());
		}
		System.out.println();
	}
}