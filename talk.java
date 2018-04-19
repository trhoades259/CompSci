class talk {
	public static void main(String[] args) {
		EasyReader in = new EasyReader();
		String ln;
		int[] hit;
		String alpha = "abcdefghijklmnopqrstuvwxyz";

		while(true) {

			hit = new int[26];
			ln = in.readLine();

			String temp = "";
			char tmp;
			for(int i=0; i<ln.length(); i++) {
				tmp = ln.charAt(i);
				if(Character.isLetter(tmp)) temp+=Character.toString(Character.toLowerCase(tmp));
			}
			ln=temp;

			for(int i=0; i<26; i++) {
				for(int n=0; n<ln.length(); n++) {
					if(ln.charAt(n)==alpha.charAt(i)) hit[i]++;
				}
			}

			temp = "";
			for(int i=ln.length()-1; i>=0; i--) {
				temp+=Character.toString(ln.charAt(i));
			}

			if(ln.substring(0,ln.length()/2).equals(ln.substring(ln.length()/2))) System.out.println("no");
			else if(temp.equals(ln)) System.out.println("no");
			else {
				for(int i=0; i<26; i++) {
					if(hit[i]!=0 && hit[i]!=2) {
						System.out.println("no");
						break;
					}
					if(i==25) {
						System.out.println("yes");
					}
				}
			}
		}

	}
}