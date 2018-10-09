//package de.fh_rosenheim.algorithmen.lecture02;

public class HanoiRekursion {
	private static final int N = 3;
	static long count = 0;					// count number of moves
	static final String A = "Stab A";
	static final String B = "Stab B";
	static final String C = "Stab C"; 

	public static void hanoi(int n, String from, String to, String via) {

		if (n > 0) {
            hanoi(n-1, from, via, to);
			System.out.println(from + "-->" + to);
			count++;
			hanoi(n-1, via, to, from);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(N, A, C, B);
		System.out.println(count + " Scheibenbewegungen.");
	}
}
















/*
	hanoi(n - 1, from, via, to);
			System.out.println(from + " --> " + to);
					count++;
					hanoi(n - 1, via, to, from);
					*/