class SpankBank {
	public static void main (String[] args) {

		EasyReader in = new EasyReader();
		while (true) {
			System.out.println("Are you a new user? (Yes/No)");
			String text = in.readLine(), i="", a="yesno";
			for (int n = 0; n < text.length(); n++) {
				if(a.contains(Character.toString(Character.toLowerCase(text.charAt(n))))) i += Character.toLowerCase(text.charAt(n));
			}
			System.out.println(i);
			if (i.equals("yes") || i.equals("no")) break;
		}
		if (i.equals("yes")) {
			System.out.println();
		}

	}
}