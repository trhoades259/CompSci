class yes {
	public static void main(String[] args) {
		Fraction f1 = new Fraction("1/2");
		Fraction f2 = new Fraction("1/3");
		Fraction test = f1.subtractFrac(f2);
		System.out.println(test.showFrac());
	}
}