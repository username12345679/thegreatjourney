public class MakeReverseTriangle {
	public static void main(String[] args) {
		boolean counter = true;
		String stringtest = "";
		int int1 = 5;
		while(counter) {
			for(int i = int1; i > 0; i--){
				stringtest = stringtest + "X";
			}
			System.out.println(stringtest);
			int1 = int1 - 1;
			stringtest = "";
			if (int1 == 5){
				counter = false;
			}
			if (int1 == 0){
				System.out.println("Here is HERE11111");
				counter = false;
			}

		}
	}
}