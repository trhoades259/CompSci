import java.util.*;

class Alphabet {

	public ArrayList<CharBoolean> alphaBln = new ArrayList<CharBoolean>();
	public ArrayList<CharInt> alphaInt = new ArrayList<CharInt>();

	Alphabet(String in) {
		if(in.equals("boolean")) for(int n=1; n<=26; n++) alphaBln.add(new CharBoolean(n,false));
		else for(int n=1; n<=26; n++) alphaInt.add(new CharInt(n,0));
	}

	public char charAt(int p) {
		return alphaBln.get(p).getChar();
	}
	public void setTrue(int i) {
		alphaBln.set(i,new CharBoolean(charAt(i),true));
	}
	public char[] activeLetters() {
		ArrayList<Character> letters = new ArrayList<Character>();
		for(int n=0; n<alphaBln.size(); n++) if(alphaBln.get(n).getState()) letters.add(charAt(n));
		return letters.toArray(new char[letters.size()]);
	}
}