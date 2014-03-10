import java.util.HashMap;

public class Problem1 {
	
	public static void main(String[] args) {
		longestAscendingSubsequence("dcba");
	}
	
	public static int longestAscendingSubsequence(String unorderedInput) {
		String orderedInput = mergeSort(unorderedInput);
		return longestCommonSubsequence(unorderedInput, orderedInput);
	}
	
	public static String mergeSort(String unorderedInput) {
		int[] chars = new int[unorderedInput.length()];
		
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 0; i < chars.length; i++) {
			chars[i] = Character.getNumericValue(unorderedInput.charAt(i));
			map.put(chars[i], unorderedInput.charAt(i));
		}
		
		int[] sorted = mergeSort(chars);
		
		String s = "";
		
		for (int i = 0; i < sorted.length; i++) {
			s += map.get(sorted[i]);
		}
		
		return s;
	}
	
	private static int[] mergeSort(int[] list) {
		if (list.length <= 1) {
			return list;
		}
		
		int[] left = new int[list.length / 2];
		int[] right = new int[list.length - left.length];
		
		System.arraycopy(list, 0, left, 0, left.length);
		System.arraycopy(list, left.length, right, 0, right.length);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left, right, list);
		
		return list;
	}
	
	private static void merge(int[] left, int[] right, int[] result) {
		int leftIndex = 0;
		int rightIndex = 0;
		
		int j = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] < right[rightIndex]) {
				result[j] = left[leftIndex];
				leftIndex++;
			} else {
				result[j] = right[rightIndex];
				rightIndex++;
			}
			j++;
		}
		
		System.arraycopy(left, leftIndex, result, j, left.length - leftIndex);
		System.arraycopy(right, rightIndex, result, j, right.length - rightIndex);
	}
	
	public static int longestCommonSubsequence(String S1, String S2) {
		/*
		//TrackList is used to track the subsequence. 
		//TrackList[i][j]=1 represents F[i][j] comes from F[i-1][j-1]. 
		//TrackList[i][j]=2 represents F[i][j] comes from F[i-1][j]. 
		//TrackList[i][j]=3 represents F[i][j] comes from F[i][j-1]. 
		int[][] TrackList = new int[S1.length() / 2 + 1][S2.length() / 2 + 1];
		for (int i = 0; i <= S1.length() / 2; i++) {
			for (int j = 0; j <= S2.length() / 2; j++) {
				//	TrackList[i][j] = -1;
			}
		}
		//F is used to store the intermediate results.  int[][] F = new int[S1.length() / 2 + 1][S2.length() / 2 + 1]; 
		for (int i = 0; i <= S1.length() / 2; i++) {
			for (int j = 0; j <= S2.length() / 2; j++) {
				//	F[i][j] = -1;
			}
		}
		//add your code here. 
		//return the length of the subsequence and print out the longest common 
		//subsequence.
		return 0;
		*/
		return 0;
	}
}
