class HistoPicture {
	public static void main(String[] args) {
		EasyReader in = new EasyReader("imageFile.txt");
		int charCount = 0, space, chars, hold=0;
		while(!in.eof()) {
			if(hold==0) space =  in.readInt();
			else space = hold;
			charCount+=space;
			Histogram.printSpace(space);
			chars = in.readInt();
			charCount+=chars;
			Histogram.printStar(chars);
			hold = in.readInt();
			if((charCount+hold)>80) {
				System.out.println();
				charCount=0;
			}
		}
		System.out.println();
	}
}