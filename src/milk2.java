/*
ID: czpcxfz1
LANG: JAVA
TASK: milk2
 */
import java.io.*;
import java.util.*;

public class milk2 {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk2.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int n = Integer.parseInt(st.nextToken());
		int[][] ti = new int[n][2];
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(f.readLine());
			ti[i][0] = Integer.parseInt(st.nextToken());
			ti[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ti, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] > b[0])
					return 1;
				else if (a[0] < b[0])
					return -1;
				else
					return 0;
			}
		});
		int sta = ti[0][0], enn = ti[0][0], sta2 = ti[0][0], ans = 0, ans2 = 0;
		for (int i = 0; i < n; ++i) {
			if (enn < ti[i][0]) {
				ans = Math.max(ans, enn - sta);
				sta = ti[i][0];
				enn = ti[i][1];
			} else
				enn = Math.max(enn, ti[i][1]);
			if (sta2 < ti[i][0])
				ans2 = Math.max(ans2, ti[i][0] - sta2);
			sta2 = Math.max(sta2, ti[i][1]);
		}
		ans = Math.max(ans, enn - sta);
		out.println(ans+" "+ans2);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
