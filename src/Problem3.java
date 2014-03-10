public class Problem3 {
	
	public static String findPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		
		if (s.length() <= 1) {
			return s;
		}
		
		int maximumLength = 0;
		
		int[][] table = new int[s.length()][s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			table[i][i] = 1;
		}
		
		String longestSubString = "";
		
		for (int i = 0; i <= s.length() - 2; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = 1;
				longestSubString = s.substring(i, i + 2);
			}
		}
		
		for (int l = 3; l <= s.length(); l++) {
			for (int i = 0; i <= s.length() - l; i++) {
				int j = i + l - 1;
				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if (table[i][j] == 1 && l > maximumLength) {
						longestSubString = s.substring(i, j + 1);
					}
				} else {
					table[i][j] = 0;
				}
			}
		}
		
		return longestSubString;
	}
	
}
