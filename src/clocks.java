/*
ID: czpcxfz1
LANG: JAVA
TASK: clocks
*/
import java.io.*;
import java.util.*;

public class clocks {
	public static int[][] di = {{},
								 {1,1,0, 1,1,0, 0,0,0},
								 {1,1,1, 0,0,0, 0,0,0},
								 {0,1,1, 0,1,1, 0,0,0},
								 {1,0,0, 1,0,0, 1,0,0},
								 {0,1,0, 1,1,1, 0,1,0},
								 {0,0,1, 0,0,1, 0,0,1},
								 {0,0,0, 1,1,0, 1,1,0},
								 {0,0,0, 0,0,0, 1,1,1},
								 {0,0,0, 0,1,1, 0,1,1}};
	public static int[] path = new int[100];
	public static int[] cl = new int[9];
	public static int m = 0;
	public static boolean check() {
		for (int i = 0; i < 9; ++i) 
			if (cl[i] != 0) return false;
		return true;
	}
	public static boolean dfs(int now, int limit) {
		if (check()) {
			m = now;
			return true; 
		}
		if (now > limit) return false;
		for (int i = 1; i <= 9; ++i) {
			for (int j = 0; j < 9; ++j) 
				cl[j] = (cl[j] + di[i][j]) % 4;
			path[now] = i;
			if (dfs(now + 1, limit)) return true;
			for (int j = 0; j < 9; ++j)
				cl[j] = (cl[j] - di[i][j] + 4) % 4;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("clocks.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"clocks.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st;
		for (int i = 0; i < 3; ++i) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < 3; ++j) {
				cl[i*3+j] = Integer.parseInt(st.nextToken()) / 3 % 4;
			}
		}
		for (int i = 0; i < 100; ++i)
			if (dfs(0, i)) break;
		for (int i = 0; i < m - 1; ++i) 
			out.print(path[i] + " ");
		out.println(path[m - 1]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
