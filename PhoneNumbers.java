import java.util.*;

class PhoneNumbers {
	public static void main(String[] args) {
		System.out.println("Please enter a phone number: ");
		EasyReader in = new EasyReader();
		String num = in.readLine();

		String temp = "";
		char tmp;
		for(int i=0; i<num.length(); i++) {
			tmp = num.charAt(i);
			if(Character.isDigit(tmp) && tmp!='0' && tmp!='1') temp+=Character.toString(tmp);
		}
		num=temp;

		Map<Character,List<String>> npad = new HashMap();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		for(int i=2; i<=9; i++) {
			npad.put(Integer.toString);
		}
	}
}