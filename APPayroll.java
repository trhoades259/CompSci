class APPayroll
{
	public static double hours, wage, pay, tpay;
	public static EasyReader in = new EasyReader();
	public static void main (String [] args)
	{
		getWage();
		getHours();
		getPay();
		System.out.println(tpay);
	}
	public static void getWage ()
	{
		System.out.println("Please enter wage:");
		wage = in.readDouble();
	}
	public static void getHours ()
	{
		System.out.println("Please enter amount of hours:");
		hours = in.readDouble();
	}
	public static void getPay ()
	{
		double ohours, opay;
		if(hours > 40) {
			pay = wage*40;
			ohours = hours-40;
			opay = 1.5*ohours*wage;
		}
		else {
			pay = wage*hours;
			opay=0;
		}
		tpay = opay + pay;
	}
}



