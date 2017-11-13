import java.util.*;

public class Fraction {

	//Constructors
	public Fraction() {
		fracDenom=1;
		fracNum=0;
	}
	public Fraction(String frac){
		for (int n = 0; n < frac.length(); n++) {
			if(frac.charAt(n)=='/') {
				fracNum=Integer.parseInt(frac.substring(0,n));
				fracDenom=Integer.parseInt(frac.substring(n+1));
				break;
			}
		}
	}

	//Functions
	public int gcf() {
		return gcf(Math.abs(fracNum),Math.abs(fracDenom));
	}
	public int gcf(int num, int den) {
		if (num == 0) return den;
		if (den == 0) return num;
		int re;
		while (den > 0) {
			 re = num % den;
			 num = den;
			 den = re;
		}
		return num;
	}
	public int lcd(Fraction frac) {
		return fracDenom * (frac.showDenom() / gcf(fracDenom, frac.showDenom()));
	}
	public Fraction reduce() {
		int gcf = gcf();
		fracNum/=gcf;
		fracDenom/=gcf;
		return (new Fraction(showFrac()));
	}
	public Fraction multFrac(Fraction frac) {
		return (new Fraction(new String(fracNum*frac.showNum()+"/"+fracDenom*frac.showDenom())));
	}
	public Fraction divideFrac(Fraction frac) {
		if(frac.showNum()==0) {
			System.out.println("Divide by 0 error");
			return this;
		}
		return (new Fraction(new String(fracNum*frac.showDenom()+"/"+fracDenom*frac.showNum())));
	}
	public static String mixedFrac(Fraction frac) {
		if(frac.showNum()>=frac.showDenom()) {
			int whole = frac.showNum()/frac.showDenom();
			if((double)(whole)>frac.showNum()/frac.showDenom()) whole--;
			return (new String(whole+" "+(frac.showNum()-(whole*frac.showDenom()))+"/"+frac.showDenom()));
		}
		else return (frac.showFrac());
	}
	public Fraction addFrac(Fraction frac) {
		return (new Fraction(new String((fracNum*(lcd(frac)/fracDenom)+(frac.showNum()*(lcd(frac)/frac.showDenom())))+"/"+lcd(frac))));
	}
	public Fraction subtractFrac(Fraction frac) {
		return (new Fraction(new String((fracNum*(lcd(frac)/fracDenom)-(frac.showNum()*(lcd(frac)/frac.showDenom())))+"/"+lcd(frac))));
	}
	public boolean equalFrac(Fraction frac) {
		reduce();
		frac.reduce();
		if(frac.showFrac().equals(showFrac())) return true ;
		return false;
	}
	public boolean isLessThanFrac(Fraction frac) {
		double f1 = 1.0*fracNum/fracDenom, f2 = 1.0*frac.showNum()/frac.showDenom();
		if(f1<f2) return true;
		return false;
	}
	public boolean isGreaterThanFrac(Fraction frac) {
		double f1 = 1.0*fracNum/fracDenom, f2 = 1.0*frac.showNum()/frac.showDenom();
		if(f1>f2) return true;
		return false;
	}
	public String showFrac() {
			return (new String(fracNum+"/"+fracDenom));
	}

	//Accessors
	public void setFrac(String frac) {
		for (int n = 0; n < frac.length(); n++) {
			if(frac.charAt(n)=='/') {
				fracNum=Integer.parseInt(frac.substring(0,n));
				fracDenom=Integer.parseInt(frac.substring(n+1));
				break;
			}
		}
	}
	public void setNum(int num) {
		fracNum=num;
	}
	public void setDenom(int den) {
		fracDenom=den;
	}
	public int showDenom() {
		return fracDenom;
	}
	public int showNum() {
		return fracNum;
	}
	public Fraction copyFrac(Fraction frac) {
		return (new Fraction(frac.showFrac()));
	}
	public void clearFrac() {
		fracDenom=1;
		fracNum=0;
	}

	//Variables
	private  int fracDenom, fracNum;
}