import java.util.*;
import java.io.*;

public class TF {
	static int ans;
	// The given card hand.
	static int[] hand = new int[4];
	// The generated permutation of the card hand.
	static List<Integer> handPermutation = new ArrayList<>();
	// Whether a given card is present 
	static boolean[] chosen = new boolean[4];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int num_hands = Integer.parseInt(br.readLine());
		for (int h = 0; h < num_hands; h++) {
			 ans = Integer.MIN_VALUE;
			for (int i = 0; i < 4; i++) {
				hand[i] = Integer.parseInt(br.readLine());
				}
			generateHandPermutation();
			pw.println(ans);
		}
		pw.close();
	}
	// Function that takes in two numbers and an operation and returns the result.
	public static int operation(int op, int num1, int num2) {
		switch (op) {
		case 0:
			return num1 + num2;
		case 1:
			return num1 - num2;
		case 2:
			return num1 * num2;
		case 3: {
			// The divisor cannot be 0 and the quotient must be an integer.
			if (num2 == 0 || num1 % num2 != 0) { return Integer.MIN_VALUE; }
			return num1 / num2;
		}
		}
		return Integer.MIN_VALUE;
	}
	// Function that generates all possible permutations .
	public static void generateHandPermutation() {
		if (handPermutation.size() == 4) {
			// We have generated a permutation, so we can try placing the operators.
			// Case 1: ((( ) ) )
			for (int op1 = 0; op1 < 4; op1++) {
				for (int op2 = 0; op2 < 4; op2++) {
					for (int op3 = 0; op3 < 4; op3++) {
						int first = operation(op1, handPermutation.get(0),handPermutation.get(1));
						// If the operation is invalid, continue;
						if (first == Integer.MIN_VALUE) {
							continue; 
							}
						int second = operation(op2, first, handPermutation.get(2));
						// If the operation is invalid, continue;
						if (second == Integer.MIN_VALUE) { 
							continue;
							}
						int third = operation(op3, second, handPermutation.get(3));
						// If the operation is invalid, continue;
						if (third == Integer.MIN_VALUE) {
							continue;
							}
						if (third <= 24) { ans = Math.max(ans, third); }
					}
				}
			}
			// Case 2: (( ) ( ))
			for (int op1 = 0; op1 < 4; op1++) {
				for (int op2 = 0; op2 < 4; op2++) {
					for (int op3 = 0; op3 < 4; op3++) {
						int first = operation(op1, handPermutation.get(0),handPermutation.get(1));
						if (first == Integer.MIN_VALUE) { 
							continue; 
							}
						int second = operation(op2, handPermutation.get(2), handPermutation.get(3));
						if (second == Integer.MIN_VALUE) { 
							continue;
							}
						int third = operation(op3, first, second);
						if (third == Integer.MIN_VALUE) {
							continue;
							}
						if (third <= 24) {
							ans = Math.max(ans, third); 
							}
					}
				}
			}
		} else {
			// Otherwise, we continue to build our permutation array.
			for (int i = 0; i < 4; i++) {
				if (chosen[i]) {
					continue;
				}
				chosen[i] = true;
				handPermutation.add(hand[i]);
				generateHandPermutation();
				chosen[i] = false;
				handPermutation.remove(handPermutation.size() - 1);
			}
		}
	}
}