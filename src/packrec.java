/*
ID: czpcxfz1
LANG: JAVA
TASK: packrec
 */
import java.io.*;
import java.util.*;

public class packrec {
	public static int[][] rec = new int[4][2], ans = new int[1000][2],
			set = new int[4][2];
	public static boolean[] vis = new boolean[4];
	public static int n = 0, best = 10000000, t;

	public static void check(int a, int b) {
		if (a * b <= best) {
			if (a * b < best) {
				n = 0;
				best = a * b;
				if (best == 36) {
					System.out.println(t);
					for (int i = 0; i < 4; ++i) {
						System.out.println(set[i][0] + " " + set[i][1]);
					}
				}
			}
			ans[n][0] = Math.min(a, b);
			ans[n][1] = Math.max(a, b);
			++n;
		}
	}

	public static void dfs(int now) {
		int a, b;
		if (now == 4) {
			a = set[0][0] + set[1][0] + set[2][0] + set[3][0];
			b = Math.max(Math.max(Math.max(set[0][1], set[1][1]), set[2][1]),
					set[3][1]);
			t = 1;
			check(a, b);
			a = Math.max(set[0][0] + set[1][0] + set[2][0], set[3][0]);
			b = Math.max(Math.max(set[0][1], set[1][1]), set[2][1]) + set[3][1];
			t = 2;
			check(a, b);
			a = Math.max(set[0][0] + set[1][0], set[2][0]) + set[3][0];
			b = Math.max(Math.max(set[0][1], set[1][1]) + set[2][1], set[3][1]);
			t = 3;
			check(a, b);
			a = set[0][0] + Math.max(set[1][0], set[2][0]) + set[3][0];
			b = Math.max(Math.max(set[0][1], set[1][1] + set[2][1]), set[3][1]);
			t = 4;
			check(a, b);
			a = Math.max(set[0][0], set[1][0]) + set[2][0] + set[3][0];
			b = Math.max(set[0][1] + set[1][1], Math.max(set[2][1], set[3][1]));
			t = 5;
			check(a, b);
			if (set[0][0] + set[1][0] > set[2][0] + set[3][0]) {
				a = set[0][0] + set[1][0];
				if (set[2][0] < set[0][0] && set[0][1] < set[1][1]
						|| set[3][0] < set[1][0] && set[1][1] < set[0][1])
					b = Math.max(set[0][1] + set[2][1], set[1][1] + set[3][1]);
				else
					b = Math.max(set[0][1], set[1][1])
							+ Math.max(set[2][1], set[3][1]);
			} else {
				a = set[2][0] + set[3][0];
				if (set[2][0] > set[0][0] && set[2][1] < set[3][1]
						|| set[3][0] > set[1][0] && set[3][1] < set[2][1])
					b = Math.max(set[0][1] + set[2][1], set[1][1] + set[3][1]);
				else
					b = Math.max(set[0][1], set[1][1])
							+ Math.max(set[2][1], set[3][1]);
			}

			//a = Math.max(set[0][0] + set[1][0], set[2][0] + set[3][0]);
			//b = Math.max(set[0][1] + set[2][1], set[1][1] + set[3][1]);
			t = 6;
			check(a, b);
			return;
		}
		for (int i = 0; i < 4; ++i)
			if (!vis[i]) {
				vis[i] = true;
				set[now][0] = rec[i][0];
				set[now][1] = rec[i][1];
				dfs(now + 1);
				set[now][0] = rec[i][1];
				set[now][1] = rec[i][0];
				dfs(now + 1);
				vis[i] = false;
			}
	}
	public static class recsort implements Comparator{
		public int compare(Object o1, Object o2) {
		    return toInt(o1) - toInt(o2);
		  }
		private int toInt(Object o) {
		    int[] str = (int[]) o;
		    return str[0];
		  }
	}
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("packrec.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"packrec.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		for (int i = 0; i < 4; ++i) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			rec[i][0] = Integer.parseInt(st.nextToken());
			rec[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		out.println(best);
		Arrays.sort(ans, 0, n, new recsort());
		out.println(ans[0][0]+" "+ans[0][1]);
		for (int i = 1; i < n; ++i)
			if (ans[i][0] != ans[i-1][0])
				out.println(ans[i][0]+" "+ans[i][1]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
