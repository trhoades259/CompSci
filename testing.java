class testing {
	public static void main(String[] args) {
		System.out.println("print something nibba: ");
		EasyReader in = new EasyReader();
		WordClass a = new WordClass(in.readLine());
		String[] b = a.getLibrary();
		for(int n=0; n < b.length; n++) System.out.println(b[n]);
	}
}