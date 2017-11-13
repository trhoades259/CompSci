class DiceTest {
	public static void main (String[] args) {
		int [] b = Dice.rollMultipleManyData(3, 2);
		for (int n = 0; n < 2; n++) System.out.println(b[n]);
	}
}