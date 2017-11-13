class BaAPrime
{
	public static void main (String [] args)
	{
		EasyReader in = new EasyReader();

		int num, pbelow = 0, pabove = 0 ;

		System.out.println("Pick a number, any number: ");
		num = in.readInt();
		System.out.println("---------------------------");
		if (!(num==3))
		{
			for (int i = num - 1; i > 1; i--)
						{
							if (pbelow==0)
							{
								for (int ptestb = i-1;ptestb>0;ptestb--)
								{
									if (i%ptestb==0)
									{
										break;
									}
									if (ptestb==2)
									{
										pbelow=i;
										break;
									}
									else
									{
									}
								}
							}
							if (!(pbelow==0))
							{
								break ;
							}
						}
						System.out.println(pbelow);
						System.out.println(num);
						for (int j = num + 1; j > 1; j++)
								{
									if (pabove==0)
									{
										for (int ptesta = j-1;ptesta>0;ptesta--)
										{
											if (j%ptesta==0)
											{
												break;
											}
											if (ptesta==2)
											{
												pabove=j;
												break;
											}
											else
											{
											}
										}
									}
									if (!(pabove==0))
									{
										break ;
									}
						}
			System.out.println(pabove);
		}
		else
		{
			System.out.println("2");
						System.out.println("3");
			System.out.println("5");
		}
	}
}
