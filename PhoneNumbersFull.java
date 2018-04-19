import java.util.*;

class PhoneNumbersFull {

	public static void main(String[] args) {
		Map<Character,ArrayList<Character>> npad = new HashMap();
		ArrayList<Character> curr;
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int alphaIndex=0, cap;
		for(int i=2; i<=9; i++) {
			curr = new ArrayList<Character>();
			cap = 3;
			if(i==7 || i==9) cap++;
			for(int a=0; a<cap; a++, alphaIndex++) curr.add(alpha.charAt(alphaIndex));
			npad.put((char) (i+48), newList(curr));
		}

		System.out.println("Please enter a phone number: ");
		EasyReader in = new EasyReader();
		String num = in.readLine();

		ArrayList<String> nums = new ArrayList<String>();
		int b=-1;
		char tmp;
		for(int i=0; i<num.length(); i++) {
			tmp = num.charAt(i);
			if(tmp=='0' || tmp=='1') {
				if((i-b)>2) nums.add(num.substring(b+1,i));
				b=i;
			}
			if(i==(num.length()-1) && (i-b)>1) nums.add(num.substring(b+1));
		}

		ArrayList<ArrayList<ArrayList<Character>>> letters = new ArrayList<ArrayList<ArrayList<Character>>>();
		ArrayList<ArrayList<Character>> sub;
		String temp = "";
		for(int n=0; n<nums.size(); n++) {
			temp = nums.get(n);
			b = temp.length();
			sub = new ArrayList<ArrayList<Character>>();
			for(int i=0; i<b; i++) sub.add(npad.get(temp.charAt(i)));
			letters.add(sub);
		}

		temp = "";
		for(int i=0; i<num.length(); i++) {
			tmp = num.charAt(i);
			if(tmp!='0' && tmp!='1') temp+=Character.toString(tmp);
		}
		num=temp;
		sub = new ArrayList<ArrayList<Character>>();
		for(int i=0; i<num.length(); i++) sub.add(npad.get(num.charAt(i)));
		int ltrCombos = 1;
		for(int i=0; i<sub.size(); i++) ltrCombos*=(sub.get(i).size());
		System.out.println("\nNumber of possible letter combinations: "+ltrCombos);

		/*
		ArrayList<String> matches = new ArrayList<String>(), words;
		EasyReader dictFile;
		String check, mod;
		for(int y=0; y<letters.size(); y++) {
			for(int t=2; t<=size; t++) {
				dictFile = new EasyReader("BigDict.txt");
				words = new ArrayList<String>();
				while(!dictFile.eof()) {
					check = dictFile.readLine();
					if(check.length()==t) words.add(check);
					if(check.length()>t) break;
				}

				int l;
				boolean fail;
				for(int s=0; s+t<=size; s++) {
					for(int w=0; w<words.size(); w++) {
						fail = false;
						temp = words.get(w);
						for(int i=s; i<t+s; i++) {
							curr = letters.get(i);
							l = curr.size();
							tmp = temp.charAt(i-s);
							for(int c=0; c<l; c++) {
								if(curr.get(c)==tmp) break;
								if(c==(l-1)) fail = true;
							}
							if(fail) continue;
							if(i==(t+s-1)) {
								mod = "";
								if(s>0) mod+=(num.substring(0,s)+"-");
								mod+=temp;
								if((s+t)!=size) mod+=("-"+num.substring(s+t));
								matches.add(mod);
							}
						}
					}
				}
			}
		}
		System.out.println();
		if(matches.size()==0) System.out.println("Sorry, no words found.");
		else {
			System.out.println("Possible words: ");
			for(String s: matches) System.out.println(s);
		}
		System.out.println();
		*/
	}

	public static ArrayList<Character> newList(ArrayList<Character> list) {
		ArrayList<Character> ret = new ArrayList<Character>();
		for(Character c: list) ret.add(c);
		return ret;
	}
}