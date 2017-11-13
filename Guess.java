import java.util.Random;
class Guess {
	public static int g ;
	public static void main (String[] args) {
		System.out.println("Guess a number from 0 to : (Please enter a number)");
		int l = getInt();
		System.out.println("How many guesses would you like to allow?");
		int c = getInt();
		System.out.println("I'm ready.");
		int r = random(l);
		for (int i = 1; i <= c; i++) {
			System.out.println("What is your guess?");
			g = getInt();
			if (equals(g,r)) {
				System.out.println("You win! ");
				break;
			}
			else if (g > r) System.out.println("You need to guess lower!");
			else System.out.println("You need to guess higher!");
			System.out.println("You have "+guessCount(c,i)+" guesses left");
		}
		if (!equals(g,r)) System.out.print("You lose. ");
		System.out.print("The number was: "+r+"\n");
	}
	public static String guessCount (int a, int b) {
		int guess = a-b;
		String gc = Integer.toString(guess);
		return gc;
	}
	public static int random (int l) {
		Random rand = new Random();
		int r = rand.nextInt(l) + 1;
		return r;
	}
	public static int getInt () {
		EasyReader in = new EasyReader();
		int t = in.readInt();
		return t;
	}
	public static boolean equals (int a, int b) {
		if (a == b) return true;
		else return false;
	}
}