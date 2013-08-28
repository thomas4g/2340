public class StringFun {
	public static void main(String[] blarghs) {
		String myCode = "helloworldthisisjava";
		char separator = ' ';
		String decoded = myCode.substring(0, 1).toUpperCase()
						+ myCode.substring(1 ,5)
						+ separator
						+ myCode.substring(5, 10)
						+ separator 
						+ myCode.substring(10, 14)
						+ separator
						+ myCode.substring(14, 16)
						+ separator
						+ myCode.substring(16);

		System.out.println(decoded);

		System.out.println(-7 % 5);
	}
}