import java.util.*;

public class node {

	char chr;

	ArrayList<Character> connect;

	node() {
		connect = new ArrayList<Character>();
	}

	public void addConnection(char chr) {
		connect.add(chr);
	}
}