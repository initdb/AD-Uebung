package de.fh_rosenheim.algorithmen.lecture03;

import java.util.Stack;

class HanoiTask {
	public int n;
	public String from, to, via;

	HanoiTask(int n, String from, String to, String via) {
		this.n = n; this.from = from; this.to = to; this.via = via;
	}

}

public class HanoiIteration {
	private static final int N = 10;
	static long count = 0;					// count number of moves
	static final String A = "Stab A";
	static final String B = "Stab B";
	static final String C = "Stab C"; 

		
	public static void main(String[] args) {
		Stack<HanoiTask> s = new Stack<HanoiTask>();
		s.push(new HanoiTask(N, A, C, B));
		while (!s.empty()) {
			HanoiTask task = s.pop();
			if (task.n == 1) {
				System.out.println(task.from + " --> " + task.to);
				count++;
			}
			else {
				s.push(new HanoiTask(task.n - 1, task.via, task.to, task.from));
				s.push(new HanoiTask(1, task.from, task.to, ""));
				s.push(new HanoiTask(task.n - 1, task.from, task.via, task.to));
			}
		}
		System.out.println(count + " Scheibenbewegungen.");
	}
}
