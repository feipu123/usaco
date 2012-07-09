/*
ID: czpcxfz1
LANG: JAVA
TASK: friday
 */
import java.io.*;
import java.util.*;

public class friday {
	static int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int isleap(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return 1;
		else
			return 0;
	}

	public static void friday_main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"friday.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int n = Integer.parseInt(st.nextToken()), sta = 1;
		int[] cnt = { 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < n; ++i)
			for (int j = 0; j < 12; ++j) {
				++cnt[(sta + 12) % 7];
				sta += j == 1 ? month[1] + isleap(1900 + i) : month[j];
				sta %= 7;
			}
		out.print(cnt[6]);
		for (int i = 0; i < 6; ++i) {
			out.print(' ');
			out.print(cnt[i]);
		}
		out.println();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
