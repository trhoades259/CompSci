class BankDriver {
	public static void main(String[] args) {
		System.out.println("Starting Deposit: ");
		EasyReader in = new EasyReader();
		Bank bank = new Bank(in.readDouble());
		System.out.println("Balance: "+bank.showBalance());
		System.out.println("Withdrawal: ");
		bank.withdraw(in.readDouble());
		System.out.println("Balance: "+bank.showBalance());
		System.out.println("Withdrawal (overdraw): ");
		bank.withdraw(in.readDouble());
		System.out.println("Balance: "+bank.showBalance());
		System.out.println("Deposit: ");
		bank.deposit(in.readDouble());
		System.out.println("Balance: "+bank.showBalance());
		bank.addInterest(12,5,1);
		System.out.println("With Interest: "+bank.showBalance());
	}
}