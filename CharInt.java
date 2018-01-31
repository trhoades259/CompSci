class CharInt {
	private boolean bln=false;

		private int intgr = 0;
		private char chr='a';
		private String alpha = "abcdefghijklmnopqrstuvwxyz";

		CharInt() {}

		CharInt(char in, int num){
			chr = in;
			intgr = num;
		}
		CharInt(int in, int num){
			chr = alpha.charAt(in-1);
			intgr = num;
		}

		public void setNum(int num) {
			intgr = num;
		}
		public void changeChar(char in) {
			chr = in;
		}
		public void changeChar(int in) {
			chr = alpha.charAt(in-1);
		}
		public char getChar() {
			return chr;
		}
}
