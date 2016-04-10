package CODECHEF.PRACTICE.EASY.src;

class NUMGAME2 {
	
	
	public static void main(String[] args) throws java.lang.Exception {
// TODO code application logic here
		java.io.BufferedReader reader = new java.io.BufferedReader(
				new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
//String[] params;
		while (t-- > 0) {
//params = reader.readLine().split(" ");
			int n = Integer.parseInt(reader.readLine());
			if (n % 4 == 1) {
				System.out.println("ALICE");
			} else {
				System.out.println("BOB");
			}
		}
		
	}
}