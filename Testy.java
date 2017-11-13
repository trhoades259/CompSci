class Testy {
	public static void main (String [] args) {
		EasyReader in = new EasyReader();
		String text = in.readLine();
		for (int n = 0; n < text.length(); n++) {
			System.out.print(Convert.lowercase(text.charAt(n)));
		}
		System.out.println();
	}
}