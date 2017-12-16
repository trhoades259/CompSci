public class Bank {

	private double balance;

	public Bank() { balance = 0; }
	public Bank(double bal) { balance = bal; }

	public double showBalance() {
		return (Math.round(balance*100.0)/100.0);
	}
	public void deposit(double dep) {
		balance += dep;
	}
	public void withdraw(double with) {
		if(with > balance) System.out.println("Cannot perform withdrawal, insufficient funds.");
		else balance -= with;
	}
	public void addInterest(int n, double rp, double t) {
		balance = balance*Math.pow(1+((rp/100.0)/n),n*t);
	}
}