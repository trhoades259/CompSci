import java.util.*;

class DiceDriver {
	public static void main(String[] args) {
		System.out.println("a single roll of one 6 sided die: "+Dice.rollOnce());
		System.out.println("number of sides: ");
		EasyReader in = new EasyReader();
		int sides = in.readInt();
		System.out.println("one roll of an n sided die: "+Dice.rollOnce(sides));
		System.out.println("number of dice: ");
		int num = in.readInt();
		System.out.println("one roll of n dice: "+Dice.rollMany(num));
		System.out.println("one roll of n dice with x sides: "+Dice.rollMany(num,sides));
		System.out.println("number of rolls: ");
		int rolls = in.readInt();
		System.out.println("an array of n rolls with a 6 sided die: "+Arrays.toString(Dice.manyRolls(rolls)));
		System.out.println("an array of n rolls with an x sided die: "+Arrays.toString(Dice.manyRolls(rolls,sides)));
		System.out.println("an array of n rolls with y dice having 6 sides: "+Arrays.toString(Dice.manyRollsManyDice(rolls,num)));
		System.out.println("an array of n rolls with y dice having x sides: "+Arrays.toString(Dice.manyRollsManyDice(rolls,num,sides)));

		Random rand = new Random();
		int[] data = new int[rolls];
		int sum;
		for(int n = 0; n < rolls; n++) {
			sum = 0;
			for(int i = 0; i < num; i++) {
			sum += rand.nextInt(6)+1;
			}
			data[n]=sum;
			System.out.print(data[n]+"\t");
		}
		System.out.println();

		int[] amm = Histogram.extrema(data);
		int mid = Math.round((amm[0]+amm[1])/2);
		if(amm[0]+mid<amm[1]-mid) mid++;
		int c1, c2;
		int[] sc = new int[amm[1]-mid];
		for(int n = 0; n < sc.length; n++) sc[n]=n+mid+1;
		int max=0;
		for(int n = amm[0]; n <= amm[1]; n++) if(Histogram.count(data,n)>max) max= Histogram.count(data,n);
		for(int n = amm[0]; n <= mid; n++) {
			c1=Histogram.count(data,n);
			System.out.print("Number of "+n+"s ("+c1+"):\t");
			Histogram.printStar(c1);
			Histogram.printSpace(max-c1);
			if(n-amm[0]<sc.length) {
				c2=Histogram.count(data,sc[n-amm[0]]);
				System.out.print("\tNumber of "+sc[n-amm[0]]+"s ("+c2+"):\t");
				Histogram.printStar(c2);
			}
			System.out.println();
		}
	}
}