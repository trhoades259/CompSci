import java.util.*;

class BadDice {

	public static void main(String[] args) {

		System.out.println("Number of dice: ");
		EasyReader in = new EasyReader();
		int nod = in.readInt();
		System.out.println("Number of rolls: ");
		int nor = in.readInt();

		Random rand = new Random();
		int[] data = new int[nor];
		int sum;
		for(int n = 0; n < nor; n++) {
			sum = 0;
			for(int i = 0; i < nod; i++) {
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