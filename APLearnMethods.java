class APLearnMethods
{
	public static void main (String [] args)
	{
		int a=12, b=8;
		double c=0.0;
		System.out.println("This is before the method call: ");
		addSeven(a);
		System.out.println("This is the value of a: "+a);

		b=addSeven(a,0);
		System.out.println(b);

		c=addSeven(c);
	}
	public static int addSeven(int g, int h)
	{
		g+=7;
		return g;
	}
	public static double addSeven(double g)
	{
		g+=7.0;
		System.out.println(g);
		return g;
	}
	public static void addSeven(int g)
	{
		g+=7;
		System.out.println(g);
	}
}