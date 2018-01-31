class CharBoolean {

	private boolean bln=false;
	private char chr='a';
	private String alpha = "abcdefghijklmnopqrstuvwxyz";

	CharBoolean() {}

	CharBoolean(char in, boolean state){
		chr = in;
		bln = state;
	}

	CharBoolean(int in, boolean state){
		chr = alpha.charAt(in-1);
		bln = state;
	}

	public void isFalse() {
		bln = false;
	}
	public void isTrue() {
		bln = true;
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
	public boolean getState() {
		return bln;
	}
}