/*
ID: czpcxfz1
LANG: JAVA
TASK: barn1
 */
import java.io.*;
import java.util.*;

public class barn1 {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"barn1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int m = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st
				.nextToken()), c = Integer.parseInt(st.nextToken());
		int[] ba = new int[5000], spa = new int[5000];
		for (int i = 0; i < c; ++i) {
			st = new StringTokenizer(f.readLine());
			ba[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ba, 0, c);
		for (int i = 0; i < c - 1; ++i) {
			spa[i] = ba[i + 1] - ba[i] - 1;
		}
		Arrays.sort(spa, 0, c - 1);
		int sum = ba[c - 1] - ba[0] + 1;
		--m;
		for (int i = c - 2; i >= 0; --i) {
			if (m == 0) break;
			sum -= spa[i];
			--m;
		}
		out.println(sum);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
