import java.util.*;

class testing {
	public static void main(String[] args) {
		/*System.out.println("print something nibba: ");
		EasyReader in = new EasyReader();
		WordClass a = new WordClass(in.readLine());
		a.setCurrentWord("hi");
		System.out.println(WordClass.howManyOf('h',"hihvsfdv ,svmd hhh"));*/
		/*EasyReader in = new EasyReader();
		String[] a = new String[in.readInt()+1];
		for(int n=0; n<a.length; n++) a[n]=in.readLine();
		Arrays.sort(a);
		for(int n=0; n<a.length; n++) System.out.print(a[n]+"\t");*/
		WordClass a = new WordClass("thisisatest.txt");
		String[] b = a.returnCurrentLibrary();
		for(int n=0; n<b.length; n++) System.out.println(b[n]);
	}
}