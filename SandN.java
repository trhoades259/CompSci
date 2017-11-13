class SandN {
	public static void main (String [] args) {
		int c=0;
		for (int i = 0; i < 1000000; i++) {
			String t = Integer.toString(i);
			if (t.contains("7") && t.contains("9")) {
				//System.out.println(i);
				c++;
			}
		}
		System.out.println("Number of values including 7 and 9: "+c);
	}
}