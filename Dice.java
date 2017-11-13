import java.util.Random;
public class Dice {
	public static int rollOnce () {
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
	public static int rollOnce (int a) {
		Random rand = new Random();
		return rand.nextInt(a)+1;
	}
	public static int rollMany (int a) {
		Random rand = new Random();
		int b = 0;
		for (int i = 0; i < a; i++) {
			b+=Dice.rollOnce();
		}
		return b;
	}
	public static int rollMany (int a, int b) {
		Random rand = new Random();
		int c = 0;
		for (int i = 0; i < a; i++) {
			c+=Dice.rollOnce(b);
		}
		return c;
	}
	public static int[] rollManyData (int a) {
			Random rand = new Random();
			int[] b = new int[a];
			for (int i = 0; i < a; i++) b[i]=Dice.rollOnce();
			return b;
	}
	public static int[] rollManyData (int a, int b) {
			Random rand = new Random();
			int[] c = new int[a];
			for (int i = 0; i < a; i++) c[i]=Dice.rollOnce(b);
			return c;
	}
	public static int[] rollMultipleManyData (int a, int b) {
			Random rand = new Random();
			int[] c = new int[a];
			for (int i = 0; i < a; i++) c[i]=Dice.rollMany(b);
			return c;
	}
}