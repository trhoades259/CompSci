class Codegolf2 {
	public static void main (String[] args) {
		int c = 0, t = 0, w=0;
		System.out.println("Type a phrase: ");
		EasyReader in = new EasyReader();
		String text = in.readLine(), a="abcdefghijklmnopqrstuvwxyz";
		while (true) {
			String b = new String (text.substring(t,text.length()));
			int p = 26;
			for (int i = 0; i < b.length(); i++) {
				for (int n = c; n < a.length(); n++) {
					if (!a.contains(Character.toString(Character.toLowerCase(text.charAt(i))))) break;
					if (Character.toLowerCase(b.charAt(i))==a.charAt(n) && n < p) {
						p = n;
						w=i+(text.length()-b.length());
						if (text.length()==b.length()) break;
					}
				}
				if (text.length()==b.length()) break;
			}
			c = p;
			t=w;
			if (p==26 || b.length()==0) break;
			System.out.print(a.charAt(c));
			c++;
			t++;
		}
		System.out.println();
	}
}