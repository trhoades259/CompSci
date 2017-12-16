import java.util.Random;
public class Dice {

	private static Random rand = new Random();

	public static int rollOnce () {
		return rollOnce(6);
	}
	public static int rollOnce (int a) {
		return rand.nextInt(a)+1;
	}
	public static int rollMany (int a) {
		return rollMany(a,6);
	}
	public static int rollMany (int a, int b) {
		int c = 0;
		for (int i = 0; i < a; i++) c+=Dice.rollOnce(b);
		return c;
	}
	public static int[] manyRolls (int a) {
			return manyRolls(a,6);
	}
	public static int[] manyRolls (int a, int b) {
			int[] c = new int[a];
			for (int i = 0; i < a; i++) c[i]=Dice.rollOnce(b);
			return c;
	}
	public static int[] manyRollsManyDice (int a, int b) {
		return manyRollsManyDice(a,b,6);
	}
	public static int[] manyRollsManyDice (int a, int b, int c) {
			int[] d = new int[a];
			for (int i = 0; i < a; i++) d[i]=Dice.rollMany(b,c);
			return d;
	}
}