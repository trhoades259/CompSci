import java.util.*;

class Enigma {

	public static void main(String[] args) {

		System.out.println("Enter the name of the .txt file you would like to access: ");
		EasyReader in = new EasyReader();
		String fileName = in.readLine();
		EasyReader file = new EasyReader(fileName);

		System.out.println("Would you like to encrypt(E) or decrypt(D)? ");
		boolean decrypt = Character.toLowerCase(in.readChar())=='d';

		ArrayList<Character> elements = new ArrayList<Character>();
		while(!file.eof()) elements.add(file.readChar());
		elements.remove(elements.size()-1);

		int[] charValues = new int[elements.size()];

		boolean[] nonAlpha = new boolean[elements.size()];

		String alpha = "abcdefghijklmnopqrstuvwxyz";

		for(int arrayIndex = 0; arrayIndex < charValues.length; arrayIndex++) {
			if(Character.isLetter(elements.get(arrayIndex))) {
				for(int alphaIndex = 0; alphaIndex < 26; alphaIndex++) {
					if(Character.toLowerCase(elements.get(arrayIndex))==alpha.charAt(alphaIndex)) {
						charValues[arrayIndex]=alphaIndex;
						break;
					}
				}
			}
			else nonAlpha[arrayIndex] = true;
		}

		System.out.println("First key: ");
		int firstKey = in.readInt();
		System.out.println("Second key: ");
		int secondKey = in.readInt();

		Random rand = new Random();

		if(decrypt) {
			for(int arrayIndex = 0; arrayIndex < charValues.length; arrayIndex++) {
				if(arrayIndex%secondKey==0) rand.setSeed(firstKey);
				charValues[arrayIndex]-=rand.nextInt(25);
			}
		}
		else {
			for(int arrayIndex = 0; arrayIndex < charValues.length; arrayIndex++) {
				if(arrayIndex%secondKey==0) rand.setSeed(firstKey);
				charValues[arrayIndex]+=rand.nextInt(25);
			}
		}

		for(int arrayIndex = 0; arrayIndex < charValues.length; arrayIndex++) {

			while(charValues[arrayIndex]<0) charValues[arrayIndex]+=25;

			charValues[arrayIndex]=charValues[arrayIndex]%25;
		}

		EasyWriter out = new EasyWriter(fileName);

		for(int arrayIndex = 0; arrayIndex < charValues.length; arrayIndex++) {
			if(nonAlpha[arrayIndex]) out.print(elements.get(arrayIndex));
			else out.print(alpha.charAt(charValues[arrayIndex]));
		}
		out.close();

		if(decrypt) System.out.print("De");
		else System.out.print("En");
		System.out.println("cryption complete!");
	}
}
