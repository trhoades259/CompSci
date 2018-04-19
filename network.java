class network {
	public static void main(String[] args) {
		EasyReader file = new EasyReader("network.txt");

			node[] nodes = new node[file.readInt()];
			String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for(int i=0; i<nodes.length; i++) {
				nodes[i].chr = alpha.charAt(i);
			}

		char hold;
		while(!file.eof()) {
			hold = file.readWord().charAt(0);

		}
	}
}

