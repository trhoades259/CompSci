class Asort {
	public static int count = 0;
	public static void main (String[] args) {
		System.out.println("Type a phrase: ");
		EasyReader in = new EasyReader();
		String text = in.readLine(), a="abcdefghijklmnopqrstuvwxyz";
		boolean h = false;
		/*for (int n = 0; true;n++) {
					count++;
					if(a.contains(Character.toString(Character.toLowerCase(text.charAt(n))))) {
						s = n;
						break;
					}
		}*/
		for (int n = 0; n < text.length(); n++) {
			while (count < 25) {
				String b = new String (a.substring(n,a.length()));
				System.out.println(b);
				if(!a.contains(Character.toString(Character.toLowerCase(text.charAt(n))))) break;
				if(Character.toLowerCase(text.charAt(n))==a.charAt(count)) {
					System.out.print(a.charAt(count));
					h = true ;
				}
				if (!h || Character.toLowerCase(text.charAt(n))==a.charAt(count)) count++;
				else break ;
			}
		}
		System.out.println();
	}
}
