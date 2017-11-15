class Book {
	public static void main(String[] args) {
		System.out.println("Number of pages: ");
		EasyReader in = new EasyReader();
		int pages = in.readInt(), sheets=pages/4, printNum=2;
		if(pages%4!=0) sheets++;
		int blanks = sheets*4-pages;
		pages+=blanks;
		int left=pages, right=1;
		System.out.print("Sheet 1 A: back cover\tfront cover\nSheet 1 B: blank\tblank\n");
		while(Math.abs(left-right)>1) {
			System.out.print("Sheet "+printNum+" A: ");
			if(blanks==3 && printNum==3) System.out.print("blank\t");
			else if(blanks>0 && printNum==2) System.out.print("blank\t");
			else System.out.print(left+"\t\t");
			System.out.print(right+"\n");
			left--;
			right++;
			System.out.print("Sheet "+printNum+" B: ");
			System.out.print(right+"\t\t");
			if(blanks>1 && printNum==2) System.out.print("blank\n");
			else System.out.print(left+"\n");
			left--;
			right++;
			printNum++;
		}
	}
}