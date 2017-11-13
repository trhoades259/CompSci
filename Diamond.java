class Diamond {
	public static void main (String [] args){
		EasyReader in = new EasyReader();
		System.out.println("Please anter text you want to turn into a diomand:");
		String diamondText = in.readLine() ;
		boolean halfway ;
		for (int counter=0;counter<diamondText.length();counter=counter+2) {
			int secChar =
			System.out.println(diamondText.charAt((diamondText.length())-counter/2));
			System.out.println(diamondText.charAt((diamondText.length())+secChar));
		}

	}
}