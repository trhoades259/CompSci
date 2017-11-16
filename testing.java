class testing {
	public static void main(String[] args) {
		System.out.println("print something nibba: ");
		EasyReader in = new EasyReader();
		WordClass a = new WordClass(in.readLine());
		a.setCurrentWord("hi");
		System.out.println(WordClass.howManyOf('h',"hihhhh"));
	}
}