import java.util.*;
class FirstHistogram {
	public static void main(String[] args) {
		System.out.println("How many numbers would you like to generate?: ");
		EasyReader in = new EasyReader();
		int[] data = new int[in.readInt()];
		Random rand = new Random();
		for(int n = 0; n < data.length; n++) {
			data[n]=rand.nextInt(25)+1;
			System.out.print(data[n]+"\t");
		}
		System.out.println();
		int count;
		for(int i = 1; i < 26; i++) {
			count=0;
			for(int n = 0; n < data.length; n++) if(data[n]==i) count++;
			System.out.print("Number of "+i+"s ("+count+"):\t");
			for(int n = 0; n < count; n++) System.out.print("*");
			System.out.println();
		}
	}
}