import java.util.*;

class MakeDic {
	public static void main(String[] args) {
		System.out.println("File: ");
		EasyReader in = new EasyReader();
		String fileName = in.readLine();

		//WordClass.cleanFile(fileName);
		EasyReader read = new EasyReader(fileName);
				ArrayList<String> words = new ArrayList<String>(), hold = new ArrayList<String>();
				while(!read.eof()) words.add(read.readWord());
		for(int n=0; n<words.size(); n++) System.out.println(words.get(n));
	}
}