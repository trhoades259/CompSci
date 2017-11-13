class ReadFile {
	public static void main (String[] args) {
		EasyReader in = new EasyReader("MeinKampf.txt");
		int g;
		g=in.readInt();
		while (!in.eof()) {
			System.out.println(g);
			g=in.readInt();
		}
	}
}