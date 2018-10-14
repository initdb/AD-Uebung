package de.fh_rosenheim.algorithmen.lecture03;

public class HanoiRekursion {
	private static final int N = 10;
	static long count = 0;					// count number of moves
	static final String A = "Stab A";
	static final String B = "Stab B";
	static final String C = "Stab C"; 

	public static void hanoi(int n, String from, String via, String to) {

		if (n > 0) {
            hanoi(n-1, from, to, via);
			System.out.println(from + "-->" + to);
			count++;
			hanoi(n-1, via, from, to);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(N, A, B, C);
		System.out.println(count + " Scheibenbewegungen.");
	}
}














