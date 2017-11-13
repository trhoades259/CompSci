class HtmlPayroll
{
	public static double hours, wage, pay, tpay;
	public static String name;
	public static EasyReader in = new EasyReader();
	public static void main (String [] args)
	{
		getName();
		getWage();
		getHours();
		getPay();

		EasyWriter HTML = new EasyWriter("payroll.html");
		HTML.print("<html><head></head><body><table><tr><td>"+name+"</tr><tr><td>worked "+hours+" hours</tr><tr><td>at $"+wage+"/hr</tr><tr><td><td>");
		if(hours>40) HTML.print("<font color=#00ff00>");
		else HTML.print("<font color=#FF0000>");
		HTML.print("Grosspay: "+(Math.round(tpay*100.0)/100.0)+"</tr></table></body></html>");
		HTML.close();
	}
	public static void getWage ()
	{
		System.out.println("Please enter wage:");
		wage = in.readDouble();
	}
	public static void getName ()
	{
		System.out.println("Please enter name:");
		name = in.readLine();
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



