class Ether {
	public static void main(String[] args) {
		System.out.println("Inital investment: ");
		EasyReader in = new EasyReader() ;
		double A = in.readDouble(), P, Bank=0, Max=0;
		int maxYear = 0;
		System.out.println("Number of years: ");
		int years = in.readInt();
		for(int n=0; n<years; n++) {
			P = growth(A,n);
			A = P/2;
			Bank+=(P/2);
			System.out.println("Year "+(n+1)+": $"+(Math.round(A*100.0)/100.0)+" Ether, $"+(Math.round(Bank*100.0)/100.0)+" Bank");
			if((Bank+A)>Max) {
				Max = (Bank+A);
				maxYear = n+1;
			}

		}
		System.out.println("Total: $"+(Math.round((Bank+A)*100.0)/100.0));
		System.out.println("Max (Year "+maxYear+"): $"+(Math.round((Bank+A)*100.0)/100.0));
	}
	private static double rate(int time) {
		return (9*Math.pow(Math.E,-0.693*time));
	}
	private static double growth(double init, int time) {
		return (init*(1+rate(time)));
	}
}