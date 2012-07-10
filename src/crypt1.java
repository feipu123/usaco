/*
ID: czpcxfz1
LANG: JAVA
TASK: crypt1
 */
import java.io.*;
import java.util.*;

public class crypt1 {
	public static int[] num;
	public static boolean[] h;
	public static boolean check(int x, int y) {
		if (x >= y) return false;
		if (x < y/10) return false;
		while (x > 0) {
			if (!h[x%10]) return false;
			x = x / 10;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"crypt1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int n = Integer.parseInt(st.nextToken()), co = 0;
		st = new StringTokenizer(f.readLine());
		num = new int[12];
		h = new boolean[12];
		for (int i = 0; i < n; ++i) {
			num[i] = Integer.parseInt(st.nextToken());
			h[num[i]] = true;
		}
		for (int a = 0; a < n; ++a)
			for (int b = 0; b < n; ++b)
				for (int c = 0; c < n; ++c)
					for (int d = 0; d < n; ++d)
						for (int e = 0; e < n; ++e)
							if (check((num[a] * 100 + num[b] * 10 + num[c]) * num[d], 1000)
									&& check((num[a] * 100 + num[b] * 10 + num[c]) * num[e], 1000)
									&& check((num[a] * 100 + num[b] * 10 + num[c])
											* (num[d] * 10 + num[e]), 10000))
								++co;
		out.println(co);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
